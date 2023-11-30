package com.startdis.sso.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.util.asserts.AssertKits;
import com.startdis.comm.util.id.UUIDUtils;
import com.startdis.comm.util.object.ObjectKits;
import com.startdis.comm.redis.service.RedisService;
import com.startdis.sso.domain.model.dto.post.AuthorizePostDTO;
import com.startdis.sso.domain.model.dto.post.TokenPostDTO;
import com.startdis.sso.domain.model.enums.RedisKeysEnum;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sso.server.service.AccessTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 授权码表(OauthCode)控制层
 */
@Validated
@Controller
@ApiSort(value = 2)
@Api(value = "OauthCode", tags = {"授权管理"})
@RequestMapping("/oauth2")
public class Oauth2Controller {

    @Resource
    private RedisService redisService;

    @Resource
    private AccessTokenService accessTokenService;

    @Value("${appInfo.key}")
    private String key;

    @Value("${appInfo.secret}")
    private String secret;

    /**
     * 获取授权码
     * http://localhost:42081/oauth2/authorize?response_type=code&client_id=l3qp18bu&redirect_uri=http://localhost:42081/oauth2/callback&state=123456
     *
     * @return
     */
    @Validated
    @GetMapping("/authorize")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "response_type", value = "授权类型，此值固定为code", required = true),
            @ApiImplicitParam(name = "client_id", value = "分配给应用的appKey", required = true),
            @ApiImplicitParam(name = "redirect_uri", value = "成功授权后的回调地址", required = true),
            @ApiImplicitParam(name = "state", value = "client端的状态值", required = true)
    })
    @ApiOperation(value = "获取授权码", notes = "获取授权码")
    public String getCode(@RequestParam(value = "response_type",defaultValue = "code") String responseType,
                          @RequestParam(value = "client_id") String appKey,
                          @RequestParam(value = "redirect_uri") String redirectUrl,
                          @RequestParam(value = "state") String state) {
        // 生成临时Token
        String casualToken = UUIDUtils.simpleUuid();
        AuthorizePostDTO authorizePostDTO = AuthorizePostDTO.builder().responseType(responseType).appKey(appKey).redirectUrl(redirectUrl).state(state).build();

        redisService.hmset(RedisKeysEnum.AUTH_CODE.getKey(casualToken), ObjectKits.objectToMap(authorizePostDTO));
        String baseUrl = "http://localhost:5173/#/login?casualToken=%s";

        // 设置%s里面值
        String url = String.format(
                baseUrl,
                casualToken
        );

        //对redirect_url进行URLEncoder编码
        //String redirectUrl = ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        //try {
        //    url = URLEncoder.encode(url, "utf-8");
        //}catch(Exception e) {
        //
        //}

        // 重定向
        return "redirect:" + url;

    }

    /**
     * 获取鉴权令牌
     *
     * @return
     */
    @Validated
    @ResponseBody
    @GetMapping("/token")
    @ApiOperation(value = "获取鉴权令牌", notes = "获取鉴权令牌")
    public ResultBean<OAuth2VO> getToken(@RequestParam(value = "grant_type",defaultValue = "code") String oauthType,
                                         @RequestParam(value = "client_id",required = false) String appKey,
                                         @RequestParam(value = "client_secret",required = false) String appSecret,
                                         @RequestParam(value = "code", required = false) String oauthCode,
                                         @RequestParam(value = "redirect_uri",required = false) String redirectUrl,
                                         @RequestParam(value = "refresh_token", required = false) String refreshToken) throws Exception {
        if (StringUtils.isEmpty(appKey) && StringUtils.isEmpty(appSecret)){
            appKey = key;
            appSecret = secret;
            oauthType = "authorization_code";
        }
        OAuth2VO oAuth2VO = null;
        if ("authorization_code".equals(oauthType)) {
            TokenPostDTO tokenPostDTO = TokenPostDTO.builder().oauthType(oauthType).appKey(appKey).appSecret(appSecret).oauthCode(oauthCode).build();
            oAuth2VO = accessTokenService.getAccessTokenByAuthCode(tokenPostDTO);
        }
        if ("refresh_token".equals(oauthType)) {
            TokenPostDTO tokenPostDTO = TokenPostDTO.builder().oauthType(oauthType).appKey(appKey).appSecret(appSecret).refreshToken(refreshToken).build();
            oAuth2VO = accessTokenService.getAccessTokenByRefreshToken(tokenPostDTO);
        }
        return ResultBean.success(oAuth2VO);
    }

    /**
     * 校验鉴权令牌
     *
     * @return
     */
    @Validated
    @GetMapping("/check")
    @ApiOperation(value = "校验鉴权令牌", notes = "校验鉴权令牌")
    public ResultBean<Boolean> checkToken(@RequestParam(value = "access_token", required = false) String accessToken,
                                          @RequestParam(value = "refresh_token", required = false) String refreshToken) throws Exception {
        AssertKits.checkIsFalse(StringUtils.isBlank(accessToken), "鉴权令牌不能为空！");
        Boolean aBoolean = accessTokenService.checkAccessToken(accessToken);
        return ResultBean.success(aBoolean);
    }
}

