package com.startdis.sys.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统登录日志 LoginLogDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_login_log")
public class LoginLog extends BaseEntity {
    
    
    /**
     * 链路追踪编号
     */
    private String traceId;
    
    /**
     * 用户编号
     */
    private String userId;
    
    /**
     * 用户类型
     */
    private String userType;
    
    /**
     * 用户名称
     */
    private String userName;
    
    /**
     * 用户 IP
     */
    private String userIp;
    
    /**
     * 浏览器 UA
     */
    private String userAgent;
    
    /**
     * 登陆结果
     */
    private String loginResult;
    
    /**
     * 日志类型
     */
    private String logType;
    
    /**
     * 请求日志
     */
    private String logRequest;
    
    /**
     * 响应日志
     */
    private String logResponse;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
