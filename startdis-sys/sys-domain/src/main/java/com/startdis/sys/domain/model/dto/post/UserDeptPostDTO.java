package com.startdis.sys.domain.model.dto.post;


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
 * @desc 用户部门表 UserDeptDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户部门表")
public class UserDeptPostDTO implements Serializable {
    
    private static final long serialVersionUID = 327984166557197068L;
    
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String deptId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
