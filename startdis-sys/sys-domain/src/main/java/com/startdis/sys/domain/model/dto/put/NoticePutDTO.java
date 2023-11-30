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
 * @desc 通知公告表 NoticeDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "通知公告表")
public class NoticePutDTO implements Serializable {
    
    private static final long serialVersionUID = -95353858154358417L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 公告编码
     */
    @ApiModelProperty("公告编码")
    private String noticeCode;
    
    /**
     * 公告标题
     */
    @ApiModelProperty("公告标题")
    private String noticeTitle;
    
    /**
     * 公告内容
     */
    @ApiModelProperty("公告内容")
    private String noticeContent;
    
    /**
     * 公告类型（1公告 2通知）
     */
    @ApiModelProperty("公告类型（1公告 2通知）")
    private Integer noticeType;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
