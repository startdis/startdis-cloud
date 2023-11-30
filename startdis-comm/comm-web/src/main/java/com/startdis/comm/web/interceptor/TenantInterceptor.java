package com.startdis.comm.web.interceptor;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.startdis.comm.core.constant.FilterIgnoreConstant;
import com.startdis.comm.util.auth.TenantHolder;
import com.startdis.comm.util.url.UrlIgnoreUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc TenantInterceptor
 */
@Slf4j
@Component
public class TenantInterceptor implements HandlerInterceptor {


    /**
     * 不拦截的url
     */
    private Set<String> ignoreUrlSet = Sets.newConcurrentHashSet();



    @Value("${sql-intercept.tenant.anonUrlSet:''}")
    private String anonUrlSet;

    @PostConstruct
    public void init() {
        ignoreUrlSet.addAll(FilterIgnoreConstant.FILTER_COMMON_IGNORE_URL);
        List<String> exclusionUrlList =
            Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(anonUrlSet);
        ignoreUrlSet.addAll(exclusionUrlList);
        log.info("多租户拦截器忽略得请求路径有:{}",ignoreUrlSet);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        boolean isIgnoreRequest = UrlIgnoreUtil.isIgnoreUrl(ignoreUrlSet, servletPath);
        log.info("本次请求多租户拦截器是否拦截:{},请求路径:{}",!isIgnoreRequest,servletPath);
        TenantHolder.setIgnoredRequest(isIgnoreRequest);
        return true;
    }

}
