package com.startdis.sys.domain.model.dto.put;


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
 * @email startdis@dianjiu.cc
 * @desc 用户角色表 UserRoleDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户角色表")
public class UserRolePutDTO implements Serializable {
    
    private static final long serialVersionUID = 768420281037253387L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
