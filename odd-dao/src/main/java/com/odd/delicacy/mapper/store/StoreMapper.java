package com.odd.delicacy.mapper.store;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.store.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author potato
 * @date 2021/7/10 11:03
 */
@Mapper
@Repository
public interface StoreMapper extends BaseMapper<Store> {

    @Override
    int insert(Store store);


    @Override
    List<Store> findList(Store store);

    @Override
    int update(Store store);


    @Override
    int deleteById(@Param("id") Long id);

}
