package com.startdis.comm.feign.aspect;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc Feign 配置注册
 */
@Configuration
public class FeignAutoConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
