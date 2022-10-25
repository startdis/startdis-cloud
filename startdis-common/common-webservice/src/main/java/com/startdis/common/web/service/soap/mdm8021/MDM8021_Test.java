package com.startdis.common.web.service.soap.mdm8021;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-22 15:40
 * @desc
 */
public class MDM8021_Test {
    public static void main(String[] args) {
        System.out.println("web service start");
        Mdm8021WebServiceImpl implementor = new Mdm8021WebServiceImpl();
        String address = "http://127.0.0.1:5000/ws/api/supplier8021";
        /*
         * Created by dianjiu on 2022-06-22 ,contact dianjiusir@gmail.com.
         * 方式二：JDK实现.
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
        System.out.println("web service started");
        System.out.println("访问地址: "+address+"?wsdl");
    }
}
