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
 * 公司表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_company")
public class Company extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 父公司ID
     */
    @TableField("parent_id")
    private String parentId;
    
    /**
     * 公司编码
     */
    @TableField("company_code")
    private String companyCode;
    
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
    
    /**
     * 公司负责人ID
     */
    @TableField("leader_user_id")
    private String leaderUserId;
    
    /**
     * 公司负责人名称
     */
    @TableField("leader_user_name")
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    @TableField("company_sort")
    private Integer companySort;
    
    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;
    
    /**
     * 联系邮箱
     */
    @TableField("email")
    private String email;
    
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
