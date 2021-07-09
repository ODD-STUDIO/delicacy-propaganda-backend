package com.odd.delicacy.mapper;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.picture.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Mapper for [Picture].
 */
@Repository
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

    @Override
    //language=SQL
    @Insert("insert into delicacy.picture(create_time, update_time, is_delete, url, associate_id, status, order_num, type) VALUES (now(),now(),false,${url},${associateId},${status},${orderNum},${type})")
    int insert(Picture entity);

    @Override
    //language=SQL
    @Select("select * from delicacy.picture where id = ${id}")
    Picture findById(Long id);
}
