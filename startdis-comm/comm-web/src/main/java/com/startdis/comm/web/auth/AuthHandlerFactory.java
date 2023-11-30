package com.startdis.comm.web.auth;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.startdis.comm.core.enums.ServiceTypeEnum;
import com.startdis.comm.util.asserts.AssertKits;

import java.util.Map;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc AuthHandlerFactory
 */
public class AuthHandlerFactory {

    public static AuthHandler getAuthHandler(ServiceTypeEnum serviceTypeEnum) {
        Map<String, AuthHandler> authHandlerMap = SpringUtil.getBeansOfType(AuthHandler.class);
        AssertKits.check(CollectionUtil.isNotEmpty(authHandlerMap), "AuthHandler 服务未注册");
        switch (serviceTypeEnum) {
            case WEB_SERVICE:
                return authHandlerMap.get("webAuthHandler");
            case APP_SERVICE:
                return authHandlerMap.get("appAuthHandler");
            default:
                return authHandlerMap.get("defaultAuthHandler");
        }
    }

}
