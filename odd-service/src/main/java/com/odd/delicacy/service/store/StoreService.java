package com.odd.delicacy.service.store;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.entity.store.Store;
import com.odd.delicacy.mapper.picture.PictureMapper;
import com.odd.delicacy.mapper.store.StoreMapper;
import com.odd.delicacy.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author potato
 * @date 2021/7/10 11:04
 */
@Service
public class StoreService extends BaseService<StoreMapper, Store> {

}
