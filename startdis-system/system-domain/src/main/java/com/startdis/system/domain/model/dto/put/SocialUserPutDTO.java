package com.startdis.system.domain.model.dto;


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
 * @email startdis@cloud-number.cn
 * @desc 社交用户表 SocialUserDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "社交用户表")
public class SocialUserPutDTO implements Serializable {
    
    private static final long serialVersionUID = -74040466707700935L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 社交平台的类型
     */
    @ApiModelProperty("社交平台的类型")
    private Integer socialType;
    
    /**
     * 社交 openid
     */
    @ApiModelProperty("社交 openid")
    private String socialOpenId;
    
    /**
     * 社交 token
     */
    @ApiModelProperty("社交 token")
    private String socialToken;
    
    /**
     * 原始 Token 数据，一般是 JSON 格式
     */
    @ApiModelProperty("原始 Token 数据，一般是 JSON 格式")
    private String rawTokenInfo;
    
    /**
     * 原始用户数据，一般是 JSON 格式
     */
    @ApiModelProperty("原始用户数据，一般是 JSON 格式")
    private String rawUserInfo;
    
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;
    
    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;
    
    /**
     * 最后一次的认证 code
     */
    @ApiModelProperty("最后一次的认证 code")
    private String socialCode;
    
    /**
     * 最后一次的认证 state
     */
    @ApiModelProperty("最后一次的认证 state")
    private String socialState;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
    
}
