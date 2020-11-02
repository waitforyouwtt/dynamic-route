package com.yidiandian.service;

import com.yidiandian.entity.DynamicVersion;

import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-02
 */
public interface IDynamicVersionService {

    int add(DynamicVersion version);

    int update(DynamicVersion version);

    int delete(Long id);

    /**
     * 获取最后一次发布的版本号
     * @return
     */
    Long getLastVersion();

    /**
     * 获取所有的版本发布信息
     * @return
     */
    List<DynamicVersion> listAll();
}
