package com.startdis.system.domain.model.dto;


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
 * @email startdis@cloud-number.cn
 * @desc 用户表 UsersDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户表")
public class UsersPutDTO implements Serializable {
    
    private static final long serialVersionUID = 809259756602416244L;
    
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
     * 用户邮箱
     */
    @ApiModelProperty("用户邮箱")
    private String email;
    
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String phone;
    
    /**
     * 用户性别（0女性 1男性）
     */
    @ApiModelProperty("用户性别（0女性 1男性）")
    private Integer sex;
    
    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String avatar;
    
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
     * 数据状态（0正常 1停用）
     */
    @ApiModelProperty("数据状态（0正常 1停用）")
    private Integer status;
    
    
}
