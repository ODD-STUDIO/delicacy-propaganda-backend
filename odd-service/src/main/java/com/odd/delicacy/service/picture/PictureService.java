package com.odd.delicacy.service.picture;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.mapper.picture.PictureMapper;
import com.odd.delicacy.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Tanglinfeng
 * @date 2021/7/10 11:04
 */
@Service
public class PictureService extends BaseService<PictureMapper, Picture> {

    /**
     * 文件上传
     *
     * @param file
     * @return 文件名
     */
    public String uploadFile(MultipartFile file) {
        return FileUtil.uploadFile(file);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public boolean deleteAll(String[] ids) {
        return this.mapper.deleteAll(ids) > 0;
    }

    public List<Picture> findCarouselByIdAndType(Long id, String type) {
        return this.mapper.findCarouselByIdAndType(id, type);
    }
}
