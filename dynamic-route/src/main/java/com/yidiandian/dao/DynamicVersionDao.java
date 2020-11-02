package com.yidiandian.dao;

import com.yidiandian.entity.DynamicVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DynamicVersion)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-02 16:36:11
 */
@Mapper
public interface DynamicVersionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DynamicVersion queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DynamicVersion> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dynamicVersion 实例对象
     * @return 对象列表
     */
    List<DynamicVersion> queryAll(DynamicVersion dynamicVersion);

    /**
     * 新增数据
     *
     * @param dynamicVersion 实例对象
     * @return 影响行数
     */
    int insert(DynamicVersion dynamicVersion);

    /**
     * 修改数据
     *
     * @param dynamicVersion 实例对象
     * @return 影响行数
     */
    int update(DynamicVersion dynamicVersion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Long getLastVersion();

    List<DynamicVersion> listAll();
}