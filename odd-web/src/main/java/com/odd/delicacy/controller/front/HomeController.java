package com.odd.delicacy.controller.front;

import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.service.picture.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = {"/index/"})
public class HomeController {

    private PictureService pictureService;

    @PostMapping(value = "banners")
    public ResponseBean<List<String>> homeBannerUrl() {
        //TODO
        List<String> urls = Arrays.asList(
                "https://i.loli.net/2021/05/31/JsKMQLpIX4hOTBZ.png"
        );
        return ResponseBean.success(urls);
    }
}
