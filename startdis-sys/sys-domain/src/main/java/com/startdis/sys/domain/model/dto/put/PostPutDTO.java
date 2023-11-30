package com.startdis.sys.domain.model.dto.put;


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
 * @desc 岗位表 PostDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "岗位表")
public class PostPutDTO implements Serializable {
    
    private static final long serialVersionUID = -31176569028171655L;
    
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
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
