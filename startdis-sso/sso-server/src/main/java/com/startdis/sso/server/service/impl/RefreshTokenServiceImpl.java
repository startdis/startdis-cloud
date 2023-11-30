package com.startdis.sso.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sso.domain.model.entity.RefreshToken;
import com.startdis.sso.infra.mapper.RefreshTokenMapper;
import com.startdis.sso.server.service.RefreshTokenService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 刷新令牌表(RefreshToken)服务实现层
 */
@Service("refreshTokenService")
public class RefreshTokenServiceImpl extends ServiceImpl<RefreshTokenMapper, RefreshToken> implements RefreshTokenService {

}

