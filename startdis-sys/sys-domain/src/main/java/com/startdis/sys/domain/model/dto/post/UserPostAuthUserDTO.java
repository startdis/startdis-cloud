package com.startdis.sys.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户岗位表 UserPostDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户岗位表")
public class UserPostAuthUserDTO implements Serializable {
    
    private static final long serialVersionUID = -95209338585477984L;
    
    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    private String postId;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID集合")
    private List<String> userIds;
    
}
