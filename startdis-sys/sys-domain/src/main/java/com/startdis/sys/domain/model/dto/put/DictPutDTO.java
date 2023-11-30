package com.startdis.sys.domain.model.dto.put;


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
 * @desc 字典主表 DictDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "字典主表")
public class DictPutDTO implements Serializable {
    
    private static final long serialVersionUID = 180546187105328792L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 字典编码
     */
    @ApiModelProperty("字典编码")
    private String dictCode;
    
    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    private String dictName;
    
    /**
     * 字典描述
     */
    @ApiModelProperty("字典描述")
    private String dictRemark;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
