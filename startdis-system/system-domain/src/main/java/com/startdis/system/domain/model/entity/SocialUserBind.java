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
 * 社交用户绑定表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_social_user_bind")
public class SocialUserBind extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 系统用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

    /**
     * 社交用户ID
     */
    @TableField("social_user_id")
    private String socialUserId;

    /**
     * 社交平台的类型
     */
    @TableField("social_type")
    private String socialType;

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
