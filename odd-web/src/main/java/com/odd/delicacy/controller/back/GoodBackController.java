package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.good.GoodCategory;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.good.GoodCategoryService;
import com.odd.delicacy.service.good.GoodService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.valid.Create;
import com.odd.delicacy.valid.Update;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 管理后台商品相关接口
 *
 * @author Tanglinfeng
 * @date 2021/7/5 18:18
 */
@Controller
@RequestMapping("/back/admin/goods")
@AllArgsConstructor
public class GoodBackController {

    private final GoodService goodService;

    private final GoodCategoryService goodCategoryService;

    /**
     * 查询商品列表
     *
     * @param pageNum 当前页数
     * @param good 动态查询对象
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public ResponseBean<PageVO<Good>> listGoods(@RequestParam(value = "limit") int pageSize,
                                                @RequestParam(value = "page") int pageNum,
                                                Good good) {
        PageInfo<Good> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        return ResponseBean.success(goodService.findPage(pageInfo, good));
    }

    /**
     * 查询商品分类
     *
     * @param pageNum 当前页数
     * @param goodCategory 动态查询对象
     * @return
     */
    @ResponseBody
    @GetMapping("/category/list")
    public ResponseBean<PageVO<GoodCategory>> listGoodCategory(@RequestParam(value = "limit") int pageSize,
                                                               @RequestParam(value = "page") int pageNum,
                                                               GoodCategory goodCategory) {
        PageInfo<GoodCategory> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        return ResponseBean.success(goodCategoryService.findPage(pageInfo, goodCategory));
    }

    /**
     * 新增商品
     *
     * @param good
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public ResponseBean<Boolean> createGood(@Validated(Create.class) Good good) {
        return ResponseBean.success(goodService.insert(good));
    }

    /**
     * 新增商品分类
     *
     * @param goodCategory
     * @return
     */
    @ResponseBody
    @PostMapping("/category/add")
    public ResponseBean<Boolean> createGoodCategory(@Validated(Create.class) GoodCategory goodCategory) {
        return ResponseBean.success(goodCategoryService.insert(goodCategory));
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteGood(@PathVariable("id") long id) {
        return ResponseBean.success(goodService.deleteById(id));
    }

    @PostMapping("/delete/all")
    @ResponseBody
    public ResponseBean<Boolean> deleteAll(@RequestParam(name = "ids[]") String[] ids) {
        return ResponseBean.success(goodService.deleteAll(ids));
    }

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/category/delete/{id}")
    public ResponseBean<Boolean> deleteGoodCategory(@PathVariable("id") long id) {
        return ResponseBean.success(goodCategoryService.deleteById(id));
    }

    @PostMapping("/category/delete/all")
    @ResponseBody
    public ResponseBean<Boolean> deleteCategoryAll(@RequestParam(name = "ids[]") String[] ids) {
        return ResponseBean.success(goodCategoryService.deleteAll(ids));
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
        model.addAttribute("goods", goodService.findById(id));
        model.addAttribute("goodCategory", goodCategoryService.findList(null));
        return "back/goods/goods-edit";
    }

    /**
     * 跳转到更新页
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/category/update")
    public String toCategoryUpdatePage(Long id, Model model) {
        model.addAttribute("goodCategory", goodCategoryService.findById(id));
        return "back/goods/goods-category-edit";
    }

    /**
     * 更新商品
     *
     * @param good
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
    public ResponseBean<Boolean> updateGood(@Validated(Update.class) Good good) {
        return ResponseBean.success(goodService.update(good));
    }

    /**
     * 更新商品分类
     *
     * @param goodCategory
     * @return
     */
    @ResponseBody
    @PostMapping("/category/update")
    public ResponseBean<Boolean> updateCategory(@Validated(Update.class) GoodCategory goodCategory) {
        return ResponseBean.success(goodCategoryService.update(goodCategory));
    }
}
