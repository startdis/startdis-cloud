package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.SocialUser;
import com.startdis.system.infra.mapper.SocialUserMapper;
import com.startdis.system.server.service.SocialUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 社交用户表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class SocialUserServiceImpl extends ServiceImpl<SocialUserMapper, SocialUser> implements SocialUserService {

}
