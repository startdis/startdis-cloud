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
 * @desc 租户套餐表 TenantPackageDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "租户套餐表")
public class TenantPackagePutDTO implements Serializable {
    
    private static final long serialVersionUID = 791191194992552087L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    
    /**
     * 套餐ID
     */
    @ApiModelProperty("套餐ID")
    private String packageId;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
    
}
