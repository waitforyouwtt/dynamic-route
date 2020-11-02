package com.yidiandian.dynamic;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@Data
public class GatewayPredicateDefinition {

    /**
     * 断言对应的Name
     */
    private String name;
    /**
     * 配置的断言规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

}
