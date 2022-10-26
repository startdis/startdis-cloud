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
 * @desc 系统敏感词表 SensitiveWordDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_sensitive_word")
public class SensitiveWord extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 敏感词
     */
    private String wordName;
    
    /**
     * 敏感词标签
     */
    private String wordTags;
    
    /**
     * 敏感词描述
     */
    private String wordRemark;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
