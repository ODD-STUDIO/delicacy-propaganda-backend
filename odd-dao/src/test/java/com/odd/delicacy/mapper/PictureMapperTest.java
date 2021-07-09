package com.odd.delicacy.mapper;

import com.odd.delicacy.entity.picture.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PictureMapperTest {

    @Resource
    PictureMapper mapper;

    @Test
    public void insert() {
        assertNotNull(mapper);
        Picture pic = new Picture("1", 2L, 0, 1, "NEWS");
        mapper.insert(pic);
    }

    @Test
    public void select(){
        Picture pic = mapper.findById(1L);
        System.out.println(pic);
    }
}