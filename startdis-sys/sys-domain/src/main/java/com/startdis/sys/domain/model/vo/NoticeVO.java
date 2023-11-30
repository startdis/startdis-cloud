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
 * @desc 通知公告表 NoticeVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "通知公告表")
public class NoticeVO implements Serializable {
    
    private static final long serialVersionUID = 361011964947962089L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 公告编码
     */
    @ApiModelProperty("公告编码")
    private String noticeCode;
    
    /**
     * 公告标题
     */
    @ApiModelProperty("公告标题")
    private String noticeTitle;
    
    /**
     * 公告内容
     */
    @ApiModelProperty("公告内容")
    private String noticeContent;
    
    /**
     * 公告类型（1公告 2通知）
     */
    @ApiModelProperty("公告类型（1公告 2通知）")
    private Integer noticeType;
    
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
