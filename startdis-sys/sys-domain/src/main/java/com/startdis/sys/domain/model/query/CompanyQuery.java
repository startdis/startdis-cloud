package com.startdis.sys.domain.model.query;


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
 * @desc 公司表 CompanyQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "公司表")
public class CompanyQuery implements Serializable {
    
    private static final long serialVersionUID = 348844869145344920L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 父公司ID
     */
    @ApiModelProperty("父公司ID")
    private String parentId;
    
    /**
     * 公司编码
     */
    @ApiModelProperty("公司编码")
    private String companyCode;
    
    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String companyName;
    
    /**
     * 公司介绍
     */
    @ApiModelProperty("公司介绍")
    private String companyRemark;
    
    /**
     * 公司地址
     */
    @ApiModelProperty("公司地址")
    private String companyAddress;
    
    /**
     * 公司邮编
     */
    @ApiModelProperty("公司邮编")
    private String companyPostcode;
    
    /**
     * 传真号码
     */
    @ApiModelProperty("传真号码")
    private String companyFax;
    
    /**
     * 微信二维码
     */
    @ApiModelProperty("微信二维码")
    private String companyWechat;
    
    /**
     * 统一信用社会代码
     */
    @ApiModelProperty("统一信用社会代码")
    private String companyBlicense;
    
    /**
     * 其它信息
     */
    @ApiModelProperty("其它信息")
    private String companyOther;
    
    /**
     * 公司负责人ID
     */
    @ApiModelProperty("公司负责人ID")
    private String leaderUserId;
    
    /**
     * 公司负责人名称
     */
    @ApiModelProperty("公司负责人名称")
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer companySort;
    
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    
    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String phone;
    
    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
}

