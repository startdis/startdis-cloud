package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.TokenInfo;
import com.startdis.sys.infra.mapper.TokenInfoMapper;
import com.startdis.sys.server.service.TokenInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表(TokenInfo)服务实现层
 */
@Service("tokenInfoService")
public class TokenInfoServiceImpl extends ServiceImpl<TokenInfoMapper, TokenInfo> implements TokenInfoService {

}

