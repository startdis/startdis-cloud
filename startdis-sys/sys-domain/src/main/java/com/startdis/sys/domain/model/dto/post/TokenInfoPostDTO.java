package com.startdis.sys.domain.model.dto.post;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表 TokenInfoDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统授权信息表")
public class TokenInfoPostDTO implements Serializable {
    private static final long serialVersionUID = -48656711323851730L;


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
