package com.startdis.sys.domain.model.query;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表 CompanyDeptQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "公司与部门关系表")
public class CompanyDeptQuery implements Serializable {
    private static final long serialVersionUID = 959829361621284546L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String deptId;
    /**
     * 公司ID
     */
    @ApiModelProperty("公司ID")
    private String companyId;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;

}

