package com.startdis.sso.domain.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "授权码获取")
public class OAuth2VO implements Serializable {
    private static final long serialVersionUID = -49147542881369787L;
    
    /**
     * 授权码，会在10分钟内过期。
     */
    @ApiModelProperty("授权码")
    @JsonProperty("code")
    @JSONField(name = "code")
    private String oauthCode;

    /**
     * 鉴权令牌
     */
    @ApiModelProperty("鉴权令牌")
    @JSONField(name = "access_token")
    private String accessToken;

    /**
     * 刷新令牌
     * 在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。
     * 每次生成最新的refresh_token，且仅一次有效，一次登录，
     * refresh_token整个续票过程，最长有效期：6个月。
     */
    @ApiModelProperty("刷新令牌")
    @JSONField(name = "refresh_token")
    private String refreshToken;

    /**
     * 过期时间：该access token的有效期，单位为秒。
     */
    @ApiModelProperty("过期时间")
    @JSONField(name = "expires_in")
    private String expiresIn;

    /**
     * 重定向地址
     */
    @ApiModelProperty("重定向地址")
    @JSONField(name = "redirect_uri")
    private String redirectUrl;

    /**
     * client端的状态值
     * 用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。
     * 请务必严格按照流程检查用户与state参数状态的绑定。
     */
    @ApiModelProperty("client端的状态值")
    private String state;
}
