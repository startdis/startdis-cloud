package com.startdis.system.api.factory;

import com.startdis.system.api.client.DemoClientApi;
import com.startdis.system.api.fallback.DemoClientFallback;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoClientFactory implements FallbackFactory<DemoClientApi> {

    @Override
    public DemoClientApi create(Throwable cause) {
        DemoClientFallback fallback = new DemoClientFallback();
        fallback.setCause(cause);
        return fallback;
    }
}

