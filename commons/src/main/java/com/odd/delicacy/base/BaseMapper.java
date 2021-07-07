package com.odd.delicacy.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基类 Mapper
 *
 * @author Tanglinfeng
 * @date 2021/7/6 10:27
 */
public interface BaseMapper<T> {

    /**
     * 根据 Id 查询
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 查询单条记录
     *
     * @param entity
     * @return
     */
    T findOne(T entity);

    /**
     * 查询多条记录
     *
     * @param entity
     * @return
     */
    List<T> findList(T entity);

    /**
     * 插入单条数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新单条数据
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 根据 Id 删除单条数据
     *
     * @param id
     * @return
     */
    int deleteById(@Param("id") Long id);
}
