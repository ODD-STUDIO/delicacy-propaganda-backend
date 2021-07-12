package com.odd.delicacy.mapper.good;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.good.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tanglinfeng
 * @date 2021/7/5 18:13
 */
@Mapper
@Repository
public interface GoodMapper extends BaseMapper<Good> {

    @Override
    int insert(Good good);

    @Override
    List<Good> findList(Good good);

    @Override
    int update(Good good);

    @Override
    int deleteById(@Param("id") Long id);

    int deleteAll(@Param("ids") String[] ids);
}
