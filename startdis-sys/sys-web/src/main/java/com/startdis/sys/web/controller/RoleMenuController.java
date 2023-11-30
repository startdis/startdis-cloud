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
import com.startdis.sys.domain.model.dto.post.AuthMenuDTO;
import com.startdis.sys.domain.model.dto.post.RoleMenuAuthMenuDTO;
import com.startdis.sys.domain.model.dto.post.RoleMenuAuthRoleDTO;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.entity.Role;
import com.startdis.sys.domain.model.entity.RoleMenu;
import com.startdis.sys.domain.model.query.RoleMenuAuthMenuQuery;
import com.startdis.sys.domain.model.query.RoleMenuAuthRoleQuery;
import com.startdis.sys.domain.model.vo.MenuVO;
import com.startdis.sys.domain.model.vo.RoleVO;
import com.startdis.sys.server.service.MenuService;
import com.startdis.sys.server.service.RoleMenuService;
import com.startdis.sys.server.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表(RoleMenu)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "RoleMenu", tags = {"角色菜单中间表"})
@RequestMapping("roleMenu")
public class RoleMenuController {
    
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;
    
    @Resource
    private RoleService roleService;
    
    @Resource
    private MenuService menuService;
    
    /**
     * 批量授权：
     *
     * @param roleMenuDTO 实体对象
     * @return 批量授权结果
     */
    @PostMapping(value = "/authRole")
    @ApiOperation("批量授权角色")
    @RbacPermission
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> authRole(@RequestBody @Validated RoleMenuAuthRoleDTO roleMenuDTO) {
        //先删除
        //LambdaQueryWrapper<RoleMenu> queryWrapper = Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getMenuId, roleMenuDTO.getMenuId());
        //roleMenuService.remove(queryWrapper);
        //后新增
        List<RoleMenu> list = new ArrayList<>();
        for (String roleId : roleMenuDTO.getRoleIds()) {
            RoleMenu build = RoleMenu.builder().roleId(roleId).menuId(roleMenuDTO.getMenuId()).build();
            list.add(build);
        }
        return ResultBean.success(roleMenuService.saveBatch(list));
    }
    
