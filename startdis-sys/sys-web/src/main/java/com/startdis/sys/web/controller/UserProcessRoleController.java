package com.startdis.sys.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.UserProcessRoleConverter;
import com.startdis.sys.domain.model.dto.post.UserProcessRolePostDTO;
import com.startdis.sys.domain.model.dto.put.UserProcessRolePutDTO;
import com.startdis.sys.domain.model.entity.ProcessRole;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserProcessRole;
import com.startdis.sys.domain.model.query.UserProcessRoleQuery;
import com.startdis.sys.domain.model.vo.UserProcessRoleVO;
import com.startdis.sys.server.service.ProcessRoleDeptService;
import com.startdis.sys.server.service.ProcessRoleService;
import com.startdis.sys.server.service.UserProcessRoleService;
import com.startdis.sys.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表(UserProcessRole)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "UserProcessRole", tags = {"用户流程角色表"})
@RequestMapping("userProcessRole")
public class UserProcessRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserProcessRoleService userProcessRoleService;

    @Resource
    private ProcessRoleDeptService processRoleDeptService;

    @Resource
    private ProcessRoleService processRoleService;

    @Resource
    private UserService userService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<UserProcessRoleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        UserProcessRole userProcessRole = userProcessRoleService.getById(id);
        //处理格式转换
        UserProcessRoleVO userProcessRoleVO = UserProcessRoleConverter.INSTANT.entityToVO(userProcessRole);
        return ResultBean.success(userProcessRoleVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userProcessRoleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<UserProcessRoleVO>> list(@RequestBody UserProcessRoleQuery userProcessRoleQuery) {
        //处理格式转换
        UserProcessRole userProcessRole = UserProcessRoleConverter.INSTANT.queryToEntity(userProcessRoleQuery);
        //执行分页查询
        List<UserProcessRole> listResult = userProcessRoleService.list(new QueryWrapper<>(userProcessRole));
        return ResultBean.success(BeanCopyKits.coverList(listResult, UserProcessRoleVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery            分页对象
     * @param userProcessRoleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<UserProcessRoleVO>> page(PageQuery pageQuery, UserProcessRoleQuery userProcessRoleQuery) {
        //处理分页条件
        Page<UserProcessRole> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        UserProcessRole userProcessRole = UserProcessRoleConverter.INSTANT.queryToEntity(userProcessRoleQuery);
        //执行分页查询
        Page<UserProcessRole> pageResult = userProcessRoleService.page(page, new QueryWrapper<>(userProcessRole));
        PagerBean<UserProcessRoleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), UserProcessRoleVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param userProcessRoleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated UserProcessRolePostDTO userProcessRoleDTO) {
        //处理格式转换
        UserProcessRole userProcessRole = UserProcessRoleConverter.INSTANT.postDtoToEntity(userProcessRoleDTO);
        //执行数据保存
        return ResultBean.success(userProcessRoleService.save(userProcessRole));
    }

    /**
     * 修改数据
     *
     * @param userProcessRoleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated UserProcessRolePutDTO userProcessRoleDTO) {
        //处理格式转换
        UserProcessRole userProcessRole = UserProcessRoleConverter.INSTANT.putDtoToEntity(userProcessRoleDTO);
        //执行数据更新
        return ResultBean.success(userProcessRoleService.updateById(userProcessRole));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(userProcessRoleService.removeByIds(ids));
    }

    @PostMapping("/assignProcessRoleUser")
    @ApiOperation("分配角色用户")
    public ResultBean<Boolean> assignProcessRoleUser(@RequestBody UserProcessRolePostDTO userProcessRoleDTO) {
        List<UserProcessRole> userProcessRoles = new ArrayList<>();
        String processRoleDeptId = userProcessRoleDTO.getProcessRoleDeptId();
        List<String> userIds = userProcessRoleDTO.getUserIds();
        ProcessRoleDept processRoleDept = processRoleDeptService.getById(processRoleDeptId);
        ProcessRole processRole = processRoleService.getById(processRoleDept.getProcessRoleId());
        // 如果是分配部门负责人角色的用户，用户不能多选，只能单选
        if ("head".equals(processRole.getRoleCode())){
            if (userIds.size() > 1){
                return ResultBean.error("分配失败,该业务角色只能绑定一个用户！");
            }
        }
        for (String userId : userIds) {
            UserProcessRole userProcessRole = new UserProcessRole();
            userProcessRole.setUserId(userId);
            userProcessRole.setProcessRoleDeptId(processRoleDeptId);
            userProcessRole.setStatus(1);
            userProcessRole.setDeleted(0);
            userProcessRoles.add(userProcessRole);
        }
        //执行数据保存 先删除后新增
        userProcessRoleService.getBaseMapper().delete(Wrappers.<UserProcessRole>lambdaQuery().eq(UserProcessRole::getProcessRoleDeptId, processRoleDeptId));
        return ResultBean.success(userProcessRoleService.saveBatch(userProcessRoles));
    }

    @PostMapping("/getAssignProcessRoleUser")
    @ApiOperation("获取角色分配用户")
    public ResultBean<List<User>> getAssignProcessRoleUser(@RequestBody UserProcessRolePostDTO userProcessRoleDTO){
        String processRoleDeptId = userProcessRoleDTO.getProcessRoleDeptId();
        List<UserProcessRole> userProcessRoles = userProcessRoleService.getBaseMapper().selectList(Wrappers.<UserProcessRole>lambdaQuery().eq(UserProcessRole::getProcessRoleDeptId, processRoleDeptId));
        if (CollectionUtil.isNotEmpty(userProcessRoles)){
            List<String> userIds = userProcessRoles.stream().map(UserProcessRole::getUserId).collect(Collectors.toList());
            List<User> users = userService.getBaseMapper().selectList(Wrappers.<User>lambdaQuery().in(User::getId, userIds));
            return ResultBean.success(users);
        }
        return ResultBean.success(Collections.EMPTY_LIST);
    }
}

