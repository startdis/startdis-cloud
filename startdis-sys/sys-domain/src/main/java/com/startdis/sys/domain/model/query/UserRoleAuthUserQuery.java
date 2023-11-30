package com.startdis.sys.domain.model.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户角色中间表 UserRoleQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户角色中间表")
public class UserRoleAuthUserQuery implements Serializable {
    
    private static final long serialVersionUID = 525680403082168412L;
    
    /**
     * 授权状态
     */
    @ApiModelProperty("授权状态")
    private String authStatus;
    
    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String userCode;
    
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
}

