package com.startdis.sso.domain.model.query;


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
 * @desc 授权码表 OauthCodeQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "授权码表")
public class OauthCodeQuery implements Serializable {
    private static final long serialVersionUID = -65095722816022857L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 授权码
     */
    @ApiModelProperty("授权码")
    private String authCode;
    /**
     * 过期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("过期时间")
    private LocalDateTime expiresAt;
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

