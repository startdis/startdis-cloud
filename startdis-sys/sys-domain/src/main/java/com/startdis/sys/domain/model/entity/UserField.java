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
 * @desc 用户字段表 UserFieldDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_field")
public class UserField extends BaseEntity {
    
    
    /**
     * 字段编码
     */
    private String fieldCode;
    
    /**
     * 字段名称
     */
    private String fieldName;
    
    /**
     * 字段长度
     */
    private Long fieldLength;
    
    /**
     * 字段描述
     */
    private String fieldRemark;
    
    /**
     * 显示顺序
     */
    private Integer fieldSort;
    
    /**
     * 是否必填（0正常 1必填）
     */
    private String required;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
