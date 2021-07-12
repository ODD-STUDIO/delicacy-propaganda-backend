package com.odd.delicacy.controller.front;

import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.picture.PictureService;
import com.odd.delicacy.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/index/"})
public class HomeController {

    @Autowired
    private PictureService pictureService;

    @PostMapping(value = "mainbanners")
    public ResponseBean<List<Picture>> homeMainBanners() {
        Picture picture = new Picture();
        picture.setType(Constants.PICTURE_TYPE_GOODS);
        picture.setStatus(Constants.PICTURE_STATUS_SHOW_IN_HOME);
        List<Picture> pictures = pictureService.findList(picture);
        return ResponseBean.success(pictures);
    }


    @PostMapping("storebanners")
    public ResponseBean<List<Picture>> homeStoreBanners() {
        Picture picture = new Picture();
        //TODO
        return ResponseBean.fail(500, "not implemented yet");
    }
}
