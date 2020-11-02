package com.yidiandian.dynamic;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@Data
public class GatewayFilterDefinition {

    /**
     * Filter Name
     */
    private String name;
    /**
     * 对应的路由规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

}
