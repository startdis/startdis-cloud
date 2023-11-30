package com.startdis.sso.web;

import com.startdis.comm.feign.annotation.EnableStartdisFeignClients;
import com.startdis.comm.swagger.annotation.EnableStartdisSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 单点登录启动程序
 */
// @EnableLogRecord
@EnableDiscoveryClient
@EnableStartdisSwagger2
@EnableStartdisFeignClients
@SpringBootApplication(scanBasePackages = "com.startdis")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class SsoWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SsoWebApplication.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ TDCD SSO Web Startup Completed!   ლ(´ڡ`ლ)ﾞ ");

    }

}
