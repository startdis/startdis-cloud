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
public class RoleMenuAuthMenuDTO implements Serializable {
    private static final long serialVersionUID = -39185336094903047L;
    
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
    /**
     * 授权菜单集合
     */
    @ApiModelProperty("授权菜单集合")
    private List<AuthMenuDTO> authMenus;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
