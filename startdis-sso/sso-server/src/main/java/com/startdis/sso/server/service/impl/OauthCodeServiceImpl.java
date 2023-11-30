package com.startdis.sso.server.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.redis.service.RedisService;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sso.domain.model.dto.post.AuthorizePostDTO;
import com.startdis.sso.domain.model.entity.OauthCode;
import com.startdis.sso.domain.model.enums.RedisKeysEnum;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sso.infra.mapper.OauthCodeMapper;
import com.startdis.sso.server.service.OauthCodeService;
import com.startdis.sso.server.util.AppUtils;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 授权码表(OauthCode)服务实现层
 */
@Service("oauthCodeService")
public class OauthCodeServiceImpl extends ServiceImpl<OauthCodeMapper, OauthCode> implements OauthCodeService {
    @Resource
    private RedisService redisService;

    @Override
    public OAuth2VO getAuthCode(AuthorizePostDTO authorizePostDTO, UserTokenVO userToken) {
        // 获取授权码(appId+UserId)
        String authCode = AppUtils.getAuthCode(authorizePostDTO.getAppKey(),userToken.getUser().getId());
        // authCode落地数据库
        OauthCode oauthCode = OauthCode.builder().id(IdUtil.getSnowflake().nextIdStr())
                .authCode(authCode).status(1).build();
        this.save(oauthCode);
        // authCode同步到缓存
        cacheAuthCode(authCode, userToken);
        // 组装响应
        return OAuth2VO.builder().redirectUrl(authorizePostDTO.getRedirectUrl()).state(authorizePostDTO.getState()).oauthCode(authCode).build();
    }

    @Override
    public void cacheAuthCode(String oauthCode, UserTokenVO userToken) {
        //authCode存到Redis，生命周期为30分钟
        redisService.hmset(RedisKeysEnum.AUTH_CODE.getKey(oauthCode), BeanCopyKits.entityToMap(userToken), 60 * 30);
    }

}

