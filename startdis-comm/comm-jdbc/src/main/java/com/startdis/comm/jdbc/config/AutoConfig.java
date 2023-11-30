package com.startdis.comm.jdbc.config;

import com.startdis.comm.jdbc.handler.CompanyTenantHandler;
import com.startdis.comm.jdbc.handler.GroupTenantHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 自动配置类
 */
@Configuration
@Import({CompanyTenantHandler.class, GroupTenantHandler.class,TenantConfig.class})
public class AutoConfig {



}
