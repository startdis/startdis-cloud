package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.UserProcessRole;
import com.startdis.sys.infra.mapper.UserProcessRoleMapper;
import com.startdis.sys.server.service.UserProcessRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表(UserProcessRole)服务实现层
 */
@Service("userProcessRoleService")
public class UserProcessRoleServiceImpl extends ServiceImpl<UserProcessRoleMapper, UserProcessRole> implements UserProcessRoleService {

}

