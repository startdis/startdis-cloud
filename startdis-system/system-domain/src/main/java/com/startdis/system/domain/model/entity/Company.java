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
 * @desc 公司表 CompanyDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_company")
public class Company extends BaseEntity {
    
    /**
     * ID
     */
    @TableId
    private String id;
    
    /**
     * 父公司ID
     */
    private String parentId;
    
    /**
     * 公司编码
     */
    private String companyCode;
    
    /**
     * 公司名称
     */
    private String companyName;
    
    /**
     * 公司负责人ID
     */
    private String leaderUserId;
    
    /**
     * 公司负责人名称
     */
    private String leaderUserName;
    
    /**
     * 显示顺序
     */
    private Integer companySort;
    
    /**
     * 联系电话
     */
    private String phone;
    
    /**
     * 联系邮箱
     */
    private String email;
    
    /**
     * 数据状态（0正常 1停用）
     */
    private Integer status;
    
    
}
