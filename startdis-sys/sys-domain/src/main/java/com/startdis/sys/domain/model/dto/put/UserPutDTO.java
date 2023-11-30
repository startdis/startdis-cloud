package com.startdis.sys.domain.model.dto.put;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表 UserDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户表")
public class UserPutDTO implements Serializable {
    
    private static final long serialVersionUID = 259754425324036043L;
    
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String deptId;
    
    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    private String postId;
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String userCode;
    
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;
    
    /**
     * 用户描述
     */
    @ApiModelProperty("用户描述")
    private String userRemark;
    
    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;
    
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    
    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String phone;
    
    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;
    
    /**
     * 用户性别（0女性 1男性）
     */
    @ApiModelProperty("用户性别（0女性 1男性）")
    private Integer sex;
    
    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headPic;
    
    /**
     * 最后登录IP
     */
    @ApiModelProperty("最后登录IP")
    private String loginIp;
    
    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginDate;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}
