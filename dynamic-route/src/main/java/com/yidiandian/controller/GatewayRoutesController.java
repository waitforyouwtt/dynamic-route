package com.yidiandian.controller;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constants.Constant;
import com.yidiandian.entity.GatewayRoutes;
import com.yidiandian.service.IRoutesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@Controller
@RequestMapping("/gateway-routes")
public class GatewayRoutesController {

    @Autowired
    private IRoutesService routesService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取所有动态路由信息
     * @return
     */
    @RequestMapping("/routes")
    @ResponseBody
    public String getRouteDefinitions(){
        //先从redis中取，再从mysql中取
        String result = redisTemplate.opsForValue().get(Constant.routeKey);
        if(!StringUtils.isEmpty(result)){
            System.out.println("返回 redis 中的路由信息......");
        }else{
            System.out.println("返回 mysql 中的路由信息......");
            result = JSON.toJSONString(routesService.getRouteDefinitions());
            //再set到redis
            redisTemplate.opsForValue().set(Constant.routeKey , result);
        }
        System.out.println("路由信息：" + result);
        return result;
    }



    //打开添加路由页面
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map){
        map.addAttribute("route" , new GatewayRoutes());
        return "addRoute";
    }

    //添加路由信息
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody GatewayRoutes route){
        return routesService.add(route) > 0 ? "success" : "fail";
    }

    @RequestMapping(value = "/edit" , method = RequestMethod.GET)
    public String edit(ModelMap map , Long id){
        map.addAttribute("route" , routesService.getById(id));
        return "addRoute";
    }

    //添加路由信息
    @RequestMapping(value = "/edit" , method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody GatewayRoutes route){
        return routesService.update(route) > 0 ? "success" : "fail";
    }

    //打开路由列表
    @RequestMapping("/list")
    public String list(ModelMap map){
        GatewayRoutes route = new GatewayRoutes();
        route.setIsDel(0);
        route.setIsEbl(0);
        map.addAttribute("list" , routesService.getRoutes(route));
        return "routelist";
    }

    @RequestMapping("/delete")
    public String delete(Long id){
        routesService.delete(id , 1);
        return "delSuccess";
    }
}
