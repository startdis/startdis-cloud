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
 * @desc 系统登录日志 LoginLogVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统登录日志")
public class LoginLogVO implements Serializable {
    
    private static final long serialVersionUID = -84368022982549127L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 链路追踪编号
     */
    @ApiModelProperty("链路追踪编号")
    private String traceId;
    
    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private String userId;
    
    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String userType;
    
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    
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
     * 登陆结果
     */
    @ApiModelProperty("登陆结果")
    private String loginResult;
    
    /**
     * 日志类型
     */
    @ApiModelProperty("日志类型")
    private String logType;
    
    /**
     * 请求日志
     */
    @ApiModelProperty("请求日志")
    private String logRequest;
    
    /**
     * 响应日志
     */
    @ApiModelProperty("响应日志")
    private String logResponse;
    
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
