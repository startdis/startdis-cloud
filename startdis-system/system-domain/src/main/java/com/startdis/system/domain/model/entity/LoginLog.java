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
 * 系统登录日志
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_login_log")
public class LoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 链路追踪编号
     */
    @TableField("trace_id")
    private String traceId;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户 IP
     */
    @TableField("user_ip")
    private String userIp;

    /**
     * 浏览器 UA
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 登陆结果
     */
    @TableField("login_result")
    private String loginResult;

    /**
     * 日志类型
     */
    @TableField("log_type")
    private String logType;

    /**
     * 请求日志
     */
    @TableField("log_request")
    private String logRequest;

    /**
     * 响应日志
     */
    @TableField("log_response")
    private String logResponse;

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
