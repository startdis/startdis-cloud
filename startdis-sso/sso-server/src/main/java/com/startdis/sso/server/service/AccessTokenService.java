package com.startdis.sso.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sso.domain.model.dto.post.TokenPostDTO;
import com.startdis.sso.domain.model.entity.AccessToken;
import com.startdis.sso.domain.model.vo.OAuth2VO;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 鉴权令牌表(AccessToken)服务定义层
 */
public interface AccessTokenService extends IService<AccessToken> {

    OAuth2VO getAccessTokenByAuthCode(TokenPostDTO tokenPostDTO) throws Exception;

    OAuth2VO getAccessTokenByRefreshToken(TokenPostDTO tokenPostDTO);

    Boolean checkAccessToken(String accessToken);
}
