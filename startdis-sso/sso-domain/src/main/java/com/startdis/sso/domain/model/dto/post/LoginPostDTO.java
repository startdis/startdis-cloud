package com.startdis.sso.domain.model.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 登录需要的参数
 */
@Data
@ApiModel(description = "登录需要的参数")
public class LoginPostDTO {

    @ApiModelProperty("应用编码")
    private String appCode;

    /**
     * client端的状态码--随机数 防止被篡改
     * 用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。
     * 请务必严格按照流程检查用户与state参数状态的绑定。
     */
    @ApiModelProperty("状态码")
    private String state;

    @ApiModelProperty(value = "账号")
    private String userCode;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "鉴权令牌")
    private String accessToken;

    //@ApiModelProperty(value = "临时令牌")
    //@JSONField(name = "casualToken")
    //private String casualToken;

}
