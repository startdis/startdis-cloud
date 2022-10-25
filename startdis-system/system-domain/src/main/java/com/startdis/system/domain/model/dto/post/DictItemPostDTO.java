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
 * @desc 字典数据表 DictItemDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "字典数据表")
public class DictItemPostDTO implements Serializable {
    
    private static final long serialVersionUID = -30426079600255135L;
    
    
    /**
     * 字典编码
     */
    @ApiModelProperty("字典编码")
    private String dictCode;
    
    /**
     * 字典项值
     */
    @ApiModelProperty("字典项值")
    private String itemValue;
    
    /**
     * 字典项标签
     */
    @ApiModelProperty("字典项标签")
    private String itemLabel;
    
    /**
     * 字典项描述
     */
    @ApiModelProperty("字典项描述")
    private String itemRemark;
    
    /**
     * 字典项排序
     */
    @ApiModelProperty("字典项排序")
    private Integer itemSort;
    
    /**
     * 字典项样式
     */
    @ApiModelProperty("字典项样式")
    private String itemStyle;
    
    /**
     * 字典项CSS
     */
    @ApiModelProperty("字典项CSS")
    private String itemCss;
    
    
}
