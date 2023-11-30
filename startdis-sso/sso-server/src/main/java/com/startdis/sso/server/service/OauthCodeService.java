package com.startdis.sso.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sso.domain.model.dto.post.AuthorizePostDTO;
import com.startdis.sso.domain.model.entity.OauthCode;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sys.domain.model.vo.UserTokenVO;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 授权码表(OauthCode)服务定义层
 */
public interface OauthCodeService extends IService<OauthCode> {
    OAuth2VO getAuthCode(AuthorizePostDTO authorizePostDTO, UserTokenVO userToken);

    void cacheAuthCode(String oauthCode, UserTokenVO userToken);

}
