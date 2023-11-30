package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.ProcessRoleConverter;
import com.startdis.sys.domain.model.dto.post.ProcessRolePostDTO;
import com.startdis.sys.domain.model.dto.put.ProcessRolePutDTO;
import com.startdis.sys.domain.model.entity.ProcessRole;
import com.startdis.sys.domain.model.query.ProcessRoleQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleVO;
import com.startdis.sys.server.service.ProcessRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表(ProcessRole)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "ProcessRole", tags = {"流程角色表"})
@RequestMapping("processRole")
public class ProcessRoleController {
    /**
     * 服务对象
     */
    @Resource
    private ProcessRoleService processRoleService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<ProcessRoleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        ProcessRole processRole = processRoleService.getById(id);
        //处理格式转换
        ProcessRoleVO processRoleVO = ProcessRoleConverter.INSTANT.entityToVO(processRole);
        return ResultBean.success(processRoleVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param processRoleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<ProcessRoleVO>> list(@RequestBody ProcessRoleQuery processRoleQuery) {
        //处理格式转换
        ProcessRole processRole = ProcessRoleConverter.INSTANT.queryToEntity(processRoleQuery);
        //执行分页查询
        List<ProcessRole> listResult = processRoleService.list(new QueryWrapper<>(processRole));
        return ResultBean.success(BeanCopyKits.coverList(listResult, ProcessRoleVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param processRoleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<ProcessRoleVO>> page(PageQuery pageQuery, ProcessRoleQuery processRoleQuery) {
        //处理分页条件
        Page<ProcessRole> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        ProcessRole processRole = ProcessRoleConverter.INSTANT.queryToEntity(processRoleQuery);
        //执行分页查询
        Page<ProcessRole> pageResult = processRoleService.page(page, new QueryWrapper<>(processRole));
        PagerBean<ProcessRoleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), ProcessRoleVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param processRoleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated ProcessRolePostDTO processRoleDTO) {
        //处理格式转换
        ProcessRole processRole = ProcessRoleConverter.INSTANT.postDtoToEntity(processRoleDTO);
        //执行数据保存
        return ResultBean.success(processRoleService.save(processRole));
    }

    /**
     * 修改数据
     *
     * @param processRoleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated ProcessRolePutDTO processRoleDTO) {
        //处理格式转换
        ProcessRole processRole = ProcessRoleConverter.INSTANT.putDtoToEntity(processRoleDTO);
        //执行数据更新
        return ResultBean.success(processRoleService.updateById(processRole));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除数据")
    @RbacPermission
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(processRoleService.removeByIds(ids));
    }

    @GetMapping("/getUserIdByDeptAndRoldCode")
    @ApiOperation("获取部门流程角色用户")
    public String getUserIdByDeptAndRoldCode(@RequestParam("deptId") String deptId,@RequestParam("roleCode") String roleCode){
        return processRoleService.getUserIdByDeptAndRoldCode(deptId,roleCode);
    }
}

