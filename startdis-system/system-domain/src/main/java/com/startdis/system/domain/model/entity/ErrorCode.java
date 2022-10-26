package com.startdis.system.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 错误码表 ErrorCodeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_error_code")
public class ErrorCode extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 应用ID
     */
    private String applicationId;
    
    /**
     * 应用名称
     */
    private String applicationName;
    
    /**
     * 错误码类型
     */
    private String errorType;
    
    /**
     * 错误码编码
     */
    private String errorCode;
    
    /**
     * 错误码提示
     */
    private String errorMessage;
    
    /**
     * 错误码描述
     */
    private String errorRemark;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
