package com.odd.delicacy.mapper.picture;

import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.picture.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tanglinfeng
 * @date 2021/7/10 11:03
 */
@Mapper
@Repository
public interface PictureMapper extends BaseMapper<Picture> {

    @Override
    List<Picture> findList(Picture entity);

    @Override
    int insert(Picture picture);
}
