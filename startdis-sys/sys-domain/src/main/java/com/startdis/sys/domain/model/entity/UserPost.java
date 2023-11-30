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
 * @desc 用户岗位表 UserPostDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_post")
public class UserPost extends BaseEntity {
    
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 岗位ID
     */
    private String postId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}
