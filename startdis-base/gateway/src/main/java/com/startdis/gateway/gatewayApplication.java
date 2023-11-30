package com.startdis.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关服务启动程序
 */
@EnableDiscoveryClient
//@SpringBootApplication(scanBasePackages = "com.startdis")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class gatewayApplication {
    public static void main(String[] args) {

        SpringApplication.run(gatewayApplication.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ 启迪网关服务启动成功   ლ(´ڡ`ლ)ﾞ ");

    }
}
