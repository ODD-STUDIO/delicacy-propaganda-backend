package com.odd.delicacy.mapper.good;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.good.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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