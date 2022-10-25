package com.startdis.common.domain.model;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc BaseEntity
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 乐观锁
     */
    /*@Version
    @TableField("revision")
    private Integer revision;*/

    /**
     * 逻辑删除
     * value = "" 默认的原值，默认为 0；
     * delval = "" 删除后的值，默认为1；
     */
    /*@TableLogic(value="0",delval="1")
    @TableField("is_deleted")
    private Integer isDeleted;*/

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
     private LocalDateTime updatedAt;

}
