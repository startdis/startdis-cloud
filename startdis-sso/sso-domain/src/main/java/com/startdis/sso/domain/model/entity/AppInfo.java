package com.startdis.sso.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表 AppInfoDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sso_app_info")
public class AppInfo extends BaseEntity {


    /**
     * 应用编码（自定义的唯一标识）
     */
    private String appCode;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用公匙（系统生成的唯一标识）
     */
    private String appKey;

    /**
     * 应用私匙（系统生成的应用密钥）
     */
    private String appSecret;

    /**
     * 应用类型（1内部应用 2三方服务）
     */
    private Integer appType;

    /**
     * 应用完整地址，如 https://app.startdis.com，不带最后的斜线 '/'
     */
    private String appDomain;

    /**
     * 客户端所能访问的资源id集合，多个资源时用逗号(,)分隔
     */
    private String resourceIds;

    /**
     * 授权许可类型(grant_type)，
     * 可选值包括authorization_code,password,refresh_token,implicit,client_credentials,
     * 若支持多个授权许可类型用逗号(,)分隔
     * 默认为 authorization_code
     */
    private String grantTypes;

    /**
     * 重定向URI，当grant_type为authorization_code或implicit时,
     * 在OAuth的流程中会使用并检查与数据库内的redirect_uri是否一致
     */
    private String redirectUrl;

    /**
     * 所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔
     */
    private String authorities;

    /**
     * access_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 1, 1小时)
     */
    private Integer accessTokenValidity;

    /**
     * refresh_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 2, 2小时)
     */
    private Integer refreshTokenValidity;

    /**
     * 审核状态（0-审核中 1-已发布）
     */
    private Integer verifyStatus;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
