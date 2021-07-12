package com.odd.delicacy.controller.front;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.good.GoodCategory;
import com.odd.delicacy.service.good.GoodCategoryService;
import com.odd.delicacy.service.good.GoodService;
import com.odd.delicacy.service.picture.PictureService;
import com.odd.delicacy.util.PageUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class RouterFrontController {

    private final GoodService goodService;

    private final GoodCategoryService goodCategoryService;

    private final PictureService pictureService;

    @GetMapping({"", "index"})
    public String index() {
        return "front/index";
    }

    @GetMapping("about")
    public String about() {
        return "front/about";
    }

    /**
     * 产品简介页面
     *
     * @param model
     * @return
     */
    @GetMapping("product")
    public String product(Model model) {
        model.addAttribute("goodCategory", goodCategoryService.findAllToFront());
        PageInfo<Good> pageInfo = PageUtil.pageInfo(1, 6);
        model.addAttribute("goods", goodService.findPage(pageInfo, null));

        return "front/product";
    }

    @GetMapping("join")
    public String join() {
        return "front/join/join";
    }

    @GetMapping("store")
    public String store() {
        return "front/store";
    }

    @GetMapping("news")
    public String news() {
        return "front/news";
    }

    @GetMapping("contact")
    public String contact() {
        return "front/contact";
    }

    @GetMapping("join/advantage")
    public String toJoinAdvantage(){return "front/join/joinAdvantage";}

    @GetMapping("join/flow")
    public String toJoinFlow(){return "front/join/joinFlow";}

    @GetMapping("join/apply")
    public String toJoinApply(){return "front/join/joinApply";}
}
