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
 * @desc 操作日志记录表 OperateLogDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_operate_log")
public class OperateLog extends BaseEntity {
    
    
    /**
     * 系统模块
     */
    private String systemModule;
    
    /**
     * 链路追踪ID
     */
    private String traceId;
    
    /**
     * 日志级别
     */
    private String loggerLevel;
    
    /**
     * 日志详情
     */
    private String loggerInfo;
    
    /**
     * 操作名称
     */
    private String operateName;
    
    /**
     * 操作类型
     */
    private String operateAction;
    
    /**
     * 操作内容（接口描述）
     */
    private String operateContent;
    
    /**
     * 操作时间
     */
    private LocalDateTime operateAt;
    
    /**
     * 拓展字段
     */
    private String operateExts;
    
    /**
     * 请求耗时
     */
    private String costTime;
    
    /**
     * 请求地址
     */
    private String requestUrl;
    
    /**
     * 请求方法
     */
    private String requestMethod;
    
    /**
     * 请求入参
     */
    private String requestBody;
    
    /**
     * 响应状态码
     */
    private String responseCode;
    
    /**
     * 响应提示语
     */
    private String responseMsg;
    
    /**
     * 响应出参
     */
    private String responseData;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 用户类型
     */
    private String userType;
    
    /**
     * 用户 IP
     */
    private String userIp;
    
    /**
     * 浏览器 UA
     */
    private String userAgent;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
