package com.startdis.sys.domain.model.dto.put;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 菜单表 MenuDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "菜单表")
public class MenuPutDTO implements Serializable {
    
    private static final long serialVersionUID = 506425694486350832L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;

    /**
     * 应用编码
     */
    @ApiModelProperty("应用编码")
    private String appCode;

    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String appName;
    
    /**
     * 父菜单ID
     */
    @ApiModelProperty("父菜单ID")
    private String parentId;
    
    /**
     * 菜单编码
     */
    @ApiModelProperty("菜单编码")
    private String menuCode;
    
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;
    
    /**
     * 菜单类型
     */
    @ApiModelProperty("菜单类型")
    private String menuType;
    
    /**
     * 路由地址
     */
    @ApiModelProperty("路由地址")
    private String menuPath;
    
    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String menuIcon;
    
    /**
     * 组件路径
     */
    @ApiModelProperty("组件路径")
    private String menuComponent;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer menuSort;
    
    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String menuPermission;
    
    /**
     * 是否创建快捷方式（0停用 1启用）
     */
    @ApiModelProperty("是否创建快捷方式（0停用 1启用）")
    private Integer menuShortcut;
    
    /**
     * 是否缓存（0不缓存 1缓存）
     */
    @ApiModelProperty("是否缓存（0不缓存 1缓存）")
    private Integer keepAlive;
    
    /**
     * 是否可见（0隐藏 1显示）
     */
    @ApiModelProperty("是否可见（0隐藏 1显示）")
    private Integer visible;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
