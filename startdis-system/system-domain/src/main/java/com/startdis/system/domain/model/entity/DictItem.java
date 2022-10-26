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
 * @desc 字典数据表 DictItemDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dict_item")
public class DictItem extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
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
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
