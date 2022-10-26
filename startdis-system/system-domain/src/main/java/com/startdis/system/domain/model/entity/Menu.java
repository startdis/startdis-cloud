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
 * @desc 菜单表 MenuDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class Menu extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 父菜单ID
     */
    private String parentId;
    
    /**
     * 菜单编码
     */
    private String menuCode;
    
    /**
     * 菜单名称
     */
    private String menuName;
    
    /**
     * 菜单类型
     */
    private String menuType;
    
    /**
     * 路由地址
     */
    private String menuPath;
    
    /**
     * 菜单图标
     */
    private String menuIcon;
    
    /**
     * 组件路径
     */
    private String menuComponent;
    
    /**
     * 显示顺序
     */
    private Integer menuSort;
    
    /**
     * 权限标识
     */
    private String menuPermission;
    
    /**
     * 是否缓存（0不缓存 1缓存）
     */
    private Integer keepAlive;
    
    /**
     * 是否可见（0正常 1隐藏）
     */
    private Integer visible;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
