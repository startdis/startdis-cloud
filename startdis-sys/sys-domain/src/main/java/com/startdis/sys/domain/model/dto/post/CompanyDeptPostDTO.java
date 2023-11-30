package com.startdis.sys.domain.model.dto.post;


import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表 CompanyDeptDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "公司与部门关系表")
public class CompanyDeptPostDTO implements Serializable {
    private static final long serialVersionUID = 266239742214178681L;


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
