package com.startdis.system.domain.model.query;


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
 * @desc 系统敏感词表 SensitiveWordQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统敏感词表")
public class SensitiveWordQuery implements Serializable {
    
    private static final long serialVersionUID = -63640859467282413L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 敏感词
     */
    @ApiModelProperty("敏感词")
    private String wordName;
    
    /**
     * 敏感词标签
     */
    @ApiModelProperty("敏感词标签")
    private String wordTags;
    
    /**
     * 敏感词描述
     */
    @ApiModelProperty("敏感词描述")
    private String wordRemark;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
}

