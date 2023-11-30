package com.startdis.sys.domain.model.dto.put;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表 ProcessRoleDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "流程角色表")
public class ProcessRolePutDTO implements Serializable {
    private static final long serialVersionUID = -46942046349764931L;

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
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}
