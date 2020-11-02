package com.yidiandian.service.impl;


import com.yidiandian.config.RedisUtils;
import com.yidiandian.constants.Constant;
import com.yidiandian.dao.DynamicVersionDao;
import com.yidiandian.entity.DynamicVersion;
import com.yidiandian.service.IDynamicVersionService;
import com.yidiandian.service.IRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
@Service
public class DynamicVersionServiceImpl implements IDynamicVersionService {


    @Resource
    DynamicVersionDao dynamicVersionDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IRoutesService routesService;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public int add(DynamicVersion version) {
        version.setCreateTime(new Date());
        int result = dynamicVersionDao.insert(version);

        //发布时，把版本信息与路由信息存入redis
       // redisTemplate.opsForValue().set(Constant.versionKey, String.valueOf(version.getId()));
       // redisTemplate.opsForValue().set(Constant.routeKey, JSON.toJSONString(routesService.getRouteDefinitions()));

        redisUtils.set(Constant.versionKey,version.getId());
        redisUtils.set(Constant.routeKey, routesService.getRouteDefinitions());

        return result;
    }

    @Override
    public int update(DynamicVersion version) {
        return dynamicVersionDao.update(version);
    }

    @Override
    public int delete(Long id) {
        return dynamicVersionDao.deleteById(id);
    }

    /**
     * 获取最后一次发布的版本号
     *
     * @return
     */
    @Override
    public Long getLastVersion() {
        return dynamicVersionDao.getLastVersion();
    }

    @Override
    public List<DynamicVersion> listAll() {
        return dynamicVersionDao.listAll();
    }

}
