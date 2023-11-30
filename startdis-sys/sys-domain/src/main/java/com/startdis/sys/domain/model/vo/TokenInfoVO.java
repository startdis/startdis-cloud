package com.startdis.sys.domain.model.vo;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表 TokenInfoVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统授权信息表")
public class TokenInfoVO implements Serializable {
    private static final long serialVersionUID = -14762490111508814L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 应用鉴权令牌
     */
    @ApiModelProperty("应用鉴权令牌")
    private String accesstoken;
    /**
     * 应用刷新令牌
     */
    @ApiModelProperty("应用刷新令牌")
    private String refreshtoken;
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
    private Integer revision;
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
