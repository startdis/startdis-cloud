package com.startdis.sso.api.fallback;

import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sso.api.service.SsoServiceApi;
import com.startdis.sso.domain.model.query.AppInfoQuery;
import com.startdis.sso.domain.model.vo.AppInfoVO;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sys.domain.model.vo.UserInfoVO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import feign.Response;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Slf4j
public class SsoServiceFallback implements SsoServiceApi {
    @Setter
    private Throwable cause;


    @Override
    public ResultBean<UserTokenVO> getUserInfoByToken(String authToken) {
        log.error(" getUserInfoByToken = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<OAuth2VO> getToken(String oauthType, String appKey, String appSecret, String oauthCode, String refreshToken) {
        log.error(" getToken = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<Boolean> checkToken(String accessToken) {
        log.error(" checkToken = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean logout(String authToken) {
        log.error(" logout = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<AppInfoVO>> appInfoList(AppInfoQuery ssoAppInfoQuery) {
        log.error(" appInfoList = {}", cause.getMessage());
        return null;
    }
}
