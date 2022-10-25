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
 * @desc 岗位表 PostQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "岗位表")
public class PostQuery implements Serializable {
    
    private static final long serialVersionUID = -18547036210276711L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 岗位编码
     */
    @ApiModelProperty("岗位编码")
    private String postCode;
    
    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String postName;
    
    /**
     * 岗位描述
     */
    @ApiModelProperty("岗位描述")
    private String postRemark;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer postSort;
    
    /**
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
}

