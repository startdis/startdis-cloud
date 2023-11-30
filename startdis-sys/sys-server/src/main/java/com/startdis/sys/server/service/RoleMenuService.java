package com.startdis.sys.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sys.domain.model.entity.RoleMenu;
import com.startdis.sys.domain.model.vo.MenuVO;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表 RoleMenuService
 */
public interface RoleMenuService extends IService<RoleMenu> {
    /**
     * 查询当前角色所有授权的菜单信息
     * @param roleId
     * @return
     */
    List<MenuVO> listAuthMenu(String roleId);

}
