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
 * @desc 部门表 DeptDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dept")
public class Dept extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 父部门ID
     */
    private String parentId;
    
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
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
