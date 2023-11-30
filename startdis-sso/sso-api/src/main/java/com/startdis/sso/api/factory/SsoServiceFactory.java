package com.startdis.sso.api.factory;


import com.startdis.sso.api.fallback.SsoServiceFallback;
import com.startdis.sso.api.service.SsoServiceApi;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dianjiu
 * @date 2021-10-21 上午9:48
 **/
@Component
public class SsoServiceFactory implements FallbackFactory<SsoServiceApi> {

    @Override
    public SsoServiceApi create(Throwable cause) {
        SsoServiceFallback fallback = new SsoServiceFallback();
        fallback.setCause(cause);
        return fallback;
    }
}

