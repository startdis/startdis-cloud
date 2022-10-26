package com.startdis.system.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 租户套餐表 TenantPackageDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_tenant_package")
public class TenantPackage extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    
    /**
     * 套餐ID
     */
    private String packageId;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
