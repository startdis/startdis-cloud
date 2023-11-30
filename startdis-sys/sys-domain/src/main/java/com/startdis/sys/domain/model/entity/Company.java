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
 * @desc 公司表 CompanyDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_company")
public class Company extends BaseEntity {
    
    
    /**
     * 父公司ID
     */
    private String parentId;
    
    /**
     * 公司编码
     */
    private String companyCode;
    
    /**
     * 公司名称
     */
    private String companyName;
    
    /**
     * 公司介绍
     */
    private String companyRemark;
    
    /**
     * 公司地址
     */
    private String companyAddress;
    
    /**
     * 公司邮编
     */
    private String companyPostcode;
    
    /**
     * 传真号码
     */
    private String companyFax;
    
    /**
     * 微信二维码
     */
    private String companyWechat;
    
    /**
     * 统一信用社会代码
     */
    private String companyBlicense;
    
    /**
     * 其它信息
     */
    private String companyOther;
    
    /**
     * 公司负责人ID
     */
    private String leaderUserId;
    
    /**
     * 公司负责人名称
     */
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    private Integer companySort;
    
    /**
     * 手机号码
     */
    private String mobile;
    
    /**
     * 电话号码
     */
    private String phone;
    
    /**
     * 电子邮箱
     */
    private String email;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
