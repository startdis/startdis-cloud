package com.startdis.comm.core.constant;


import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 过滤器忽略常量
 */
public class FilterIgnoreConstant {
    /**
     * 默认全部忽略的url 一般用于跟服务无关的
     */
    public static final Set<String> FILTER_COMMON_IGNORE_URL = Sets.newHashSet("/**/swagger**/**", "/**/webjars/**",
            "/**/v2/api-docs", "/**/v3/api-docs", "/**/error", "/**/doc.html", "/doc.html", "/**/favicon.ico");

    /**
     * 全局拦截器忽略的服务
     */
    public static final Set<String> AUTH_FILTER_IGNORE_SERVICE_NAME = Sets.newHashSet("startdis-open-service-web");
}
