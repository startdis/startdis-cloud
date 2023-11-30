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
import com.startdis.sys.domain.model.dto.post.UserRoleAuthUserDTO;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserRole;
import com.startdis.sys.domain.model.query.UserRoleAuthUserQuery;
import com.startdis.sys.domain.model.vo.UserVO;
import com.startdis.sys.server.service.UserRoleService;
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
 * @desc 用户角色中间表(UserRole)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "UserRole", tags = {"用户角色表"})
@RequestMapping("userRole")
public class UserRoleController {

    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserService userService;


    /**
     * 批量授权
     *
     * @param userRoleDTO 实体对象
     * @return 批量授权结果
     */
    @PostMapping(value = "/authUser")
    @ApiOperation("批量授权用户")
    @RbacPermission
    public ResultBean<Boolean> auth(@RequestBody @Validated UserRoleAuthUserDTO userRoleDTO) {
        //新增授权
        List<UserRole> list = new ArrayList<>();
        for (String userId : userRoleDTO.getUserIds()) {
            UserRole build = UserRole.builder().userId(userId).roleId(userRoleDTO.getRoleId()).build();
            list.add(build);
        }
        return ResultBean.success(userRoleService.saveBatch(list));
    }

    /**
     * 批量取消授权
     *
     * @param userRoleDTO 实体对象
     * @return 批量取消授权结果
     */
    @PutMapping(value = "/delAuthUser")
    @ApiOperation("批量取消授权用户")
    @RbacPermission
    public ResultBean<Boolean> delAuth(@RequestBody @Validated UserRoleAuthUserDTO userRoleDTO) {
        //删除授权
        LambdaQueryWrapper<UserRole> queryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, userRoleDTO.getRoleId())
                .in(UserRole::getUserId, userRoleDTO.getUserIds());
        return ResultBean.success(userRoleService.remove(queryWrapper));
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userRoleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/listAuthUser")
    @ApiOperation("查询所有角色授权用户")
    @RbacPermission
    public ResultBean<List<UserVO>> listAuthUser(UserRoleAuthUserQuery userRoleQuery) {
        List<UserVO> userVOS = null;
        if (StringKits.isEmpty(userRoleQuery.getAuthStatus()) || StringKits.isEmpty(userRoleQuery.getRoleId())) {
            throw new BusinessException("40001", "授权状态或角色信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userRoleQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的用户
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper =
                    Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, userRoleQuery.getRoleId());
            List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userRoles)) {
                Set<String> userIds = userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userRoleQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userRoleQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userRoleQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userRoleQuery.getUserName());
                }
                userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
                //组装用户中间表信息
//                for (UserVO userVO : userVOS) {
//                    userService.assembleUserVO(userVO);
//                }
            }
        }
        //查询未授权的用户信息
        if ("0".equals(userRoleQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的用户
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper =
                    Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, userRoleQuery.getRoleId());
            List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
            //如果这个角色还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userRoles)) {
                return ResultBean.success(BeanCopyKits.coverList(userService.list(), UserVO.class));
            }
            //查用户表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个角色没有授权的用户信息
            Set<String> userIds = userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
            LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
            if(StringKits.isNotEmpty(userRoleQuery.getUserCode())){
                userQueryWrapper.eq(User::getUserCode, userRoleQuery.getUserCode());
            }
            if(StringKits.isNotEmpty(userRoleQuery.getUserName())){
                userQueryWrapper.like(User::getUserName, userRoleQuery.getUserName());
            }
            userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
            //组装用户中间表信息
//            for (UserVO userVO : userVOS) {
//                userService.assembleUserVO(userVO);
//            }
        }
        return ResultBean.success(userVOS);
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param userRoleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/pageAuthUser")
    @ApiOperation("分页查询角色授权用户")
    @RbacPermission
    public ResultBean<PagerBean<UserVO>> pageAuthUser(PageQuery pageQuery, UserRoleAuthUserQuery userRoleQuery) {
        PagerBean<UserVO> pageBean = null;
        //处理分页条件
        Page<User> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        if (StringKits.isEmpty(userRoleQuery.getAuthStatus()) || StringKits.isEmpty(userRoleQuery.getRoleId())) {
            throw new BusinessException("40001", "授权状态或角色信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userRoleQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的用户信息
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper =
                    Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, userRoleQuery.getRoleId());
            List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userRoles)) {
                Set<String> userIds = userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userRoleQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userRoleQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userRoleQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userRoleQuery.getUserName());
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
        if ("0".equals(userRoleQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的用户信息
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper =
                    Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, userRoleQuery.getRoleId());
            List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
            //如果这个角色还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userRoles)) {
                Page<User> pageResult = userService.page(page);
                return ResultBean.success(new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class)));
            }
            //查岗位表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个角色没有授权的用户信息
            if (CollectionUtil.isNotEmpty(userRoles)) {
                Set<String> userIds = userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
                if(StringKits.isNotEmpty(userRoleQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userRoleQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userRoleQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userRoleQuery.getUserName());
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

