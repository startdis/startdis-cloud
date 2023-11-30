package com.startdis.sso.api.client;

import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sso.domain.model.query.AppInfoQuery;
import com.startdis.sso.domain.model.vo.AppInfoVO;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SsoApi {

    @GetMapping("getUserToken")
    ResultBean<UserTokenVO> getUserInfoByToken(@RequestParam(value = "authToken") String authToken);

    @GetMapping("oauth2/token")
    ResultBean<OAuth2VO> getToken(@RequestParam(value = "grant_type") String oauthType,
                                  @RequestParam(value = "client_id") String appKey,
                                  @RequestParam(value = "client_secret") String appSecret,
                                  @RequestParam(value = "code", required = false) String oauthCode,
                                  @RequestParam(value = "refresh_token", required = false) String refreshToken);

    @GetMapping("oauth2/check")
    ResultBean<Boolean> checkToken(@RequestParam(value = "access_token", required = false) String accessToken);

    @PostMapping("logout")
    ResultBean logout(@RequestParam(value = "authToken") String authToken);

    @PostMapping(value = "appInfo/list")
    ResultBean<List<AppInfoVO>> appInfoList(@RequestBody AppInfoQuery ssoAppInfoQuery);
}
