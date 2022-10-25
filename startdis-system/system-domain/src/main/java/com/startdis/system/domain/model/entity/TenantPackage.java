package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 租户套餐表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_tenant_package")
public class TenantPackage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 套餐ID
     */
    @TableField("package_id")
    private String packageId;

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


}
