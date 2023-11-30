package com.startdis.sys.domain.model.query;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表 UserProcessRoleQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户流程角色表")
public class UserProcessRoleQuery implements Serializable {
    private static final long serialVersionUID = -62179184317191439L;
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
     * 流程角色部门ID
     */
    @ApiModelProperty("流程角色部门ID")
    private String processRoleDeptId;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;

}

