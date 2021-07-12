package com.odd.delicacy.service.join;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.join.JoinInfo;
import com.odd.delicacy.mapper.join.JoinMapper;
import org.springframework.stereotype.Service;

/**
 * @author zy
 * @date 2021/7/5 18:17
 */
@Service
public class JoinService extends BaseService<JoinMapper, JoinInfo> {

    public JoinInfo findById(Long id){
        if(id <= 0){
            return null;
        }

        return mapper.findById(id);
    }

    public boolean deleteAll(String[] ids){
        return mapper.deleteAll(ids) > 0;
    }
}