package com.startdis.sys.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 通知公告表 NoticeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_notice")
public class Notice extends BaseEntity {
    
    
    /**
     * 公告编码
     */
    private String noticeCode;
    
    /**
     * 公告标题
     */
    private String noticeTitle;
    
    /**
     * 公告内容
     */
    private String noticeContent;
    
    /**
     * 公告类型（1公告 2通知）
     */
    private Integer noticeType;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
