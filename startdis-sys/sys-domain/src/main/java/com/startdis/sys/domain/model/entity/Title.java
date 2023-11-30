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
 * @desc 职位表 TitleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_title")
public class Title extends BaseEntity {


    /**
     * 职系ID
     */
    private String gradeId;

    /**
     * 职系编码
     */
    private String gradeCode;

    /**
     * 职位编码
     */
    private String titleCode;

    /**
     * 职位名称
     */
    private String titleName;

    /**
     * 职位描述
     */
    private String titleRemark;

    /**
     * 显示顺序
     */
    private Integer titleSort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
