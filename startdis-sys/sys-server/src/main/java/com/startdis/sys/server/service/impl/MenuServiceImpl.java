package com.startdis.sys.server.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.bean.TreeBuild;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.entity.RoleMenu;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserRole;
import com.startdis.sys.domain.model.query.UserMenuTreeQuery;
import com.startdis.sys.domain.model.tree.MenuTree;
import com.startdis.sys.infra.mapper.MenuMapper;
import com.startdis.sys.server.service.MenuService;
import com.startdis.sys.server.service.RoleMenuService;
import com.startdis.sys.server.service.UserRoleService;
import com.startdis.sys.server.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 菜单表 MenuService
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleMenuService roleMenuService;

    @Resource
    private UserService userService;

    @Override
    public List<Menu> getUserMenuByAppCode(UserMenuTreeQuery userMenuTreeQuery) {
        String userId = userMenuTreeQuery.getUserId();
        String appCode = userMenuTreeQuery.getAppCode();
        // 1.获取用户角色
        List<UserRole> userRoles = userRoleService.getBaseMapper().selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, userId));
        if (CollectionUtil.isEmpty(userRoles)) {
            return new ArrayList<>();
        }
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        // 2.根据角色获取用户菜单 过滤菜单信息
        List<RoleMenu> roleMenus = roleMenuService.getBaseMapper().selectList(Wrappers.<RoleMenu>lambdaQuery().in(RoleMenu::getRoleId, roleIds));
        if (CollectionUtil.isEmpty(roleMenus)) {
            return new ArrayList<>();
        }
        List<String> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        List<Menu> menus = this.baseMapper.selectList(Wrappers.<Menu>lambdaQuery().eq(Menu::getAppCode, appCode).in(Menu::getId, menuIds).orderByDesc(Menu::getMenuSort));
        return menus;
    }

    @Override
    public ResultBean<List<Map<String, Object>>> getAppCodeMenuList() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Menu> menuList = this.list(Wrappers.<Menu>lambdaQuery().orderByAsc(Menu::getMenuSort));
        //获取所有的应用
        Set<String> appNames = menuList.stream().map(Menu::getAppName).collect(Collectors.toSet());
        //根据应用名称分组
        Map<String, List<Menu>> menuMap = menuList.stream().collect(Collectors.groupingBy(Menu::getAppName));
        //填充每个对应对应的菜单列表
        for (String appName : appNames) {
            Map<String, Object> map = new HashMap<>();
            List<Menu> menus = menuMap.get(appName);
            List<MenuTree> menuTrees = BeanCopyKits.coverList(menus, MenuTree.class);
            if (CollectionUtil.isNotEmpty(menuTrees)) {
                String rootId = "0";
                // 创建树形结构并返回
                TreeBuild treeBuild = new TreeBuild(rootId, menuTrees);
                map.put("menus",treeBuild.buildTree());
            }
            map.put("appName",appName);
            map.put("appCode",menus.get(0).getAppCode());
            list.add(map);
        }
        return ResultBean.success(list);
    }

    @Override
    public ResultBean<List<Menu>> getAllMenuByUser(String userCode) {
        User user = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        String userId = user.getId();
        List<UserRole> userRoles = userRoleService.getBaseMapper().selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, userId));
        if (CollectionUtil.isEmpty(userRoles)) {
            return ResultBean.success(new ArrayList<>());
        }
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        // 2.根据角色获取用户菜单 过滤菜单信息
        List<RoleMenu> roleMenus = roleMenuService.getBaseMapper().selectList(Wrappers.<RoleMenu>lambdaQuery().in(RoleMenu::getRoleId, roleIds));
        if (CollectionUtil.isEmpty(roleMenus)) {
            return ResultBean.success(new ArrayList<>());
        }
        List<String> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        List<Menu> menus = this.baseMapper.selectList(Wrappers.<Menu>lambdaQuery().in(Menu::getId, menuIds));
        return ResultBean.success(menus);
    }
}
