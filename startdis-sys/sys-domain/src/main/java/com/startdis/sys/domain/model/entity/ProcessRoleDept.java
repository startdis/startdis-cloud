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
 * @desc 流程部门与流程角色关联表 ProcessRoleDeptDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_process_role_dept")
public class ProcessRoleDept extends BaseEntity {


    /**
     * 流程部门ID
     */
    private String deptId;

    /**
     * 流程角色ID
     */
    private String processRoleId;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
