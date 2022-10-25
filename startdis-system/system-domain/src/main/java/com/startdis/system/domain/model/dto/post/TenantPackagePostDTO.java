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
public class TenantPackagePostDTO implements Serializable {
    
    private static final long serialVersionUID = 899598961768006280L;
    
    
    /**
     * 套餐ID
     */
    @ApiModelProperty("套餐ID")
    private String packageId;
    
    
}
