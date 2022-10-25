package com.startdis.system.domain.model.vo;

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
 * @email startdis@cloud-number.cn
 * @desc 错误码表 ErrorCodeVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "错误码表")
public class ErrorCodeVO implements Serializable {
    
    private static final long serialVersionUID = 258278608518281287L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 应用ID
     */
    @ApiModelProperty("应用ID")
    private String applicationId;
    
    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String applicationName;
    
    /**
     * 错误码类型
     */
    @ApiModelProperty("错误码类型")
    private String errorType;
    
    /**
     * 错误码编码
     */
    @ApiModelProperty("错误码编码")
    private String errorCode;
    
    /**
     * 错误码提示
     */
    @ApiModelProperty("错误码提示")
    private String errorMessage;
    
    /**
     * 错误码描述
     */
    @ApiModelProperty("错误码描述")
    private String errorRemark;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
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
    private String revision;
    
    /**
     * 租户号
     */
    @ApiModelProperty("租户号")
    private String tenantId;
    
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
