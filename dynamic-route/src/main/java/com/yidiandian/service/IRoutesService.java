package com.yidiandian.service;

import com.yidiandian.entity.GatewayRoutes;
import com.yidiandian.route.GatewayRouteDefinition;

import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
public interface IRoutesService {

    int add(GatewayRoutes route);

    int update(GatewayRoutes route);

    int delete(Long id, int isDel);

    int enableById(Long id, int isEbl);

    GatewayRoutes getById(Long id);

    /**
     * 查询路由信息
     *
     * @return
     */
    List<GatewayRoutes> getRoutes(GatewayRoutes route);

    /**
     * 返回组装后网关需要的路由信息
     *
     * @return
     */
    List<GatewayRouteDefinition> getRouteDefinitions();

}
