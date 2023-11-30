package com.startdis.comm.jdbc.handler;


import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.startdis.comm.jdbc.config.InterceptConfig;
import com.startdis.comm.util.auth.TenantHolder;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 租户拦截器抽象类
 */
@Slf4j
public abstract class AbstractTenantHandler extends AbstractSqlHandler implements TenantLineHandler {


    @Value("${spring.application.name}")
    private String applicationContextName;

    private final static List<String> IGNORE_APP_NAME = List.of("startdis-open-service-web","startdis-cms-service-web");


    public AbstractTenantHandler(InterceptConfig interceptConfig) {
        super(interceptConfig);
    }


    protected abstract String doGetTenantId();

    @Override
    public Expression getTenantId() {
        return new StringValue(doGetTenantId());
    }

    @Override
    public String getTenantIdColumn() {
        return handleColumn(interceptConfig.getColumn());
    }

    @Override
    public boolean ignoreTable(String tableName) {
        return defaultIgnoreStrategy(tableName, interceptConfig);
    }

    protected boolean customIgnore(){
        // 忽略的服务
        if (IGNORE_APP_NAME.contains(applicationContextName)){
            return true;
        }
        Boolean isAdmin=Optional.ofNullable(TenantHolder.isAdmin()).orElse(false);
        // 是否是不拦截的请求
        Boolean ignoredRequest = Optional.ofNullable(TenantHolder.getIgnoredRequest()).orElse(false);
        // 拦截未打开、忽略的请求、ebg账号---》这些情况都忽略掉
        return  ignoredRequest || isAdmin;
    }

}
