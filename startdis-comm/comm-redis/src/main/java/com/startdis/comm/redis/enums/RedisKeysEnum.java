package com.startdis.comm.redis.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Redis key枚举类
 *
 * @author dianjiu
 * @date 2021-12-7 16:10:35
 */
@Getter
@AllArgsConstructor
public enum RedisKeysEnum {
    /**
     * 客户登录token,24小时失效 1:{} = customerId 2:{} = token 使用方式 RedisKeysEnum.CUSTOMER_LOGIN_TOKEN.getKey(customerId,token)
     */
    //CUSTOMER_LOGIN_TOKEN("customer.login.token:{}:{}"),
    AUTH_CODE("tdcd-cloud-sso:auth-code:{}"),
    ACCESS_TOKEN("tdcd-cloud-sso:access-token:{}");;


    /**
     * redis key
     */
    private String key;

    /**
     * key失效时间，单位秒
     */
    //private Long expireAt;
    public String getKey(String... key) {
        return StrUtil.format(this.key, key);
    }
}
