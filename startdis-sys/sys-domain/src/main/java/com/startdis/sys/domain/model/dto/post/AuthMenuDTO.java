package com.startdis.sys.domain.model.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单中间表 AuthMenuDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "角色菜单中间表")
public class AuthMenuDTO {
    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private String menuId;

    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0部分授权 1全部授权）")
    private Integer status;
}
