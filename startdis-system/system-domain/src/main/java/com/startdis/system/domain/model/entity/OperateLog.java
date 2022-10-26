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
 * @desc 操作日志记录表 OperateLogDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_operate_log")
public class OperateLog extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 链路追踪ID
     */
    private String traceId;
    
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
     * 系统模块
     */
    private String systemModule;
    
    /**
     * 操作名称
     */
    private String operateName;
    
    /**
     * 操作分类
     */
    private String operateType;
    
    /**
     * 操作内容
     */
    private String operateContent;
    
    /**
     * 操作时间
     */
    private LocalDateTime operateAt;
    
    /**
     * 请求耗时
     */
    private String costTime;
    
    /**
     * 拓展字段
     */
    private String operateExts;
    
    /**
     * 请求方法名
     */
    private String requestMethod;
    
    /**
     * 请求地址
     */
    private String requestUrl;
    
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
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
