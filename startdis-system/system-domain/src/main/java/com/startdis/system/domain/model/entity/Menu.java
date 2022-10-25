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
 * 菜单表
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 菜单编码
     */
    @TableField("menu_code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单类型
     */
    @TableField("menu_type")
    private String menuType;

    /**
     * 路由地址
     */
    @TableField("menu_path")
    private String menuPath;

    /**
     * 菜单图标
     */
    @TableField("menu_icon")
    private String menuIcon;

    /**
     * 组件路径
     */
    @TableField("menu_component")
    private String menuComponent;

    /**
     * 显示顺序
     */
    @TableField("menu_sort")
    private Integer menuSort;

    /**
     * 权限标识
     */
    @TableField("menu_permission")
    private String menuPermission;

    /**
     * 是否缓存（0不缓存 1缓存）
     */
    @TableField("keep_alive")
    private Integer keepAlive;

    /**
     * 是否可见（0正常 1隐藏）
     */
    @TableField("visible")
    private Integer visible;

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
