package com.yidiandian.entity;

import com.yidiandian.route.GatewayFilterDefinition;
import com.yidiandian.route.GatewayPredicateDefinition;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.io.Serializable;
import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * (GatewayRoutes)实体类
 *
 * @author makejava
 * @since 2020-11-02 16:36:31
 */
@Data
public class GatewayRoutes implements Serializable {
    private static final long serialVersionUID = -96842800285421746L;
    
    private Long id;
    /**
    * 路由id
    */
    private String routeId;
    /**
    * 转发目标uri
    */
    private String routeUri;
    /**
    * 路由执行顺序
    */
    private Integer routeOrder;
    /**
    * 断言字符串集合，字符串结构：[{
                "name":"Path",
                "args":{
                   "pattern" : "/zy/**"
                }
              }]
    */
    private String predicates;
    /**
    * 过滤器字符串集合，字符串结构：{
              	"name":"StripPrefix",
              	 "args":{
              	 	"_genkey_0":"1"
              	 }
              }
    */
    private String filters;
    /**
    * 是否启用
    */
    private int isEbl;
    /**
    * 是否删除
    */
    private int isDel;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

    /**
     * 获取断言集合
     * @return
     */
    public List<GatewayPredicateDefinition> getPredicateDefinition(){
        if(!StringUtils.isEmpty(this.predicates)){
            return JSON.parseArray(this.predicates , GatewayPredicateDefinition.class);
        }
        return null;
    }

    /**
     * 获取过滤器集合
     * @return
     */
    public List<GatewayFilterDefinition> getFilterDefinition(){
        if(!StringUtils.isEmpty(this.filters)){
            return JSON.parseArray(this.filters , GatewayFilterDefinition.class);
        }
        return null;
    }

}