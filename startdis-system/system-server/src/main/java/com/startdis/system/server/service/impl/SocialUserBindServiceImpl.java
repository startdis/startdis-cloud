package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.SocialUserBind;
import com.startdis.system.infra.mapper.SocialUserBindMapper;
import com.startdis.system.server.service.SocialUserBindService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 社交用户绑定表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class SocialUserBindServiceImpl extends ServiceImpl<SocialUserBindMapper, SocialUserBind> implements SocialUserBindService {

}
