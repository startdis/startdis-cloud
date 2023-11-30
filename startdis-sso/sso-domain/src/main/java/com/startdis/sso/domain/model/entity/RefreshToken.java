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
 * @desc 刷新令牌表 RefreshTokenDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sso_refresh_token")
public class RefreshToken extends BaseEntity {


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
     * 最新的刷新令牌
     */
    private String latestRefreshToken;

    /**
     * 是否已用（0正常 1已用）
     */
    private Integer used;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
