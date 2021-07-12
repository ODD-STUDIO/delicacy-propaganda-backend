package com.odd.delicacy.controller.front;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.good.GoodCategory;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.good.GoodCategoryService;
import com.odd.delicacy.service.good.GoodService;
import com.odd.delicacy.service.picture.PictureService;
import com.odd.delicacy.util.PageUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品模块前台相关 controller
 *
 * @author Tanglinfeng
 * @date 2021/7/12 17:13
 */
@Controller
@AllArgsConstructor
public class GoodFrontController {

    private final GoodService goodService;

    private final GoodCategoryService goodCategoryService;

    private final PictureService pictureService;

    /**
     * 根据商品分类查询商品
     *
     * @param id
     * @param pageNum
     * @return
     */
    @GetMapping("/product/{pageNum}")
    public String findGoodListByCategory(@RequestParam(required = false , value = "id") String id,
                                         @PathVariable("pageNum") int pageNum,
                                         Model model) {
        PageInfo<Good> pageInfo = PageUtil.pageInfo(pageNum, 6);
        // 构建查询参数
        if (id == null) {
            model.addAttribute("goods", goodService.findPage(pageInfo, null));
        } else {
            Good good = new Good();
            GoodCategory goodCategory = new GoodCategory();
            goodCategory.setId(Long.valueOf(id));
            good.setGoodCategory(goodCategory);
            model.addAttribute("goods", goodService.findPage(pageInfo, good));
            model.addAttribute("categoryId", id);
        }
        model.addAttribute("goodCategory", goodCategoryService.findAllToFront());
        return "front/product";
    }

    /**
     * 根据商品 id 查询对应的轮播图
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/product/carousel")
    public ResponseBean<List<String>> getCarousel(Long id) {

        return ResponseBean.
                success(pictureService.findCarouselByIdAndType(id, "GOODS").stream().map(Picture::getUrl).collect(Collectors.toList()));
    }
}
