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
 * 系统敏感词表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_sensitive_word")
public class SensitiveWord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 敏感词
     */
    @TableField("word_name")
    private String wordName;

    /**
     * 敏感词标签
     */
    @TableField("word_tags")
    private String wordTags;

    /**
     * 敏感词描述
     */
    @TableField("word_remark")
    private String wordRemark;

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
