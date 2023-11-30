package com.startdis.sys.domain.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 操作日志记录表 OperateLogVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "操作日志记录表")
public class OperateLogVO implements Serializable {
    
    private static final long serialVersionUID = 103419142189193774L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 系统模块
     */
    @ApiModelProperty("系统模块")
    private String systemModule;
    
    /**
     * 链路追踪ID
     */
    @ApiModelProperty("链路追踪ID")
    private String traceId;
    
    /**
     * 日志级别
     */
    @ApiModelProperty("日志级别")
    private String loggerLevel;
    
    /**
     * 日志详情
     */
    @ApiModelProperty("日志详情")
    private String loggerInfo;
    
    /**
     * 操作名称
     */
    @ApiModelProperty("操作名称")
    private String operateName;
    
    /**
     * 操作类型
     */
    @ApiModelProperty("操作类型")
    private String operateAction;
    
    /**
     * 操作内容（接口描述）
     */
    @ApiModelProperty("操作内容（接口描述）")
    private String operateContent;
    
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("操作时间")
    private LocalDateTime operateAt;
    
    /**
     * 拓展字段
     */
    @ApiModelProperty("拓展字段")
    private String operateExts;
    
    /**
     * 请求耗时
     */
    @ApiModelProperty("请求耗时")
    private String costTime;
    
    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String requestUrl;
    
    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String requestMethod;
    
    /**
     * 请求入参
     */
    @ApiModelProperty("请求入参")
    private String requestBody;
    
    /**
     * 响应状态码
     */
    @ApiModelProperty("响应状态码")
    private String responseCode;
    
    /**
     * 响应提示语
     */
    @ApiModelProperty("响应提示语")
    private String responseMsg;
    
    /**
     * 响应出参
     */
    @ApiModelProperty("响应出参")
    private String responseData;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String userType;
    
    /**
     * 用户 IP
     */
    @ApiModelProperty("用户 IP")
    private String userIp;
    
    /**
     * 浏览器 UA
     */
    @ApiModelProperty("浏览器 UA")
    private String userAgent;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    /**
     * 是否删除（0正常 1删除）
     */
    @ApiModelProperty("是否删除（0正常 1删除）")
    private Integer deleted;
    
    /**
     * 乐观锁
     */
    @ApiModelProperty("乐观锁")
    private Long revision;
    
    /**
     * 集团租户ID
     */
    @ApiModelProperty("集团租户ID")
    private String groupTenantId;
    
    /**
     * 公司租户ID
     */
    @ApiModelProperty("公司租户ID")
    private String companyTenantId;
    
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;
    
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;
    
}
