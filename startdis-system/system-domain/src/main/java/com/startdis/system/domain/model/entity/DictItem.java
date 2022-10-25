package com.startdis.system.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict_item")
public class DictItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    @TableField("dict_code")
    private String dictCode;

    /**
     * 字典项值
     */
    @TableField("item_value")
    private String itemValue;

    /**
     * 字典项标签
     */
    @TableField("item_label")
    private String itemLabel;

    /**
     * 字典项描述
     */
    @TableField("item_remark")
    private String itemRemark;

    /**
     * 字典项排序
     */
    @TableField("item_sort")
    private Integer itemSort;

    /**
     * 字典项样式
     */
    @TableField("item_style")
    private String itemStyle;

    /**
     * 字典项CSS
     */
    @TableField("item_css")
    private String itemCss;

    /**
     * 数据状态（0正常 1停用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否删除（0正常 1删除）
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 租户号
     */
    @TableField("tenant_id")
    private String tenantId;


}
