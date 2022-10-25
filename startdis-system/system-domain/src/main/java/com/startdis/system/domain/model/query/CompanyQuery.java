package com.startdis.system.domain.model.query;


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
 * @email startdis@cloud-number.cn
 * @desc 公司表 CompanyQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "公司表")
public class CompanyQuery implements Serializable {
    
    private static final long serialVersionUID = 590253967030672760L;
    
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
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
}

