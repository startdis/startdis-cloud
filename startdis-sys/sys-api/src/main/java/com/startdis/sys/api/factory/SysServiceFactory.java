package com.startdis.sys.api.factory;

import com.startdis.sys.api.fallback.SysServiceFallback;
import com.startdis.sys.api.service.SysServiceApi;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dianjiu
 * @date 2021-10-21 上午9:48
 **/
@Component
public class SysServiceFactory implements FallbackFactory<SysServiceApi> {

    @Override
    public SysServiceApi create(Throwable cause) {
        SysServiceFallback fallback = new SysServiceFallback();
        fallback.setCause(cause);
        return fallback;
    }
}

