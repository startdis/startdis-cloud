package com.startdis.sys.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表 RoleMenuDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "角色菜单中间表")
public class RoleMenuAuthRoleDTO implements Serializable {
    private static final long serialVersionUID = -39185336094903047L;
    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private String menuId;
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色IDs")
    private List<String> roleIds;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
