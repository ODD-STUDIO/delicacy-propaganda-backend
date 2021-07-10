package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.picture.PictureService;
import com.odd.delicacy.util.FileUtil;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 管理后台图片模块相关 controller
 *
 * @author Tanglinfeng
 * @date 2021/7/10 11:06
 */
@RequestMapping("/back/admin/carousel")
@AllArgsConstructor
@Controller
public class PictureBackController {

    private final PictureService pictureService;

    @ResponseBody
    @PostMapping("/add")
    public ResponseBean<String> add() {

        return null;
    }

    /**
     * 分页查询轮播图列表
     *
     * @param pageSize 默认一条 10 页
     * @param pageNum
     * @param picture
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public ResponseBean<PageVO<Picture>> list(@RequestParam(value = "limit") int pageSize,
                                              @RequestParam(value = "page") int pageNum,
                                              Picture picture) {
        PageInfo<Picture> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        return new ResponseBean<>(200, "", pictureService.findPage(pageInfo, picture));
    }


    /**
     * 上传图片接口
     *
     * @param file
     * @return 文件名
     */
    @ResponseBody
    @PostMapping("/upload")
    public ResponseBean<String> upload(MultipartFile file) {
        return ResponseBean.success(pictureService.uploadFile(file));
    }
}
