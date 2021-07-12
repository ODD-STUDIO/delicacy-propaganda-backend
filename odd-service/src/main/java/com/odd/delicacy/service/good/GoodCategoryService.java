package com.odd.delicacy.service.good;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.good.GoodCategory;
import com.odd.delicacy.mapper.good.GoodCategoryMapper;
import com.odd.delicacy.mapper.good.GoodMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tanglinfeng
 * @date 2021/7/11 19:44
 */
@Service
public class GoodCategoryService extends BaseService<GoodCategoryMapper, GoodCategory> {

    public boolean deleteAll(String[] ids) {
        return this.mapper.deleteAll(ids) > 0;
    }

    public List<GoodCategory> findAllToFront() {
        return this.mapper.findAllToFront();
    }
}
