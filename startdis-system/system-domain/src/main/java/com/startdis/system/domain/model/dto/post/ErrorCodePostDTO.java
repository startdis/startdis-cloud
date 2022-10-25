package com.startdis.system.domain.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 错误码表 ErrorCodeDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "错误码表")
public class ErrorCodePostDTO implements Serializable {
    
    private static final long serialVersionUID = -19047413737243898L;
    
    
    /**
     * 应用ID
     */
    @ApiModelProperty("应用ID")
    private String applicationId;
    
    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String applicationName;
    
    /**
     * 错误码类型
     */
    @ApiModelProperty("错误码类型")
    private String errorType;
    
    /**
     * 错误码编码
     */
    @ApiModelProperty("错误码编码")
    private String errorCode;
    
    /**
     * 错误码提示
     */
    @ApiModelProperty("错误码提示")
    private String errorMessage;
    
    /**
     * 错误码描述
     */
    @ApiModelProperty("错误码描述")
    private String errorRemark;
    
    
}
