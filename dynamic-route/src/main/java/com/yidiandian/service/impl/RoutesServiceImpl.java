package com.yidiandian.service.impl;

import com.yidiandian.dao.GatewayRoutesDao;
import com.yidiandian.entity.GatewayRoutes;
import com.yidiandian.route.GatewayRouteDefinition;
import com.yidiandian.service.IRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@Service
public class RoutesServiceImpl implements IRoutesService {

    @Resource
    private GatewayRoutesDao routesDao;

    @Override
    public int add(GatewayRoutes route) {
        route.setIsEbl(1);
        route.setIsDel(1);
        route.setCreateTime(new Date());
        route.setUpdateTime(new Date());
        return routesDao.insert(route);
    }

    @Override
    public int update(GatewayRoutes route) {
        route.setUpdateTime(new Date());
        return routesDao.update(route);
    }

    @Override
    public int delete(Long id, int isDel) {
        GatewayRoutes route = new  GatewayRoutes();
        route.setId(id);
        route.setIsDel(1);
        return routesDao.update(route);
    }

    @Override
    public int enableById(Long id, int isEbl) {
        GatewayRoutes route = new  GatewayRoutes();
        route.setId(id);
        route.setIsEbl(isEbl);
        return routesDao.update(route);

    }

    @Override
    public GatewayRoutes getById(Long id) {
        return routesDao.queryById(id);
    }

    /**
     * 查询路由信息
     * @return
     */
    @Override
    public List<GatewayRoutes> getRoutes(GatewayRoutes route) {
        return routesDao.getRoutes(route);
    }

    /**
     * 返回组装后网关需要的路由信息
     * @return
     */
    @Override
    public List<GatewayRouteDefinition> getRouteDefinitions() {
        List<GatewayRouteDefinition> routeDefinitions = new ArrayList<>();
        GatewayRoutes route = new GatewayRoutes();
        route.setIsDel(0);
        route.setIsEbl(0);
        List<GatewayRoutes> routes = getRoutes(route);
        for(GatewayRoutes gatewayRoute : routes){
            GatewayRouteDefinition routeDefinition = new GatewayRouteDefinition();
            routeDefinition.setId(gatewayRoute.getRouteId());
            routeDefinition.setUri(gatewayRoute.getRouteUri());
            routeDefinition.setFilters(gatewayRoute.getFilterDefinition());
            routeDefinition.setPredicates(gatewayRoute.getPredicateDefinition());
            routeDefinitions.add(routeDefinition);
        }
        return routeDefinitions;
    }
}
