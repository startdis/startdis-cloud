package com.startdis.sys.domain.model.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表 RoleMenuQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "角色菜单中间表")
public class RoleMenuAuthMenuQuery implements Serializable {
    private static final long serialVersionUID = 909189268167513749L;
    /**
     * 授权状态
     */
    @ApiModelProperty("授权状态")
    private String authStatus;
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
}
