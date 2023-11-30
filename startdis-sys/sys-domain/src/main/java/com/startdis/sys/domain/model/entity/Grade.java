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
 * @desc 职系表 GradeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_grade")
public class Grade extends BaseEntity {


    /**
     * 职系编码
     */
    private String gradeCode;

    /**
     * 职系名称
     */
    private String gradeName;

    /**
     * 职系描述
     */
    private String gradeRemark;

    /**
     * 显示顺序
     */
    private Integer gradeSort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
