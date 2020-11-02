package com.yidiandian.dao;

import com.yidiandian.entity.GatewayRoutes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (GatewayRoutes)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 16:36:31
 */
@Mapper
public interface GatewayRoutesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GatewayRoutes queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GatewayRoutes> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param gatewayRoutes 实例对象
     * @return 对象列表
     */
    List<GatewayRoutes> queryAll(GatewayRoutes gatewayRoutes);

    /**
     * 新增数据
     *
     * @param gatewayRoutes 实例对象
     * @return 影响行数
     */
    int insert(GatewayRoutes gatewayRoutes);

    /**
     * 修改数据
     *
     * @param gatewayRoutes 实例对象
     * @return 影响行数
     */
    int update(GatewayRoutes gatewayRoutes);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<GatewayRoutes> getRoutes(GatewayRoutes route);
}