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
 * @desc 岗位表 PostDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_post")
public class Post extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
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
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
