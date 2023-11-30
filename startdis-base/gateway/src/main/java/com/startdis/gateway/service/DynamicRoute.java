package com.startdis.gateway.service;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startdis.gateway.domian.StartdisRouteDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由更新服务
 */
@Slf4j
@Component
public class DynamicRoute implements ApplicationEventPublisherAware {
    
    private static final List<String> routeList = new ArrayList<>();
    
    @Resource
    private ObjectMapper objectMapper;
    
    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;
    
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    
    public DynamicRoute(ObjectMapper objectMapper, RouteDefinitionWriter routeDefinitionWriter, ApplicationEventPublisher applicationEventPublisher) {
        this.objectMapper = objectMapper;
        this.routeDefinitionWriter = routeDefinitionWriter;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
    
    /**
     * 清理集合中的所有路由，并清空集合
     */
    private void clear() {
        // 全部调用API清理掉
        try {
            routeList.forEach(id -> routeDefinitionWriter.delete(Mono.just(id)).subscribe());
        } catch (Exception e) {
            log.error("clear Route is error !");
        }
        // 清空集合
        routeList.clear();
    }
    
    /**
     * 新增路由
     *
     * @param routeDefinitions
     */
    private void add(List<StartdisRouteDefinition> routeDefinitions) {
        
        try {
            routeDefinitions.forEach(routeDefinition -> {
                routeDefinitionWriter.save(Mono.just(routeDefinition.getRouteDefinition())).subscribe();
                routeList.add(routeDefinition.getId());
            });
        } catch (Exception exception) {
            log.error("add route is error", exception);
        }
    }
    
    /**
     *发布路由、使路由生效
     */
    private void publish() {
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this.routeDefinitionWriter));
    }
    
    /**
     * 更新所有路由信息
     *
     * @param configStr
     */
    public void refreshAll(String configStr) {
        log.info("start refreshAll : {}", configStr);
        // 无效字符串不处理
        if (!StringUtils.hasText(configStr)) {
            log.error("invalid string for route config");
            return;
        }
        // 用Jackson反序列化
        List<StartdisRouteDefinition> routeDefinitions = null;
        try {
            routeDefinitions = objectMapper.readValue(configStr, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            log.error("get route definition from nacos string error", e);
        }
        // 如果等于null，表示反序列化失败，立即返回
        if (CollectionUtil.isEmpty(routeDefinitions)) {
            return;
        }
        // 清理掉当前所有路由
        clear();
        // 添加最新路由
        add(routeDefinitions);
        
        // 通过应用内消息的方式发布
        publish();
        
        log.info("finish refreshAll");
    }
}
