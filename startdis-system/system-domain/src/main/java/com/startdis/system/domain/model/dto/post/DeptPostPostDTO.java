package com.startdis.system.domain.model.dto;


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
 * @desc 部门岗位表 DeptPostDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "部门岗位表")
public class DeptPostPostDTO implements Serializable {
    
    private static final long serialVersionUID = 498494740252827775L;
    
    
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String deptId;
    
    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    private String postId;
    
    
}
