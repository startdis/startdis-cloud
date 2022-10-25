package com.startdis.system.api.fallback;

import com.startdis.system.api.client.DemoClientApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoClientFallback implements DemoClientApi {
    @Setter
    private Throwable cause;

    @Override
    public String findById(int goodsId) {
        log.error("findById = {}", cause.getMessage());
        return null;
    }
}
