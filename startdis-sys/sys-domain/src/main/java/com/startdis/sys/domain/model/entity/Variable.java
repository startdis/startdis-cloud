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
 * @desc 全局变量表 VariableDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_variable")
public class Variable extends BaseEntity {
    
    
    /**
     * 变量编码
     */
    private String variableCode;
    
    /**
     * 变量名称
     */
    private String variableName;
    
    /**
     * 变量键名
     */
    private String variableKey;
    
    /**
     * 变量键值
     */
    private String variableValue;
    
    /**
     * 是否内置（0用户定义 1系统内置）
     */
    private Integer variableType;
    
    /**
     * 变量描述
     */
    private String variableRemark;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
