package com.startdis.sys.domain.model.query;


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
 * @desc 用户部门表 UserDeptQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户部门表")
public class UserDeptAuthUserQuery implements Serializable {
    
    private static final long serialVersionUID = -29147581596767658L;
    
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
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String deptId;
    
}

