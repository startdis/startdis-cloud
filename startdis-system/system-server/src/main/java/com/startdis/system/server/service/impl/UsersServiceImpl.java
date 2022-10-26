package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.Users;
import com.startdis.system.infra.mapper.UsersMapper;
import com.startdis.system.server.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
