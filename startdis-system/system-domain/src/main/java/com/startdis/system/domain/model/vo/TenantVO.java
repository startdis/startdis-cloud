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
 * @desc 租户表 TenantVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "租户表")
public class TenantVO implements Serializable {
    
    private static final long serialVersionUID = 524686628291388699L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 租户编码（公司ID）
     */
    @ApiModelProperty("租户编码（公司ID）")
    private String tenantCode;
    
    /**
     * 租户名（公司名称）
     */
    @ApiModelProperty("租户名（公司名称）")
    private String tenantName;
    
    /**
     * 联系人的用户ID
     */
    @ApiModelProperty("联系人的用户ID")
    private String contactUserId;
    
    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String contactName;
    
    /**
     * 联系手机
     */
    @ApiModelProperty("联系手机")
    private String contactPhone;
    
    /**
     * 绑定域名
     */
    @ApiModelProperty("绑定域名")
    private String tenantDomain;
    
    /**
     * 租户套餐编号
     */
    @ApiModelProperty("租户套餐编号")
    private String packageId;
    
    /**
     * 过期时间
     */
    @ApiModelProperty("过期时间")
    private String expireAt;
    
    /**
     * 账号数量
     */
    @ApiModelProperty("账号数量")
    private String accountCount;
    
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
