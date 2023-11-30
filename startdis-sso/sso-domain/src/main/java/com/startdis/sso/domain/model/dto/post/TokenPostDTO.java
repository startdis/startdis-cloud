package com.startdis.sso.domain.model.dto.post;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "鉴权令牌获取")
public class TokenPostDTO implements Serializable {
    private static final long serialVersionUID = -49147542881369787L;

    /**
     * 授权类型
     * 授权码换取鉴权令牌时，此值为 authorization_code
     * 刷新令牌换取鉴权令牌时，此值为 refresh_token
     */
    @ApiModelProperty("授权类型 ")
    @JSONField(name = "grant_type")
    private String oauthType;

    /**
     * 应用标识
     * 分配给应用的appKey
     */
    @ApiModelProperty("应用标识:分配给应用的appKey")
    @JSONField(name = "client_id")
    private String appKey;

    /**
     * 应用密钥
     * 分配给应用的appSecret
     */
    @ApiModelProperty("应用密钥:分配给应用的appSecret")
    @JSONField(name = "client_secret")
    private String appSecret;

    /**
     * 授权码：上一步返回的authorization code
     * 如果用户成功登录并授权，则会跳转到指定的回调地址，并在URL中带上Authorization Code。
     * 例如，回调地址为www.qq.com/my.php，则跳转到：
     * http://www.qq.com/my.php?code=520DD95263C1CFEA087******
     * 注意此code会在10分钟内过期。
     */
    @ApiModelProperty("授权码：上一步返回的authorization code")
    @JSONField(name = "code")
    private String oauthCode;

    /**
     * 成功鉴权后的回调地址，必须是注册appKey时填写的主域名下的地址，
     * 建议设置为网站首页或网站的用户中心。注意需要将url进行URLEncode。
     */
    @ApiModelProperty("回调地址:成功鉴权后的回调地址")
    @JSONField(name = "redirect_uri")
    private String redirectUrl;

    /**
     * 刷新令牌
     * 首次：使用在Step2中获取到的最新的refresh_token。
     * 后续：使用刷新后返回的最新refresh_token
     */
    @ApiModelProperty("刷新令牌")
    @JSONField(name = "refresh_token")
    private String refreshToken;

}
