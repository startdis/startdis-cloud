package com.startdis.system.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 社交用户表 SocialUserDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_social_user")
public class SocialUser extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 社交平台的类型
     */
    private Integer socialType;
    
    /**
     * 社交 openid
     */
    private String socialOpenId;
    
    /**
     * 社交 token
     */
    private String socialToken;
    
    /**
     * 原始 Token 数据，一般是 JSON 格式
     */
    private String rawTokenInfo;
    
    /**
     * 原始用户数据，一般是 JSON 格式
     */
    private String rawUserInfo;
    
    /**
     * 用户昵称
     */
    private String nickName;
    
    /**
     * 用户头像
     */
    private String userAvatar;
    
    /**
     * 最后一次的认证 code
     */
    private String socialCode;
    
    /**
     * 最后一次的认证 state
     */
    private String socialState;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
