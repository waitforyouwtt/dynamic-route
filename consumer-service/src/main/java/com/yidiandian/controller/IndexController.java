package com.yidiandian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "hi " + name;
    }

    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }
}
