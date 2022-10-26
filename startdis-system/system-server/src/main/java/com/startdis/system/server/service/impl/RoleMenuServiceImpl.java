package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.RoleMenu;
import com.startdis.system.infra.mapper.RoleMenuMapper;
import com.startdis.system.server.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单中间表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
