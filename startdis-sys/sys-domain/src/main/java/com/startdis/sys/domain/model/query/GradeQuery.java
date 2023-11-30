package com.startdis.sys.domain.model.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职系表 GradeQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "职系表")
public class GradeQuery implements Serializable {
    private static final long serialVersionUID = -61259834553089647L;
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
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

