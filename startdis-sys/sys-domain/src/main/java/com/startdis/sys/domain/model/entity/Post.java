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
 * @desc 岗位表 PostDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_post")
public class Post extends BaseEntity {
    
    
    /**
     * 岗位编码
     */
    private String postCode;
    
    /**
     * 岗位名称
     */
    private String postName;
    
    /**
     * 岗位描述
     */
    private String postRemark;
    
    /**
     * 显示顺序
     */
    private Integer postSort;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
