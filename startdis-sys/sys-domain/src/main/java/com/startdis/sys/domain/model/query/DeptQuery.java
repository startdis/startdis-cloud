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
 * @desc 部门表 DeptQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "部门表")
public class DeptQuery implements Serializable {
    
    private static final long serialVersionUID = 597639550121585991L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 父部门ID
     */
    @ApiModelProperty("父部门ID")
    private String parentId;

    /**
     * 公司ID
     */
    @ApiModelProperty("公司ID")
    private String companyId;

    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String companyName;
    
    /**
     * 部门编码
     */
    @ApiModelProperty("部门编码")
    private String deptCode;
    
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String deptName;
    
    /**
     * 部门负责人ID
     */
    @ApiModelProperty("部门负责人ID")
    private String leaderUserId;

    /**
     * 部门负责人编码
     */
    @ApiModelProperty("部门负责人编码")
    private String leaderUserCode;
    
    /**
     * 部门负责人名称
     */
    @ApiModelProperty("部门负责人名称")
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer deptSort;
    
    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String phone;
    
    /**
     * 联系邮箱
     */
    @ApiModelProperty("联系邮箱")
    private String email;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}

