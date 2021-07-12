package com.odd.delicacy.mapper.good;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.good.GoodCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tanglinfeng
 * @date 2021/7/11 19:35
 */
@Mapper
@Repository
public interface GoodCategoryMapper extends BaseMapper<GoodCategory> {

    @Override
    GoodCategory findById(Long id);

    @Override
    List<GoodCategory> findList(GoodCategory entity);

    @Override
    int insert(GoodCategory entity);

    @Override
    int update(GoodCategory entity);

    int deleteAll(@Param("ids") String[] ids);

    /**
     * 查询状态没被屏蔽的分类名
     *
     * @return
     */
    List<GoodCategory> findAllToFront();

    @Override
    int deleteById(Long id);
}
