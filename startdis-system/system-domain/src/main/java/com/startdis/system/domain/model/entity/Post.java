package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_post")
public class Post extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 岗位编码
     */
    @TableField("post_code")
    private String postCode;
    
    /**
     * 岗位名称
     */
    @TableField("post_name")
    private String postName;
    
    /**
     * 岗位描述
     */
    @TableField("post_remark")
    private String postRemark;
    
    /**
     * 显示顺序
     */
    @TableField("post_sort")
    private Integer postSort;
    
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
