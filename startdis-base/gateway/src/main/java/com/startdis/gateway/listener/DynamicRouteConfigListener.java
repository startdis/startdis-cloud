package com.startdis.gateway.listener;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.startdis.gateway.service.DynamicRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * nacos监听器
 */
@Component
@Slf4j
public class DynamicRouteConfigListener {
    
    public static final long DEFAULT_TIMEOUT = 30000;
    
    @Resource
    private DynamicRoute dynamicRoute;
    
    private String dataId = "gateway-properties";
    
    @Value("${NACOS_HOST:127.0.0.1}:${NACOS_PORT:8848}")
    private String serverAddr;
    
    @Value("${spring.profiles.active:local}")
    private String namespace;
    
    @Value("${spring.profiles.active:local}")
    private String group;
    
    @PostConstruct
    public void dynamicRouteByNacosListener() throws NacosException {
        log.info("gateway-properties nacos config serverAddr is {} namespace is {} group is {}", serverAddr, namespace, group);
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        properties.put(PropertyKeyConst.NAMESPACE, namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        // 添加监听，nacos上的配置变更后会执行
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                // 解析和处理都交给RouteOperator完成
                dynamicRoute.refreshAll(configInfo);
            }
            
            @Override
            public Executor getExecutor() {
                return null;
            }
        });
        
        // 获取当前的配置
        String initConfig = configService.getConfig(dataId, group, DEFAULT_TIMEOUT);
        
        // 立即更新
        dynamicRoute.refreshAll(initConfig);
    }
    
}
