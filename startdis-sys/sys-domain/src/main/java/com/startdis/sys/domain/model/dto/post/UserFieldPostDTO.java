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
 * @desc 用户字段表 UserFieldDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户字段表")
public class UserFieldPostDTO implements Serializable {
    
    private static final long serialVersionUID = -20682573521534858L;
    
    
    /**
     * 字段编码
     */
    @ApiModelProperty("字段编码")
    private String fieldCode;
    
    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String fieldName;
    
    /**
     * 字段长度
     */
    @ApiModelProperty("字段长度")
    private Long fieldLength;
    
    /**
     * 字段描述
     */
    @ApiModelProperty("字段描述")
    private String fieldRemark;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer fieldSort;
    
    /**
     * 是否必填（0正常 1必填）
     */
    @ApiModelProperty("是否必填（0正常 1必填）")
    private String required;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
