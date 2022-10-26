package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.UserRole;
import com.startdis.system.infra.mapper.UserRoleMapper;
import com.startdis.system.server.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色中间表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
