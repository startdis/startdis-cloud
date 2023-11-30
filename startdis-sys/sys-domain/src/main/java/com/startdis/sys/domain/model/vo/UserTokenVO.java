package com.startdis.sys.domain.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 用户表 UserVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户信息表")
public class UserTokenVO implements Serializable {
    
    private static final long serialVersionUID = 487390868552834438L;
    
    /**
     * 公司租户ID
     */
    @ApiModelProperty("用户信息")
    private UserVO user;

    @ApiModelProperty("用户信息")
    private UserInfoVO userInfoVO;

    //@ApiModelProperty("拥有的应用集合")
    //private List<App> apps;

    @ApiModelProperty("拥有的菜单集合")
    private List<MenuVO> menus;
    
}
