package com.startdis.sys.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职位表 TitleDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "职位表")
public class TitlePostDTO implements Serializable {
    private static final long serialVersionUID = 484685513268747987L;


    /**
     * 职系ID
     */
    @ApiModelProperty("职系ID")
    private String gradeId;

    /**
     * 职系编码
     */
    @ApiModelProperty("职系编码")
    private String gradeCode;

    /**
     * 职位编码
     */
    @ApiModelProperty("职位编码")
    private String titleCode;

    /**
     * 职位名称
     */
    @ApiModelProperty("职位名称")
    private String titleName;

    /**
     * 职位描述
     */
    @ApiModelProperty("职位描述")
    private String titleRemark;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer titleSort;

    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;


}
