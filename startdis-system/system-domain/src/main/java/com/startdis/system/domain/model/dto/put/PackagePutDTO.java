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
 * @desc 套餐表 PackageDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "套餐表")
public class PackagePutDTO implements Serializable {
    
    private static final long serialVersionUID = -22972009212343923L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 套餐代码
     */
    @ApiModelProperty("套餐代码")
    private String packageCode;
    
    /**
     * 套餐名称
     */
    @ApiModelProperty("套餐名称")
    private String packageName;
    
    /**
     * 套餐描述
     */
    @ApiModelProperty("套餐描述")
    private String packageRemark;
    
    /**
     * 套餐费用
     */
    @ApiModelProperty("套餐费用")
    private Object packageExes;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
    
}
