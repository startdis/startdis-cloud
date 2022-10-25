package com.startdis.common.web.socket.config;

import com.startdis.common.web.socket.handler.CustomWebSocketHandler;
import com.startdis.common.web.socket.interceptor.CustomWebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * 启用WebSocket和注册Handler
 * @author DianJiu
 * 通过实现 WebSocketMessageBrokerConfigurer 接口和加上@EnableWebSocketMessageBroker来进行 stomp 的配置与注解扫描。
 */
@Configuration
@EnableWebSocket
//@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketConfigurer {

    private final CustomWebSocketHandler customWebSocketHandler;
    private final CustomWebSocketInterceptor customWebSocketInterceptor;

    public WebSocketConfig(CustomWebSocketHandler customWebSocketHandler,CustomWebSocketInterceptor customWebSocketInterceptor) {
        this.customWebSocketHandler = customWebSocketHandler;
        this.customWebSocketInterceptor = customWebSocketInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 配置客户端尝试连接地址
        registry.addHandler(customWebSocketHandler, "/ws")
//                .addInterceptors(customWebSocketInterceptor)
                .setAllowedOrigins("*");
    }

    //@Override
    //public void registerStompEndpoints(StompEndpointRegistry registry) {
    //    // 配置客户端尝试连接地址
    //    registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    //}
    //
    //@Override
    //public void configureMessageBroker(MessageBrokerRegistry registry) {
    //    // 设置广播节点
    //    registry.enableSimpleBroker("/topic", "/user");
    //    // 客户端向服务端发送消息需有/app 前缀
    //    registry.setApplicationDestinationPrefixes("/app");
    //    // 指定用户发送（一对一）的前缀 /user/
    //    registry.setUserDestinationPrefix("/user/");
    //}

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
