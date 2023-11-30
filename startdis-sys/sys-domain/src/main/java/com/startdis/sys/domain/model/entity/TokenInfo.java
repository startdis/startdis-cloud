package com.startdis.sys.domain.model.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表 TokenInfoDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_token_info")
public class TokenInfo extends BaseEntity {


    /**
     * 应用鉴权令牌
     */
    private String accesstoken;

    /**
     * 应用刷新令牌
     */
    private String refreshtoken;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
