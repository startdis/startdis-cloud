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
 * @desc 租户表 TenantDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_tenant")
public class Tenant extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 租户编码（公司ID）
     */
    private String tenantCode;
    
    /**
     * 租户名（公司名称）
     */
    private String tenantName;
    
    /**
     * 联系人的用户ID
     */
    private String contactUserId;
    
    /**
     * 联系人
     */
    private String contactName;
    
    /**
     * 联系手机
     */
    private String contactPhone;
    
    /**
     * 绑定域名
     */
    private String tenantDomain;
    
    /**
     * 租户套餐编号
     */
    private String packageId;
    
    /**
     * 过期时间
     */
    private String expireAt;
    
    /**
     * 账号数量
     */
    private String accountCount;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
