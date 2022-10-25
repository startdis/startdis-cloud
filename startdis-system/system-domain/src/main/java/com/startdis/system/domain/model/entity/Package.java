package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 套餐表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_package")
public class Package extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 套餐代码
     */
    @TableField("package_code")
    private String packageCode;

    /**
     * 套餐名称
     */
    @TableField("package_name")
    private String packageName;

    /**
     * 套餐描述
     */
    @TableField("package_remark")
    private String packageRemark;

    /**
     * 套餐费用
     */
    @TableField("package_exes")
    private BigDecimal packageExes;

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
