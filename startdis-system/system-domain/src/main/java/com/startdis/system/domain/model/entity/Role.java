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
 * 角色表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 角色代码
     */
    @TableField("role_code")
    private String roleCode;
    
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
    
    /**
     * 角色描述
     */
    @TableField("role_remark")
    private String roleRemark;
    
    /**
     * 角色类型
     */
    @TableField("role_type")
    private String roleType;
    
    /**
     * 显示顺序
     */
    @TableField("role_sort")
    private Integer roleSort;
    
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @TableField("role_scope")
    private Integer roleScope;
    
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
