package com.startdis.system.domain.model.query;


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
 * @desc 角色表 RoleQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "角色表")
public class RoleQuery implements Serializable {
    
    private static final long serialVersionUID = -39835128621906697L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 角色代码
     */
    @ApiModelProperty("角色代码")
    private String roleCode;
    
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;
    
    /**
     * 角色描述
     */
    @ApiModelProperty("角色描述")
    private String roleRemark;
    
    /**
     * 角色类型
     */
    @ApiModelProperty("角色类型")
    private String roleType;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer roleSort;
    
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @ApiModelProperty("数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private Integer roleScope;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
}

