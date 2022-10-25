package com.startdis.common.web.service.config;


import com.startdis.common.web.service.soap.mdm8021.Mdm8021WebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-22 15:14
 * @desc
 */
@Configuration
public class CxfConfig implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger(CxfConfig.class);

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "cxfServlet")
    public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/ws/*");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("web service start");
        Mdm8021WebServiceImpl implementor = new Mdm8021WebServiceImpl();
        String address = "http://127.0.0.1:5000/ws/api/supplier8021";
        /*
         * Created by dianjiu on 2022-06-22 ,contact dianjiusir@gmail.com.
         * 方式一：JDK实现.
         */
        //Endpoint.publish(address, implementor);
        /*
         * Created by dianjiu on 2022-06-22 ,contact dianjiusir@gmail.com.
         * 方式二：cxf.
         */
        // 发布服务的工厂
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        // 设置暴露地址
        factoryBean.setAddress(address);
        // 设置接口类
        //factoryBean.setServiceClass(Mdm8021WebService.class);
        // 设置实现类
        factoryBean.setServiceBean(implementor);
        // 添加请求消息拦截器
        //factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        // 添加响应消息拦截器
        //factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        //发布服务
        factoryBean.create();
        log.info("web service started");
        log.info("接口地址:http://{}/{}", address, "ws/api/supplier8021");
        log.info("文档地址:http://{}/{}", address, "ws/api/supplier8021?wsdl");
    }

    //@Bean
    //@Qualifier("mdm8018WebServiceImpl")
    //public Endpoint endpoint8018(@Qualifier("mdm8018WebServiceImpl") Mdm8018WebService mdm8018WebService) throws Exception {
    //    EndpointImpl endpoint = new EndpointImpl(springBus(), mdm8018WebService);
    //    endpoint.publish("/api/supplier8018");
    //    String ip = Inet4Address.getLocalHost().getHostAddress();
    //    String port = SpringProperties.getString("server.port");
    //    log.info("接口地址:http://{}:{}/{}", ip, port, "ws/api/supplier8018");
    //    log.info("文档地址:http://{}:{}/{}", ip, port, "ws/api/supplier8018?wsdl");
    //    return endpoint;
    //}
}
