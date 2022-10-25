package com.startdis.system.domain.model.dto.post;

import com.startdis.system.domain.model.dto.CompanyPostDTO;
import com.startdis.system.domain.model.dto.UsersPostDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 平台注册 RegisterDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "注册信息")
public class RegisterDTO implements Serializable {
    
    private static final long serialVersionUID = -74055113226571260L;
    
    
    /**
     * 公司信息
     */
    @ApiModelProperty("公司信息")
    private CompanyPostDTO companyPostDTO;
    
    /**
     * 用户信息
     */
    @ApiModelProperty("用户信息")
    private UsersPostDTO usersPostDTO;
    
}
