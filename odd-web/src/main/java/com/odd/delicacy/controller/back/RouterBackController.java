package com.odd.delicacy.controller.back;

import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.good.GoodCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@AllArgsConstructor
@RequestMapping("/back/admin")
@Controller
public class RouterBackController {

    private final GoodCategoryService goodCategoryService;

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

    /**
     * 跳转到 商品列表页
     *
     * @param model
     * @return
     */
    @GetMapping("/goods")
    public String toGoods(Model model) {
        model.addAttribute("goodCategory", goodCategoryService.findList(null));
        return "back/goods/goods-list";
    }

    /**
     * 跳转到 商品添加页
     *
     * @param model
     * @return
     */
    @GetMapping("/goods/add")
    public String toGoodsAdd(Model model) {
        model.addAttribute("goodCategory", goodCategoryService.findList(null));
        return "back/goods/goods-add";
    }

    @GetMapping("/goods/category")
    public String toGoodsCategory() {
        return "back/goods/goods-category-list";
    }

    @GetMapping("/goods/category/add")
    public String toGoodsCategoryAdd() {
        return "back/goods/goods-category-add";
    }

    @GetMapping("/stores")
    public String toStores(){ return "back/stores/stores-list"; }

    @GetMapping("/stores/add")
    public String toStoresAdd() {
        return "back/stores/stores-add";
    }

}
