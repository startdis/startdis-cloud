package com.startdis.gateway.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 处理网关跨域
 */
@Configuration
public class CronConfig {
    
    // 该配置适用于servlet环境
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        //1. 添加 CORS配置信息
        CorsConfiguration corsConfig = new CorsConfiguration();
        //放行哪些原始域
        //是否支持跨域Cookie
        corsConfig.setAllowCredentials(true);
        //配置访问的地址，*代表所有的都可以访问
        //corsConfig.addAllowedOrigin("http://localhost:8080");
        corsConfig.addAllowedOriginPattern(CorsConfiguration.ALL);
        //允许的请求头参数
        corsConfig.addAllowedHeader(CorsConfiguration.ALL);
        //允许的请求头参数
        corsConfig.addAllowedMethod(CorsConfiguration.ALL);
        //默认可不设置这个暴露的头。这个为了安全问题，不能使用*。设置成*，后面会报错：throw new IllegalArgumentException("'*' is not a valid exposed header value");
        //corsConfig.addExposedHeader("");
        corsConfig.setMaxAge(3600L);
        //2. 添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", corsConfig);
        //3. 返回新的CorsFilter
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(configSource));
        corsBean.setName("crossOriginFilter");
        //这个顺序也有可能会有影响，尽量设置在拦截器前面
        corsBean.setOrder(-1);
        return corsBean;
    }
    
}
