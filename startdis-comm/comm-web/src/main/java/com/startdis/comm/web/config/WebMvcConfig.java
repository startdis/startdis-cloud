package com.startdis.comm.web.config;


import com.startdis.comm.web.filter.AuthFilter;
import com.startdis.comm.web.interceptor.HttpInterceptor;
import com.startdis.comm.web.interceptor.TenantInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc WebMvcConfig
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    /**
     * 防抖过滤器
     */
    //@Autowired
    
    //private ResubmitFilter resubmitFilter;
    
    /**
     * 租户拦截器
     */
    @Resource
    private TenantInterceptor tenantInterceptor;
    
    /**
     * Http拦截器
     */
    @Resource
    private HttpInterceptor httpInterceptor;
    
    /**
     * 防抖拦截器
     */
    //@Autowired
    //private ResubmitInterceptor resubmitInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantInterceptor).addPathPatterns("/**").order(Integer.MIN_VALUE);
        registry.addInterceptor(httpInterceptor).addPathPatterns("/**").order(Integer.MAX_VALUE);
        //registry.addInterceptor(resubmitInterceptor).addPathPatterns("/**").order(Integer.MAX_VALUE);
    }
    
    /**
     * 解决跨域请求 方式一：
     */
    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //    //项目中的所有接口都支持跨域
    //    registry.addMapping("/**")
    //            //是否支持跨域Cookie
    //            .allowCredentials(true)
    //            //配置访问的地址，*代表所有的都可以访问
    //            //.allowedOrigins("http://localhost:8080")
    //            .allowedOriginPatterns(CorsConfiguration.ALL)
    //            //允许的请求头参数
    //            .allowedHeaders(CorsConfiguration.ALL)
    //            //允许的请求方式 "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"
    //            .allowedMethods(CorsConfiguration.ALL)
    //            // 跨域允许时间
    //            .maxAge(3600);
    //
    //    WebMvcConfigurer.super.addCorsMappings(registry);
    //}
    
    /**
     * 解决跨域请求 方式二：可指定拦截器执行顺序
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
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

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", corsConfig);

        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(configSource));
        corsBean.setName("crossOriginFilter");
        //这个顺序也有可能会有影响，尽量设置在拦截器前面
        corsBean.setOrder(0);
        return corsBean;
    }
    
    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(resubmitFilter);
        //过滤所有路径
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("resubmitFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }*/
    @Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {
        AuthFilter authFilter = new AuthFilter();
        FilterRegistrationBean<AuthFilter> authFilterBean = new FilterRegistrationBean<>(authFilter);
        //过滤所有路径
        authFilterBean.addUrlPatterns("/*");
        authFilterBean.setName("authFilter");
        authFilterBean.setOrder(3);
        return authFilterBean;
    }
}