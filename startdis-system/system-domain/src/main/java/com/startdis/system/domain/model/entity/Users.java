package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_users")
public class Users extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编码
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户描述
     */
    @TableField("user_remark")
    private String userRemark;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户性别（0女性 1男性）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 头像地址
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 最后登录IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @TableField("login_date")
    private LocalDateTime loginDate;

    /**
     * 数据状态（0正常 1停用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否删除（0正常 1删除）
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 租户号
     */
    @TableField("tenant_id")
    private String tenantId;


}
