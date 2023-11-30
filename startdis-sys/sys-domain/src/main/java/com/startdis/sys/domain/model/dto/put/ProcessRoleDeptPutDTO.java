package com.startdis.sys.domain.model.dto.put;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程部门与流程角色关联表 ProcessRoleDeptDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "流程部门与流程角色关联表")
public class ProcessRoleDeptPutDTO implements Serializable {
    private static final long serialVersionUID = 898870655433533036L;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;

    /**
     * 流程部门编码
     */
    @ApiModelProperty("流程部门ID")
    private String deptId;

    /**
     * 流程角色ID
     */
    @ApiModelProperty("流程角色ID")
    private String processRoleId;

    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}
