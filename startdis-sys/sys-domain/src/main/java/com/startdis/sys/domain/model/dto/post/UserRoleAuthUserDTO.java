package com.startdis.sys.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户角色中间表 UserRoleDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户角色中间表")
public class UserRoleAuthUserDTO implements Serializable {
    private static final long serialVersionUID = -66749298880640886L;
    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty("角色ID")
    private String roleId;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID集合")
    private List<String> userIds;
    
    
}


