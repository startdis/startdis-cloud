package com.startdis.sso.domain.model.dto.post;

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
public class AuthorizePostDTO implements Serializable {
    private static final long serialVersionUID = -49147542881369787L;

    /**
     * 授权类型，此值固定为code
     */
    @ApiModelProperty("授权类型，此值固定为code")
    private String responseType;

    /**
     * 分配给应用的appKey
     */
    @ApiModelProperty("分配给应用的appKey")
    private String appKey;

    /**
     * 成功授权后的回调地址
     * 必须是注册appKey时填写的主域名下的地址，建议设置为网站首页或网站的用户中心。
     * 注意需要将url进行URLEncode。
     */
    @ApiModelProperty("成功授权后的回调地址")
    private String redirectUrl;

    /**
     * client端的状态值
     * 用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。
     * 请务必严格按照流程检查用户与state参数状态的绑定。
     */
    @ApiModelProperty("client端的状态值")
    private String state;

    /**
     * 请求用户授权时向用户显示的可进行授权的列表
     * 请求用户授权时向用户显示的可进行授权的列表。
     * 如果要填写多个接口名称，请用逗号隔开。
     * 不传则默认请求对接口get_user_info进行授权。
     */
    @ApiModelProperty("请求用户授权时向用户显示的可进行授权的列表")
    private String scope;

    /**
     * 仅PC网站接入时使用。
     * 用于展示的样式。不传则默认展示为PC下的样式。
     * 如果传入“mobile”，则展示为mobile端下的样式。
     */
    @ApiModelProperty("用于展示的样式")
    private String display;
}
