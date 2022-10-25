package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 错误码表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_error_code")
public class ErrorCode extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 应用ID
     */
    @TableField("application_id")
    private String applicationId;

    /**
     * 应用名称
     */
    @TableField("application_name")
    private String applicationName;

    /**
     * 错误码类型
     */
    @TableField("error_type")
    private String errorType;

    /**
     * 错误码编码
     */
    @TableField("error_code")
    private String errorCode;

    /**
     * 错误码提示
     */
    @TableField("error_message")
    private String errorMessage;

    /**
     * 错误码描述
     */
    @TableField("error_remark")
    private String errorRemark;

    /**
     * 数据状态（0正常 1停用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否删除（0正常 1删除）
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 租户号
     */
    @TableField("tenant_id")
    private String tenantId;


}
