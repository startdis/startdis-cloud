package com.startdis.sso.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 授权码表 OauthCodeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sso_oauth_code")
public class OauthCode extends BaseEntity {


    /**
     * 授权码
     */
    private String authCode;

    /**
     * 过期时间
     */
    private LocalDateTime expiresAt;

    /**
     * 是否已用（0正常 1已用）
     */
    private Integer used;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
