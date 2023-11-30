package com.startdis.sys.domain.model.query;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表 ProcessRoleQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "流程角色表")
public class ProcessRoleQuery implements Serializable {
    private static final long serialVersionUID = -48944694882584687L;
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

