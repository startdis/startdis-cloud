package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_tenant")
public class Tenant extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 租户编码（公司ID）
     */
    @TableField("tenant_code")
    private String tenantCode;
    
    /**
     * 租户名（公司名称）
     */
    @TableField("tenant_name")
    private String tenantName;
    
    /**
     * 联系人的用户ID
     */
    @TableField("contact_user_id")
    private String contactUserId;
    
    /**
     * 联系人
     */
    @TableField("contact_name")
    private String contactName;
    
    /**
     * 联系手机
     */
    @TableField("contact_phone")
    private String contactPhone;
    
    /**
     * 绑定域名
     */
    @TableField("tenant_domain")
    private String tenantDomain;
    
    /**
     * 租户套餐编号
     */
    @TableField("package_id")
    private String packageId;
    
    /**
     * 过期时间
     */
    @TableField("expire_at")
    private String expireAt;
    
    /**
     * 账号数量
     */
    @TableField("account_count")
    private String accountCount;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @TableField("status")
    private Integer status;
    
    /**
     * 是否删除（0正常 1删除）
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;
    
    /**
     * 租户号
     */
    @TableField("tenant_id")
    private String tenantId;
    
    
}
