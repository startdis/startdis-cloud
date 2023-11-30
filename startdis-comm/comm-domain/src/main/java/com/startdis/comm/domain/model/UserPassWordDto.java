package com.startdis.comm.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户账号密码DTO")
public class UserPassWordDto {
    @ApiModelProperty("用户账号")
    @NotBlank(message = "用户账号不能为空!")
    private String userCode;

    @ApiModelProperty("用户旧密码")
    @NotBlank(message = "旧密码不能为空!")
    private String oldPassWord;

    @ApiModelProperty("用户新密码")
    @NotBlank(message = "新密码不能为空!")
    private String newPassWord;

    @ApiModelProperty("用户新密码")
    @NotBlank(message = "确认密码不能为空!")
    private String againPassWord;
}
