package com.startdis.common.rfc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-07-14
 * @desc
 */
@Data
@Component
@ConfigurationProperties(prefix = "rfc")
public class RfcProperties {

    /**
     * 基础连接
     */
    private Client client = new Client();
    /**
     * 连接池配置
     */
    private Destination destination = new Destination();

    @Data
    public static class Client {
        //SAP服务器
        private String ashost;
        //SAP系统编号
        private String sysnr;
        //SAP集团
        private String client;
        //SAP用户
        private String user;
        //SAP密码
        private String passwd;
        //SAP语言
        private String lang;
    }

    @Data
    public static class Destination {
        //最大连接数
        private String peakLimit;
        //最大连接线程
        private String poolCapacity;
    }
}
