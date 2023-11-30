package com.startdis.sys.domain.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户应用菜单表")
public class UserMenuTreeQuery implements Serializable {

    /**
     * 应用CODE
     */
    @ApiModelProperty("应用CODE")
    private String appCode;

    /**
     * 用户Id
     */
    @ApiModelProperty("用户Id")
    private String userId;
}
