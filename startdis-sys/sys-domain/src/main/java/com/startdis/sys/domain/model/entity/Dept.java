package com.startdis.sys.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 部门表 DeptDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dept")
public class Dept extends BaseEntity {
    
    
    /**
     * 父部门ID
     */
    private String parentId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;
    
    /**
     * 部门编码
     */
    private String deptCode;
    
    /**
     * 部门名称
     */
    private String deptName;
    
    /**
     * 部门负责人ID
     */
    private String leaderUserId;

    /**
     * 部门负责人编码
     */
    private String leaderUserCode;
    
    /**
     * 部门负责人名称
     */
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    private Integer deptSort;
    
    /**
     * 联系电话
     */
    private String phone;
    
    /**
     * 联系邮箱
     */
    private String email;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;

}
