package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 社交用户表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_social_user")
public class SocialUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 社交平台的类型
     */
    @TableField("social_type")
    private Integer socialType;

    /**
     * 社交 openid
     */
    @TableField("social_open_id")
    private String socialOpenId;

    /**
     * 社交 token
     */
    @TableField("social_token")
    private String socialToken;

    /**
     * 原始 Token 数据，一般是 JSON 格式
     */
    @TableField("raw_token_info")
    private String rawTokenInfo;

    /**
     * 原始用户数据，一般是 JSON 格式
     */
    @TableField("raw_user_info")
    private String rawUserInfo;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户头像
     */
    @TableField("user_avatar")
    private String userAvatar;

    /**
     * 最后一次的认证 code
     */
    @TableField("social_code")
    private String socialCode;

    /**
     * 最后一次的认证 state
     */
    @TableField("social_state")
    private String socialState;

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
