package com.startdis.sso.domain.model.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 刷新令牌表 RefreshTokenQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "刷新令牌表")
public class RefreshTokenQuery implements Serializable {
    private static final long serialVersionUID = -94302809536240928L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 应用标识
     */
    @ApiModelProperty("应用标识")
    private String appKey;
    /**
     * 应用密钥
     */
    @ApiModelProperty("应用密钥")
    private String appSecret;
    /**
     * 鉴权令牌
     */
    @ApiModelProperty("鉴权令牌")
    private String accessToken;
    /**
     * 刷新令牌
     */
    @ApiModelProperty("刷新令牌")
    private String refreshToken;
    /**
     * 最新的刷新令牌
     */
    @ApiModelProperty("最新的刷新令牌")
    private String latestRefreshToken;
    /**
     * 是否已用（0正常 1已用）
     */
    @ApiModelProperty("是否已用（0正常 1已用）")
    private Integer used;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;

}

