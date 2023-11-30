package com.startdis.sys.domain.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 菜单表 MenuVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "菜单表")
public class MenuVO implements Serializable {
    
    private static final long serialVersionUID = 811655869777046939L;
    /**
     * 应用编码（自定义）
     */
    @ApiModelProperty("应用编码（自定义）")
    private String appCode;

    /**
     * 应用标识（系统生成）
     */
    @ApiModelProperty("应用标识（系统生成）")
    private String appKey;

    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String appName;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
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
    
    /**
     * 是否删除（0正常 1删除）
     */
    @ApiModelProperty("是否删除（0正常 1删除）")
    private Integer deleted;
    
    /**
     * 乐观锁
     */
    @ApiModelProperty("乐观锁")
    private Long revision;
    
    /**
     * 集团租户ID
     */
    @ApiModelProperty("集团租户ID")
    private String groupTenantId;
    
    /**
     * 公司租户ID
     */
    @ApiModelProperty("公司租户ID")
    private String companyTenantId;
    
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;
    
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;
    
}
