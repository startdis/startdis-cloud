package com.startdis.gateway.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 路由模型类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class StartdisRouteDefinition implements Serializable {
    
    private static final long serialVersionUID = 271482248774042129L;
    
    private String id;
    
    private Integer order = 0;
    
    private List<StartdisFilterDefinition> filters = new ArrayList<>();
    
    private List<StartdisPredicateDefinition> predicates = new ArrayList<>();
    
    private String uri;
    
    public RouteDefinition getRouteDefinition() {
        RouteDefinition definition = new RouteDefinition();
        definition.setId(this.getId());
        definition.setOrder(this.getOrder());
        
        //设置断言
        List<PredicateDefinition> pdList = new ArrayList<>();
        List<StartdisPredicateDefinition> gatewayPredicates = this.getPredicates();
        for (StartdisPredicateDefinition gpDefinition : gatewayPredicates) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        
        definition.setPredicates(pdList);
        
        //设置过滤器
        List<FilterDefinition> filters = new ArrayList();
        List<StartdisFilterDefinition> gatewayFilters = this.getFilters();
        for (StartdisFilterDefinition filterDefinition : gatewayFilters) {
            FilterDefinition filter = new FilterDefinition();
            filter.setName(filterDefinition.getName());
            filter.setArgs(filterDefinition.getArgs());
            filters.add(filter);
        }
        definition.setFilters(filters);
        
        URI uri = null;
        if (this.getUri().startsWith("http")) {
            uri = UriComponentsBuilder.fromHttpUrl(this.getUri()).build().toUri();
        } else {
            uri = URI.create(this.getUri());
        }
        definition.setUri(uri);
        return definition;
    }
}
