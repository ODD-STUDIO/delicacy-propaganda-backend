package com.odd.delicacy.mapper.news;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.news.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper extends BaseMapper<News> {
    @Override
    News findById(Long id);

    @Override
    News findOne(News entity);

    @Override
    List<News> findList(News entity);

    @Override
    int insert(News entity);

    @Override
    int update(News entity);

    @Override
    int deleteById(Long id);
}
