package com.startdis.sys.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职系表 GradeDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "职系表")
public class GradePostDTO implements Serializable {
    private static final long serialVersionUID = -82512785766797411L;


    /**
     * 职系编码
     */
    @ApiModelProperty("职系编码")
    private String gradeCode;

    /**
     * 职系名称
     */
    @ApiModelProperty("职系名称")
    private String gradeName;

    /**
     * 职系描述
     */
    @ApiModelProperty("职系描述")
    private String gradeRemark;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer gradeSort;

    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}
