package com.odd.delicacy.mapper.join;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.join.JoinInfo;
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
public interface JoinMapper extends BaseMapper<JoinInfo> {

    @Override
    int insert(JoinInfo joinInfo);

    @Override
    List<JoinInfo> findList(JoinInfo joinInfo);

    @Override
    int update(JoinInfo joinInfo);

    @Override
    int deleteById(@Param("id") Long id);
}
