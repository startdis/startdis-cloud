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
 * @desc 用户岗位表 UserPostQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户岗位表")
public class UserPostAuthUserQuery implements Serializable {
    
    private static final long serialVersionUID = 446950112382730074L;
    
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
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    private String postId;
    
}

