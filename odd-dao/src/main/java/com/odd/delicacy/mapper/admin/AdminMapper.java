package com.odd.delicacy.mapper.admin;


import com.odd.delicacy.base.BaseMapper;
import com.odd.delicacy.entity.admin.Administer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Administer> {


    Administer findByUsername(String username);
}
