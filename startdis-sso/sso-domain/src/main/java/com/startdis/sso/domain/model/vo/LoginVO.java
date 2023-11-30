package com.startdis.sso.domain.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 登录后 LoginVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "登录对象")
public class LoginVO {
    /**
     * client端的状态码--随机数 防止被篡改
     * 用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。
     * 请务必严格按照流程检查用户与state参数状态的绑定。
     */
    @ApiModelProperty("状态码")
    private String state;

    /**
     * 授权码，会在30分钟内过期。
     */
    @ApiModelProperty("授权码")
    private String oauthCode;


    //@ApiModelProperty(value = "用户鉴权令牌")
    //private String token;

    //@ApiModelProperty(value = "应用用户ID")
    //private String uniqueId;

    //@ApiModelProperty(value = "系统用户ID")
    //private String userId;

    //@ApiModelProperty(value = "公司id")
    //private String companyId;
    //
    //@ApiModelProperty(value = "当前登录的公司id")
    //private String currentCompanyId;
    //
    //@ApiModelProperty(value = "权限集合")
    //private List<Permission> permissionList;
    //
    //@Data
    //public static class Permission {
    //
    //    @ApiModelProperty(value = "权限范围")
    //    private IdentityTypeEnum permissionScopeEnum;
    //
    //    @ApiModelProperty(value = "如果权限范围为集团，则会返回这个权限范围的所有公司")
    //    private List<String> companyIds;
    //
    //    @ApiModelProperty(value = "权限编号")
    //    private String code;
    //
    //    @ApiModelProperty(value = "权限对应的资源")
    //    private List<String> urls;
    //
    //}

}
