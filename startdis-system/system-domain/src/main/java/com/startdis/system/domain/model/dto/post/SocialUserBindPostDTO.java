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
 * @desc 社交用户绑定表 SocialUserBindDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "社交用户绑定表")
public class SocialUserBindPostDTO implements Serializable {
    
    private static final long serialVersionUID = 399086841074974668L;
    
    
    /**
     * 系统用户ID
     */
    @ApiModelProperty("系统用户ID")
    private String userId;
    
    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String userType;
    
    /**
     * 社交用户ID
     */
    @ApiModelProperty("社交用户ID")
    private String socialUserId;
    
    /**
     * 社交平台的类型
     */
    @ApiModelProperty("社交平台的类型")
    private String socialType;
    
    
}
