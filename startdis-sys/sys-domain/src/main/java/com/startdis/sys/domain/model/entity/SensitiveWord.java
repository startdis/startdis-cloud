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
 * @desc 系统敏感词表 SensitiveWordDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_sensitive_word")
public class SensitiveWord extends BaseEntity {
    
    
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
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
