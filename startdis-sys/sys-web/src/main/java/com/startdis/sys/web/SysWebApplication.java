package com.startdis.sys.web;

import com.startdis.comm.feign.annotation.EnableStartdisFeignClients;
import com.startdis.comm.swagger.annotation.EnableStartdisSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 统一权限启动程序
 */
// @EnableLogRecord
@EnableDiscoveryClient
@EnableStartdisSwagger2
@EnableStartdisFeignClients
@SpringBootApplication(scanBasePackages = "com.startdis")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class SysWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SysWebApplication.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ TDCD SYS Web Startup Completed!   ლ(´ڡ`ლ)ﾞ ");

    }

}
