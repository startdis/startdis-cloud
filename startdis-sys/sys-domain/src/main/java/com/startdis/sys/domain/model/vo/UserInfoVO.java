package com.startdis.sys.domain.model.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 用户表 UserVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户信息表")
public class UserInfoVO implements Serializable {
    
    private static final long serialVersionUID = 487390868552834438L;

    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 系统用户ID
     */
    @ApiModelProperty("系统用户ID")
    private String userId;

    /**
     * 应用用户ID
     */
    @ApiModelProperty("应用用户ID")
    private String uniqueId;
    
    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String userCode;
    
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    
    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headPic;
    
    /**
     * 最后登录IP
     */
    @ApiModelProperty("最后登录IP")
    private String loginIp;
    
    /**
     * 最后登录时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginDate;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
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

    @ApiModelProperty("公司租户名称")
    private String companyTenantName;

    //@ApiModelProperty("拥有的菜单集合")
    //private List<MenuTree> menus;

    @ApiModelProperty("部门ID")
    private String deptId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