    /**
     * 批量取消授权
     *
     * @param roleMenuDTO 实体对象
     * @return 批量取消授权结果
     */
    @PutMapping(value = "/delAuthRole")
    @ApiOperation("批量取消授权角色")
    @RbacPermission
    public ResultBean<Boolean> delAuthRole(@RequestBody @Validated RoleMenuAuthRoleDTO roleMenuDTO) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getMenuId, roleMenuDTO.getMenuId())
                .in(RoleMenu::getRoleId, roleMenuDTO.getRoleIds());
        return ResultBean.success(roleMenuService.remove(queryWrapper));
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param roleMenuQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/listAuthRole")
    @ApiOperation("查询所有授权角色")
    @RbacPermission
    public ResultBean<List<RoleVO>> listAuthRole(RoleMenuAuthRoleQuery roleMenuQuery) {
        List<RoleVO> roleVOS = null;
        if (StringKits.isEmpty(roleMenuQuery.getAuthStatus()) || StringKits.isEmpty(roleMenuQuery.getMenuId())) {
            throw new BusinessException("40001", "授权状态或菜单信息不能为空！");
        }
        //查询已授权的角色信息
        if ("1".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出菜单已授权的角色
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getMenuId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查角色表,查询出角色的详情信息表
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> roleIds = roleMenus.stream().map(RoleMenu::getRoleId).collect(Collectors.toSet());
                LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getId, roleIds);
                roleVOS = BeanCopyKits.coverList(roleService.list(roleQueryWrapper), RoleVO.class);
            }
        }
        //查询未授权的角色信息
        if ("0".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出菜单已授权的角色
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getMenuId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查角色表,查询出角色的详情信息表
            //1、筛选出角色信息
            //2、筛选出这个公司的角色信息
            //3、筛选出这个菜单没有授权的角色信息
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> roleIds = roleMenus.stream().map(RoleMenu::getRoleId).collect(Collectors.toSet());
                LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).notIn(Role::getId, roleIds);
                roleVOS = BeanCopyKits.coverList(roleService.list(roleQueryWrapper), RoleVO.class);
            }
        }
        return ResultBean.success(roleVOS);
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param roleMenuQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/pageAuthRole")
    @ApiOperation("分页查询授权角色")
    @RbacPermission
    public ResultBean<PagerBean<RoleVO>> pageAuthRole(PageQuery pageQuery, RoleMenuAuthRoleQuery roleMenuQuery) {
        PagerBean<RoleVO> pageBean = null;
        //处理分页条件
        Page<Role> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        if (StringKits.isEmpty(roleMenuQuery.getAuthStatus()) || StringKits.isEmpty(roleMenuQuery.getMenuId())) {
            throw new BusinessException("40001", "授权状态或菜单信息不能为空！");
        }
        //查询已授权的角色信息
        if ("1".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出菜单已授权的角色信息
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getMenuId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查角色表,查询出角色的详情信息表
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> roleIds = roleMenus.stream().map(RoleMenu::getRoleId).collect(Collectors.toSet());
                LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getId, roleIds);
                Page<Role> pageResult = roleService.page(page, roleQueryWrapper);
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), RoleVO.class));
            }
        }
        //查询未授权的角色信息
        if ("0".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出菜单已授权的角色信息
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getMenuId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查角色表,查询出角色的详情信息表
            //1、筛选出角色信息
            //2、筛选出这个公司的角色信息
            //3、筛选出这个菜单没有授权的角色信息
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> roleIds = roleMenus.stream().map(RoleMenu::getRoleId).collect(Collectors.toSet());
                LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).notIn(Role::getId, roleIds);
                Page<Role> pageResult = roleService.page(page, roleQueryWrapper);
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), RoleVO.class));
            }
        }
        return ResultBean.success(pageBean);
    }
    
    /**
     * 批量授权：
     *
     * @param roleMenuDTO 实体对象
     * @return 批量授权结果
     */
    @PostMapping(value = "/authMenu")
    @ApiOperation("批量授权菜单")
    @RbacPermission
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> authMenu(@RequestBody @Validated RoleMenuAuthMenuDTO roleMenuDTO) {
        //先删除
        LambdaQueryWrapper<RoleMenu> queryWrapper = Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuDTO.getRoleId());
        roleMenuService.remove(queryWrapper);
        //后新增
        List<RoleMenu> list = new ArrayList<>();
        List<AuthMenuDTO> authMenus = roleMenuDTO.getAuthMenus();
        for (AuthMenuDTO authMenu : authMenus) {
            RoleMenu build = RoleMenu.builder().menuId(authMenu.getMenuId()).status(authMenu.getStatus()).roleId(roleMenuDTO.getRoleId()).build();
            list.add(build);
        }
        return ResultBean.success(roleMenuService.saveBatch(list));
    }
    
    /**
     * 批量取消授权
     *
     * @param roleMenuDTO 实体对象
     * @return 批量取消授权结果
     */
    /*@PutMapping(value = "/delAuthMenu")
    @ApiOperation("批量取消授权菜单")
    public ResultBean<Boolean> delAuthMenu(@RequestBody @Validated RoleMenuAuthMenuDTO roleMenuDTO) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuDTO.getRoleId())
                .in(RoleMenu::getMenuId, roleMenuDTO.getMenuIds());
        return ResultBean.success(roleMenuService.remove(queryWrapper));
    }*/
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param roleMenuQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/listAuthMenu")
    @ApiOperation("查询所有授权菜单")
    @RbacPermission
    public ResultBean<List<MenuVO>> listAuthMenu(RoleMenuAuthMenuQuery roleMenuQuery) {
        if (StringKits.isEmpty(roleMenuQuery.getAuthStatus()) || StringKits.isEmpty(roleMenuQuery.getRoleId())) {
            throw new BusinessException("40001", "授权状态或角色信息不能为空！");
        }
        //查询当前角色所有授权的菜单信息
        List<MenuVO> menuVOS = roleMenuService.listAuthMenu(roleMenuQuery.getRoleId());
        return ResultBean.success(menuVOS);
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param roleMenuQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/pageAuthMenu")
    @ApiOperation("分页查询授权角色")
    @RbacPermission
    public ResultBean<PagerBean<MenuVO>> pageAuthMenu(PageQuery pageQuery, RoleMenuAuthMenuQuery roleMenuQuery) {
        PagerBean<MenuVO> pageBean = null;
        //处理分页条件
        Page<Menu> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        if (StringKits.isEmpty(roleMenuQuery.getAuthStatus()) || StringKits.isEmpty(roleMenuQuery.getRoleId())) {
            throw new BusinessException("40001", "授权状态或角色信息不能为空！");
        }
        //查询已授权的菜单信息
        if ("1".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的菜单信息
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getRoleId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查菜单表,查询出菜单的详情信息表
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toSet());
                LambdaQueryWrapper<Menu> menuQueryWrapper = Wrappers.lambdaQuery(Menu.class).in(Menu::getId, menuIds);
                Page<Menu> pageResult = menuService.page(page, menuQueryWrapper);
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), MenuVO.class));
            }
        }
        //查询未授权的菜单信息
        if ("0".equals(roleMenuQuery.getAuthStatus())) {
            //查中间表，查询出角色已授权的菜单信息
            LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                    Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleMenuQuery.getRoleId());
            List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
            //查角色表,查询出菜单的详情信息表
            //1、筛选出菜单信息
            //2、筛选出这个公司的菜单信息
            //3、筛选出这个角色没有授权的菜单信息
            if (CollectionUtil.isNotEmpty(roleMenus)) {
                Set<String> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toSet());
                LambdaQueryWrapper<Menu> menuQueryWrapper = Wrappers.lambdaQuery(Menu.class).notIn(Menu::getId, menuIds);
                Page<Menu> pageResult = menuService.page(page, menuQueryWrapper);
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), MenuVO.class));
            }
        }
        return ResultBean.success(pageBean);
    }
}

