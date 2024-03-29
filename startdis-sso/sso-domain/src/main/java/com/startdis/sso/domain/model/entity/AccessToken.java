package com.startdis.sso.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 鉴权令牌表 AccessTokenDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sso_access_token")
public class AccessToken extends BaseEntity {


    /**
     * 应用标识
     */
    private String appKey;

    /**
     * 应用密钥
     */
    private String appSecret;

    /**
     * 鉴权令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 过期时间
     */
    private LocalDateTime expiresAt;

    /**
     * 令牌类型（bearer mac）
     */
    private String tokenType;

    /**
     * 权限范围
     */
    private String tokenScope;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
