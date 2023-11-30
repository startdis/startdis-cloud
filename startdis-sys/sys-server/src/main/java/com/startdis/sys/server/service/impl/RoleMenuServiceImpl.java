package com.startdis.sys.server.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.entity.RoleMenu;
import com.startdis.sys.domain.model.vo.MenuVO;
import com.startdis.sys.infra.mapper.RoleMenuMapper;
import com.startdis.sys.server.service.MenuService;
import com.startdis.sys.server.service.RoleMenuService;
import com.startdis.sys.server.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表 RoleMenuService
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

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
     * 查询当前角色所有授权的菜单信息
     * @param roleId
     * @return
     */
    @Override
    public List<MenuVO> listAuthMenu(String roleId) {
        List<MenuVO> menuVOS = null;
        //查中间表，查询出角色已授权的菜单
        LambdaQueryWrapper<RoleMenu> roleMenuQueryWrapper =
                Wrappers.lambdaQuery(RoleMenu.class).eq(RoleMenu::getRoleId, roleId);
        List<RoleMenu> roleMenus = roleMenuService.list(roleMenuQueryWrapper);
        //查菜单表,查询出菜单的详情信息表
        if (CollectionUtil.isNotEmpty(roleMenus)) {
            Set<String> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toSet());
            LambdaQueryWrapper<Menu> menuQueryWrapper = Wrappers.lambdaQuery(Menu.class).in(Menu::getId, menuIds);
            menuVOS = BeanCopyKits.coverList(menuService.list(menuQueryWrapper), MenuVO.class);
        }
        return menuVOS;
    }
}
