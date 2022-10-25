package com.startdis.common.feign.aspect;

import com.startdis.common.core.constant.HeaderConstants;
import com.startdis.common.util.http.ServletUtils;
import com.startdis.common.util.ip.IpUtils;
import com.startdis.common.util.string.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc Feign 请求拦截器
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = ServletUtils.getRequest();
        if (StringUtils.isNotNull(httpServletRequest)) {
            Map<String, String> headers = ServletUtils.getHeaders(httpServletRequest);
            // 传递用户信息请求头，防止丢失
            String userId = headers.get(HeaderConstants.DETAILS_USER_ID);
            if (StringUtils.isNotEmpty(userId)) {
                requestTemplate.header(HeaderConstants.DETAILS_USER_ID, userId);
            }
            String userName = headers.get(HeaderConstants.DETAILS_USERNAME);
            if (StringUtils.isNotEmpty(userName)) {
                requestTemplate.header(HeaderConstants.DETAILS_USERNAME, userName);
            }
            String authentication = headers.get(HeaderConstants.AUTHORIZATION_HEADER);
            if (StringUtils.isNotEmpty(authentication)) {
                requestTemplate.header(HeaderConstants.AUTHORIZATION_HEADER, authentication);
            }

            // 配置客户端IP
            requestTemplate.header("X-Forwarded-For", IpUtils.getIpAddr(ServletUtils.getRequest()));
        }
    }
}