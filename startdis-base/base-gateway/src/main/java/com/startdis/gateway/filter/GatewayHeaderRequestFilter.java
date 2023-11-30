package com.startdis.gateway.filter;

import com.startdis.comm.core.constant.HeaderConstant;
import com.startdis.comm.core.enums.IdentityTypeEnum;
import com.startdis.comm.util.string.StringKits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(0)
@Slf4j
@Component
public class GatewayHeaderRequestFilter implements GlobalFilter {
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        
        //忽略以下url
        if (url.startsWith("/oauth") || url.startsWith("/login")) {
            return chain.filter(exchange);
        }
        
        //开始组装请求头穿透
        ServerHttpRequest req = null;
        // 传递服务类型请求头，防止丢失
        String serviceType = request.getHeaders().getFirst(HeaderConstant.X_SERVICE_TYPE);
        log.info("GatewayHeaderRequestFilter X_SERVICE_TYPE:{}", serviceType);
        // 传递集团租户请求头，防止丢失
        String groupTenantId = request.getHeaders().getFirst(HeaderConstant.X_GROUP_TENANT_ID);
        log.info("GatewayHeaderRequestFilter X_GROUP_TENANT_ID:{}", groupTenantId);
        // 传递公司租户请求头，防止丢失
        String companyTenantId = request.getHeaders().getFirst(HeaderConstant.X_COMPANY_TENANT_ID);
        log.info("GatewayHeaderRequestFilter X_COMPANY_TENANT_ID:{}", companyTenantId);
        // 传递用户信息请求头，防止丢失
        String uniqueId = request.getHeaders().getFirst(HeaderConstant.X_UNIQUE_ID);
        log.info("GatewayHeaderRequestFilter X_UNIQUE_ID:{}", uniqueId);
        // 传递用户设备请求头，防止丢失
        String distinctId = request.getHeaders().getFirst(HeaderConstant.X_DISTINCT_ID);
        log.info("GatewayHeaderRequestFilter X_DISTINCT_ID:{}", distinctId);
        // 传递鉴权信息请求头，防止丢失
        String authToken = request.getHeaders().getFirst(HeaderConstant.X_ACCESS_TOKEN);
        log.info("GatewayHeaderRequestFilter X_ACCESS_TOKEN:{}", authToken);
        // 判断用户类型是否为集团公司，是的话进一步判断是否为集团权限，是集团权限需要传递集团下属公司IDs
        String identityType = request.getHeaders().getFirst(HeaderConstant.X_IDENTITY_TYPE);
        log.info("GatewayHeaderRequestFilter X_IDENTITY_TYPE:{}", identityType);
        //TODO 暂时不校验token 单点登陆完成后校验
        //if (StringKits.isBlank(serviceType) || StringKits.isBlank(groupTenantId) || StringKits.isBlank(companyTenantId) || StringKits.isBlank(
        //        identityType) || StringKits.isBlank(uniqueId) || StringKits.isBlank(authToken)) {
        if (StringKits.isBlank(serviceType) || StringKits.isBlank(groupTenantId) || StringKits.isBlank(companyTenantId) || StringKits.isBlank(
                identityType) || StringKits.isBlank(uniqueId)) {
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add(HeaderConstant.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
            exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            return exchange.getResponse().setComplete();
        }
        
        //集团公司的用户
        if (identityType.equals(IdentityTypeEnum.COMPANY.getCode())) {
            //权限范围
            String permissionScope = request.getHeaders().getFirst(HeaderConstant.X_PERMISSION_SCOPE);
            log.info("GatewayHeaderRequestFilter X_PERMISSION_SCOPE:{}", permissionScope);
            //当权限范围为公司时，为这个用户所属公司的id
            String companyIds = request.getHeaders().getFirst(HeaderConstant.X_COMPANY_IDS);
            log.info("GatewayHeaderRequestFilter X_COMPANY_IDS:{}", companyIds);
            req = request.mutate().header(HeaderConstant.X_SERVICE_TYPE, serviceType).header(HeaderConstant.X_GROUP_TENANT_ID, groupTenantId)
                    .header(HeaderConstant.X_COMPANY_TENANT_ID, companyTenantId).header(HeaderConstant.X_UNIQUE_ID, uniqueId)
                    .header(HeaderConstant.X_DISTINCT_ID, distinctId).header(HeaderConstant.X_ACCESS_TOKEN, authToken)
                    .header(HeaderConstant.X_PERMISSION_SCOPE, permissionScope).header(HeaderConstant.X_COMPANY_IDS, companyIds).build();
        } else if (identityType.equals(IdentityTypeEnum.VISITOR.getCode())) {
            //访客体验的用户 do anything
        }
        
        /*ServerHttpRequest req =
                request.mutate().header(HeaderConstant.X_SERVICE_TYPE, serviceType).header(HeaderConstant.X_GROUP_TENANT_ID, groupTenantId)
                        .header(HeaderConstant.X_COMPANY_TENANT_ID, companyTenantId).header(HeaderConstant.X_UNIQUE_ID, uniqueId)
                        .header(HeaderConstant.X_DISTINCT_ID, distinctId).header(HeaderConstant.X_ACCESS_TOKEN, authToken)
                        .header(HeaderConstant.X_PERMISSION_SCOPE, permissionScope).header(HeaderConstant.X_COMPANY_IDS, companyIds).build();*/
        ServerWebExchange webExchange = exchange.mutate().request(req).build();
        return chain.filter(webExchange);
        
    }
}
