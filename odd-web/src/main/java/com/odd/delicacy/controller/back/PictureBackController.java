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
import org.springframework.ui.Model;
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

    /**
     * 增加轮播图
     *
     * @param picture
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public ResponseBean<Boolean> add(Picture picture) {
        return ResponseBean.success(pictureService.insert(picture));
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
        return ResponseBean.success(pictureService.findPage(pageInfo, picture));
    }


    /**
     * 跳转到更新页
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update")
    public String toUpdatePage(Long id, Model model) {
        model.addAttribute("picture", pictureService.findById(id));
        return "back/carousel/carousel-edit";
    }

    /**
     * 更新图片
     *
     * @param picture
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseBean<Boolean> update(Picture picture) {
        return ResponseBean.success(pictureService.update(picture));
    }

    /**
     * 删除图片
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseBean<Boolean> delete(@PathVariable("id") Long id) {
        return ResponseBean.success(pictureService.deleteById(id));
    }

    @PostMapping("/delete/all")
    @ResponseBody
    public ResponseBean<Boolean> deleteAll(@RequestParam(name = "ids[]") String[] ids) {
        return ResponseBean.success(pictureService.deleteAll(ids));
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
