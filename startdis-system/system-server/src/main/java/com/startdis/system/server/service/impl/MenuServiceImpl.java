package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.Menu;
import com.startdis.system.infra.mapper.MenuMapper;
import com.startdis.system.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
