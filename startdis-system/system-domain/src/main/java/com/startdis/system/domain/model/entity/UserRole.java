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
 * @desc 用户角色中间表 UserRoleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_role")
public class UserRole extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 角色ID
     */
    private String roleId;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
