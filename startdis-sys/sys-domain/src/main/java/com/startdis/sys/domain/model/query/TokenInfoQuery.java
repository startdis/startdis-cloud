package com.startdis.sys.domain.model.query;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表 TokenInfoQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统授权信息表")
public class TokenInfoQuery implements Serializable {
    private static final long serialVersionUID = 998566082391269361L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 应用鉴权令牌
     */
    @ApiModelProperty("应用鉴权令牌")
    private String accesstoken;
    /**
     * 应用刷新令牌
     */
    @ApiModelProperty("应用刷新令牌")
    private String refreshtoken;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;

}

