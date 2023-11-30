package com.startdis.sys.domain.model.query;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 上传的文件信息表 FileInfoQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "上传的文件信息表")
public class FileInfoQuery implements Serializable {
    private static final long serialVersionUID = 156282853092592849L;
    @ApiModelProperty("$column.comment")
    private String id;
    /**
     * 文件上传名称
     */
    @ApiModelProperty("文件上传名称")
    private String fileName;
    /**
     * 文件上传地址
     */
    @ApiModelProperty("文件上传地址")
    private String fileUrl;
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;

}

