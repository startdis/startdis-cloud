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
 * @desc 全局变量表 VariableVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "全局变量表")
public class VariableVO implements Serializable {
    
    private static final long serialVersionUID = 931819892672021426L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 变量编码
     */
    @ApiModelProperty("变量编码")
    private String variableCode;
    
    /**
     * 变量名称
     */
    @ApiModelProperty("变量名称")
    private String variableName;
    
    /**
     * 变量键名
     */
    @ApiModelProperty("变量键名")
    private String variableKey;
    
    /**
     * 变量键值
     */
    @ApiModelProperty("变量键值")
    private String variableValue;
    
    /**
     * 是否内置（0用户定义 1系统内置）
     */
    @ApiModelProperty("是否内置（0用户定义 1系统内置）")
    private Integer variableType;
    
    /**
     * 变量描述
     */
    @ApiModelProperty("变量描述")
    private String variableRemark;
    
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
