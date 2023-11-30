package com.startdis.sys.domain.model.dto.post;


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
 * @email startdis@dianjiu.cc
 * @desc 全局变量表 VariableDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "全局变量表")
public class VariablePostDTO implements Serializable {
    
    private static final long serialVersionUID = 377887738093430755L;
    
    
    /**
     * 变量编码
     */
    @ApiModelProperty("变量编码")
    private String variableCode;
    
    /**
     * 变量名称
     */
    @ApiModelProperty("变量名称")
    private String variableName;
    
    /**
     * 变量键名
     */
    @ApiModelProperty("变量键名")
    private String variableKey;
    
    /**
     * 变量键值
     */
    @ApiModelProperty("变量键值")
    private String variableValue;
    
    /**
     * 是否内置（0用户定义 1系统内置）
     */
    @ApiModelProperty("是否内置（0用户定义 1系统内置）")
    private Integer variableType;
    
    /**
     * 变量描述
     */
    @ApiModelProperty("变量描述")
    private String variableRemark;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
