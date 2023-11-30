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
 * @desc 角色菜单表 RoleMenuDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class RoleMenu extends BaseEntity {
    
    
    /**
     * 角色ID
     */
    private String roleId;
    
    /**
     * 菜单ID
     */
    private String menuId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
