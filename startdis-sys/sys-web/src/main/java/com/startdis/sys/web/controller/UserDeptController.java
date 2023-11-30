package com.startdis.sys.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.string.StringKits;
import com.startdis.sys.domain.model.dto.post.UserDeptAuthUserDTO;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserDept;
import com.startdis.sys.domain.model.query.UserDeptAuthUserQuery;
import com.startdis.sys.domain.model.vo.UserVO;
import com.startdis.sys.server.service.UserDeptService;
import com.startdis.sys.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户部门表(UserDept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "UserDept", tags = {"用户部门表"})
@RequestMapping("userDept")
public class UserDeptController {
    
    /**
     * 服务对象
     */
    @Resource
    private UserDeptService userDeptService;
    
    @Resource
    private UserService userService;
    
    
    /**
     * 批量授权
     *
     * @param userDeptDTO 实体对象
     * @return 批量授权结果
     */
    @PostMapping(value = "/authUser")
    @ApiOperation("批量授权用户")
    @RbacPermission
    public ResultBean<Boolean> auth(@RequestBody @Validated UserDeptAuthUserDTO userDeptDTO) {
        //新增授权
        List<UserDept> list = new ArrayList<>();
        for (String userId : userDeptDTO.getUserIds()) {
            UserDept build = UserDept.builder().userId(userId).deptId(userDeptDTO.getDeptId()).build();
            list.add(build);
        }
        return ResultBean.success(userDeptService.saveBatch(list));
    }
    
    /**
     * 批量取消授权
     *
     * @param userDeptDTO 实体对象
     * @return 批量取消授权结果
     */
    @PutMapping(value = "/delAuthUser")
    @ApiOperation("批量取消授权用户")
    @RbacPermission
    public ResultBean<Boolean> delAuth(@RequestBody @Validated UserDeptAuthUserDTO userDeptDTO) {
        //删除授权
        LambdaQueryWrapper<UserDept> queryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, userDeptDTO.getDeptId())
                .in(UserDept::getUserId, userDeptDTO.getUserIds());
        return ResultBean.success(userDeptService.remove(queryWrapper));
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userDeptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/listAuthUser")
    @ApiOperation("查询所有部门授权用户")
    @RbacPermission
    public ResultBean<List<UserVO>> listAuthUser(UserDeptAuthUserQuery userDeptQuery) {
        List<UserVO> userVOS = null;
        if (StringKits.isEmpty(userDeptQuery.getAuthStatus()) || StringKits.isEmpty(userDeptQuery.getDeptId())) {
            throw new BusinessException("40001", "授权状态或部门信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userDeptQuery.getAuthStatus())) {
            //查中间表，查询出部门已授权的用户
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper =
                    Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, userDeptQuery.getDeptId());
            List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userDepts)) {
                Set<String> userIds = userDepts.stream().map(UserDept::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userDeptQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userDeptQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userDeptQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userDeptQuery.getUserName());
                }
                userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
            }
        }
        //查询未授权的用户信息
        if ("0".equals(userDeptQuery.getAuthStatus())) {
            //查中间表，查询出部门已授权的用户
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper =
                    Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, userDeptQuery.getDeptId());
            List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
            //如果这个部门还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userDepts)) {
                return ResultBean.success(BeanCopyKits.coverList(userService.list(), UserVO.class));
            }
            //查用户表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个部门没有授权的用户信息
            Set<String> userIds = userDepts.stream().map(UserDept::getUserId).collect(Collectors.toSet());
            LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
            if(StringKits.isNotEmpty(userDeptQuery.getUserCode())){
                userQueryWrapper.eq(User::getUserCode, userDeptQuery.getUserCode());
            }
            if(StringKits.isNotEmpty(userDeptQuery.getUserName())){
                userQueryWrapper.like(User::getUserName, userDeptQuery.getUserName());
            }
            userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
            //组装用户中间表信息
            for (UserVO userVO : userVOS) {
                userService.assembleUserVO(userVO);
            }
        }
        return ResultBean.success(userVOS);
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param userDeptQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/pageAuthUser")
    @ApiOperation("分页查询部门授权用户")
    @RbacPermission
    public ResultBean<PagerBean<UserVO>> pageAuthUser(PageQuery pageQuery, UserDeptAuthUserQuery userDeptQuery) {
        PagerBean<UserVO> pageBean = null;
        //处理分页条件
        Page<User> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        if (StringKits.isEmpty(userDeptQuery.getAuthStatus()) || StringKits.isEmpty(userDeptQuery.getDeptId())) {
            throw new BusinessException("40001", "授权状态或部门信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userDeptQuery.getAuthStatus())) {
            //查中间表，查询出部门已授权的用户信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper =
                    Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, userDeptQuery.getDeptId());
            List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userDepts)) {
                Set<String> userIds = userDepts.stream().map(UserDept::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userDeptQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userDeptQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userDeptQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userDeptQuery.getUserName());
                }
                Page<User> pageResult = userService.page(page, userQueryWrapper);
                List<UserVO> userVOS = BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),userVOS);
            }
        }
        //查询未授权的用户信息
        if ("0".equals(userDeptQuery.getAuthStatus())) {
            //查中间表，查询出部门已授权的用户信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper =
                    Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, userDeptQuery.getDeptId());
            List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
            //如果这个部门还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userDepts)) {
                Page<User> pageResult = userService.page(page);
                return ResultBean.success(new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class)));
            }
            //查岗位表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个部门没有授权的用户信息
            if (CollectionUtil.isNotEmpty(userDepts)) {
                Set<String> userIds = userDepts.stream().map(UserDept::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
                if(StringKits.isNotEmpty(userDeptQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userDeptQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userDeptQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userDeptQuery.getUserName());
                }
                Page<User> pageResult = userService.page(page, userQueryWrapper);
                List<UserVO> userVOS = BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),userVOS);
            }
        }
        return ResultBean.success(pageBean);
    }
}

