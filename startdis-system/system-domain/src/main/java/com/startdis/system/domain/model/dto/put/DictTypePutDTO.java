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
 * @desc 字典类型表 DictTypeDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "字典类型表")
public class DictTypePutDTO implements Serializable {
    
    private static final long serialVersionUID = 502813532524487836L;
    
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
     * 字典类型（0字符串 1数字）
     */
    @ApiModelProperty("字典类型（0字符串 1数字）")
    private Integer dictType;
    
    /**
     * 字典描述
     */
    @ApiModelProperty("字典描述")
    private String dictRemark;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
    
}
