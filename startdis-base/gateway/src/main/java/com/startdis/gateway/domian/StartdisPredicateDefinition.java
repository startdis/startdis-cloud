package com.startdis.gateway.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 路由断言模型类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class StartdisPredicateDefinition implements Serializable {
    
    private static final long serialVersionUID = 271482248774042129L;
    
    private String name;
    
    private Map<String, String> args = new HashMap<>();
}
