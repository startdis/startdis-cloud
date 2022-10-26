package com.startdis.system.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.common.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 社交用户绑定表 SocialUserBindDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_social_user_bind")
public class SocialUserBind extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 系统用户ID
     */
    private String userId;
    
    /**
     * 用户类型
     */
    private String userType;
    
    /**
     * 社交用户ID
     */
    private String socialUserId;
    
    /**
     * 社交平台的类型
     */
    private String socialType;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
