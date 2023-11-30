package com.startdis.sys.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表 UserDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User extends BaseEntity {
    
    
    /**
     * 用户编码
     */
    private String userCode;
    
    /**
     * 用户名称
     */
    private String userName;
    
    /**
     * 用户昵称
     */
    private String nickName;
    
    /**
     * 用户描述
     */
    private String userRemark;
    
    /**
     * 登录密码
     */
    private String password;
    
    /**
     * 手机号码
     */
    private String mobile;
    
    /**
     * 电话号码
     */
    private String phone;
    
    /**
     * 电子邮箱
     */
    private String email;
    
    /**
     * 用户性别（0女性 1男性）
     */
    private Integer sex;
    
    /**
     * 头像地址
     */
    private String headPic;
    
    /**
     * 最后登录IP
     */
    private String loginIp;
    
    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
