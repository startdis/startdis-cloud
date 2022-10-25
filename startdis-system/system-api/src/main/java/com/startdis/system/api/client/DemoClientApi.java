package com.startdis.system.api.client;

import com.startdis.system.api.factory.DemoClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "system-service-web",  fallbackFactory = DemoClientFactory.class)
//@FeignClient(value = "system-service-web", configuration = FeignHeaderRequestInterceptor.class), fallbackFactory = ProductServiceFactory.class)
public interface DemoClientApi {

    @GetMapping("/api/v1/goods/findByGoodsId")
    String findById(@RequestParam("goodsId") int goodsId);
}
