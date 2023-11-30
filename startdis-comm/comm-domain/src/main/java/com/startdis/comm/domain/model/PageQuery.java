package com.startdis.comm.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc PageQuery
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@ApiModel(value = "基础分页实体")
public class PageQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "pageNum当前页不能为空")
    @ApiModelProperty("当前页")
    private Integer pageNum;

    @NotBlank(message = "pageSize页大小不能为空")
    @ApiModelProperty("页大小")
    private Integer pageSize;

    @ApiModelProperty("指定排序字段")
    private String orderBy;
}
