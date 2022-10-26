package com.startdis.system.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 用户表 UsersDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_users")
public class Users extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
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
     * 用户邮箱
     */
    private String email;
    
    /**
     * 手机号码
     */
    private String phone;
    
    /**
     * 用户性别（0女性 1男性）
     */
    private Integer sex;
    
    /**
     * 头像地址
     */
    private String avatar;
    
    /**
     * 最后登录IP
     */
    private String loginIp;
    
    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
