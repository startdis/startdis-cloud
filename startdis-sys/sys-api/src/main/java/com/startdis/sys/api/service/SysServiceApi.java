package com.startdis.sys.api.service;

import com.startdis.comm.feign.aspect.FeignRequestInterceptor;
import com.startdis.sys.api.SysApi;
import com.startdis.sys.api.factory.SysServiceFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "tdcd-sys-web", configuration = FeignRequestInterceptor.class, fallbackFactory = SysServiceFactory.class)
public interface SysServiceApi extends SysApi {

}
