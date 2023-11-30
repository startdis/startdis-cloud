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
 * @desc 公司与部门关系表 CompanyDeptDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_company_dept")
public class CompanyDept extends BaseEntity {


    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
