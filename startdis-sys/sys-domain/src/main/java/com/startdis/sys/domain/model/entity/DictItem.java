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
 * @desc 字典项表 DictItemDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dict_item")
public class DictItem extends BaseEntity {
    
    
    /**
     * 字典编码
     */
    private String dictCode;
    
    /**
     * 字典项值
     */
    private String itemValue;
    
    /**
     * 字典项标签
     */
    private String itemLabel;
    
    /**
     * 字典项描述
     */
    private String itemRemark;
    
    /**
     * 字典项排序
     */
    private Integer itemSort;
    
    /**
     * 字典项样式
     */
    private String itemStyle;
    
    /**
     * 字典项CSS
     */
    private String itemCss;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
