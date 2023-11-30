package com.startdis.sys.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.query.UserMenuTreeQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 菜单表 MenuService
 */
public interface MenuService extends IService<Menu> {

    List<Menu> getUserMenuByAppCode(UserMenuTreeQuery userMenuTreeQuery);

    ResultBean<List<Map<String, Object>>> getAppCodeMenuList();

    ResultBean<List<Menu>> getAllMenuByUser(String userCode);
}
