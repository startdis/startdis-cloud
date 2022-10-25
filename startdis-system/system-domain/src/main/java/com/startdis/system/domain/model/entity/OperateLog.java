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
 * 操作日志记录表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_operate_log")
public class OperateLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 链路追踪ID
     */
    @TableField("trace_id")
    private String traceId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

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
     * 系统模块
     */
    @TableField("system_module")
    private String systemModule;

    /**
     * 操作名称
     */
    @TableField("operate_name")
    private String operateName;

    /**
     * 操作分类
     */
    @TableField("operate_type")
    private String operateType;

    /**
     * 操作内容
     */
    @TableField("operate_content")
    private String operateContent;

    /**
     * 操作时间
     */
    @TableField("operate_at")
    private LocalDateTime operateAt;

    /**
     * 请求耗时
     */
    @TableField("cost_time")
    private String costTime;

    /**
     * 拓展字段
     */
    @TableField("operate_exts")
    private String operateExts;

    /**
     * 请求方法名
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 请求入参
     */
    @TableField("request_body")
    private String requestBody;

    /**
     * 响应状态码
     */
    @TableField("response_code")
    private String responseCode;

    /**
     * 响应提示语
     */
    @TableField("response_msg")
    private String responseMsg;

    /**
     * 响应出参
     */
    @TableField("response_data")
    private String responseData;

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
