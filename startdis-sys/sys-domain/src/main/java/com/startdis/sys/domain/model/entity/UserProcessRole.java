package com.startdis.sys.domain.model.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表 UserProcessRoleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_process_role")
public class UserProcessRole extends BaseEntity {


    /**
     * 用户ID
     */
    private String userId;

    /**
     * 流程角色部门ID
     */
    private String processRoleDeptId;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
