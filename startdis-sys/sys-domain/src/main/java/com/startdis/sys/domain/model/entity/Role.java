package com.startdis.sys.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色表 RoleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role extends BaseEntity {
    
    
    /**
     * 角色代码
     */
    private String roleCode;
    
    /**
     * 角色名称
     */
    private String roleName;
    
    /**
     * 角色描述
     */
    private String roleRemark;
    
    /**
     * 角色类型
     */
    private String roleType;
    
    /**
     * 显示顺序
     */
    private Integer roleSort;
    
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private Integer roleScope;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
