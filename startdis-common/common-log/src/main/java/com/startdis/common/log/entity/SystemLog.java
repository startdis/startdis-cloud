package com.startdis.common.log.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author 点九
 * @since 2022-07-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_system_log")
public class SystemLog {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 操作模块
     */
    @TableField("system_module")
    private String systemModule;

    /**
     * 业务类型
     */
    @TableField("business_type")
    private String businessType;

    /**
     * 业务流水号
     */
    @TableField("business_no")
    private String businessNo;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 请求描述
     */
    @TableField("request_desc")
    private String requestDesc;

    /**
     * 请求报文
     */
    @TableField("request_body")
    private String requestBody;

    /**
     * 请求IP
     */
    @TableField("request_ip")
    private String requestIp;

    /**
     * 请求类型（POST、PUT、OPTIONS、DELETE）
     */
    @TableField("request_type")
    private String requestType;

    /**
     * 请求报文类型（map、json）
     */
    @TableField("content_type")
    private String contentType;

    /**
     * 浏览器、操作系统、UI引擎标识
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 请求时间
     */
    @TableField("request_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime requestTime;

    /**
     * 响应报文
     */
    @TableField("response_body")
    private String responseBody;

    /**
     * 响应时间
     */
    @TableField("response_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime responseTime;

    /**
     * 请求耗时
     */
    @TableField("consum_time")
    private Long consumTime;

    /**
     * 异常信息
     */
    @TableField("error_info")
    private String errorInfo;

    /**
     * 乐观锁
     */
    @TableField("revision")
    @Version
    private Integer revision;

    /**
     * 逻辑删除;0-未删除 1-已删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedAt;


}
