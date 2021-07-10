package com.odd.delicacy.controller.back;

import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.picture.Picture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台路由控制器
 *
 * @author Tanglinfeng
 * @date 2021/7/9 14:52
 */
@RequestMapping("/back/admin")
@Controller
public class RouterBackController {

    @GetMapping("/index")
    public String toBackIndex() {
        return "back/index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "back/login";
    }

    @GetMapping("/carousel")
    public String toCarousel() {
        return "back/carousel/carousel-list";
    }

    @GetMapping("/carousel/add")
    public String toCarouselAdd() {
        return "back/carousel/carousel-add";
    }
}
