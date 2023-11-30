package com.startdis.sso.domain.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 鉴权令牌表 AccessTokenVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "鉴权令牌表")
public class AccessTokenVO implements Serializable {
    private static final long serialVersionUID = 803485237471251127L;
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
     * 过期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("过期时间")
    private LocalDateTime expiresAt;
    /**
     * 令牌类型（bearer mac）
     */
    @ApiModelProperty("令牌类型（bearer mac）")
    private String tokenType;
    /**
     * 权限范围
     */
    @ApiModelProperty("权限范围")
    private String tokenScope;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    /**
     * 是否删除（0正常 1删除）
     */
    @ApiModelProperty("是否删除（0正常 1删除）")
    private Integer deleted;
    /**
     * 乐观锁
     */
    @ApiModelProperty("乐观锁")
    private Integer revision;
    /**
     * 集团租户ID
     */
    @ApiModelProperty("集团租户ID")
    private String groupTenantId;
    /**
     * 公司租户ID
     */
    @ApiModelProperty("公司租户ID")
    private String companyTenantId;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createdBy;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updatedBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;

}
