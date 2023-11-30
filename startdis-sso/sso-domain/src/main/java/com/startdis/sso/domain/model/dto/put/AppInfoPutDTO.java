package com.startdis.sso.domain.model.dto.put;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表 AppInfoDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "应用中心表")
public class AppInfoPutDTO implements Serializable {
    private static final long serialVersionUID = 746761577203398539L;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;

    /**
     * 应用编码（唯一标识）
     */
    @ApiModelProperty("应用编码（唯一标识）")
    private String appCode;

    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String appName;

    /**
     * 应用公匙（系统生成）
     */
    @ApiModelProperty("应用公匙（系统生成）")
    private String appKey;

    /**
     * 应用私匙（系统生成）
     */
    @ApiModelProperty("应用私匙（系统生成）")
    private String appSecret;

    /**
     * 应用类型（1内部应用 2三方服务）
     */
    @ApiModelProperty("应用类型（1内部应用 2三方服务）")
    private Integer appType;

    /**
     * 应用域名
     */
    @ApiModelProperty("应用域名")
    private String appDomain;

    /**
     * 客户端所能访问的资源id集合，多个资源时用逗号(,)分隔
     */
    @ApiModelProperty("客户端所能访问的资源id集合，多个资源时用逗号(,)分隔")
    private String resourceIds;

    /**
     * 授权许可类型(grant_type)，可选值包括authorization_code,password,refresh_token,implicit,client_credentials,若支持多个授权许可类型用逗号(,)分隔
     */
    @ApiModelProperty("授权许可类型(grant_type)，可选值包括authorization_code,password,refresh_token,implicit,client_credentials,若支持多个授权许可类型用逗号(,)分隔")
    private String grantTypes;

    /**
     * 重定向URI，当grant_type为authorization_code或implicit时, 在OAuth的流程中会使用并检查与数据库内的redirect_uri是否一致
     */
    @ApiModelProperty("重定向URI，当grant_type为authorization_code或implicit时, 在OAuth的流程中会使用并检查与数据库内的redirect_uri是否一致")
    private String redirectUrl;

    /**
     * 所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔
     */
    @ApiModelProperty("所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔")
    private String authorities;

    /**
     * access_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时)
     */
    @ApiModelProperty("access_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时)")
    private Integer accessTokenValidity;

    /**
     * refresh_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天)
     */
    @ApiModelProperty("refresh_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天)")
    private Integer refreshTokenValidity;

    /**
     * 审核状态（0-审核中 1-已发布）
     */
    @ApiModelProperty("审核状态（0-审核中 1-已发布）")
    private Integer verifyStatus;

    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}
