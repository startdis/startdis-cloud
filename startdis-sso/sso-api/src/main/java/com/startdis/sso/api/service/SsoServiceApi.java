package com.startdis.sso.api.service;

import com.startdis.comm.feign.aspect.FeignRequestInterceptor;
import com.startdis.sso.api.client.SsoApi;
import com.startdis.sso.api.factory.SsoServiceFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "tdcd-sso-web", configuration = FeignRequestInterceptor.class, fallbackFactory = SsoServiceFactory.class)
public interface SsoServiceApi extends SsoApi {

}
