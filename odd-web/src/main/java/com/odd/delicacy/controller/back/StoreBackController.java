package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.store.Store;
import com.odd.delicacy.service.store.StoreService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台商品相关接口
 *
 * @author Potato
 * @date 2021/7/5 18:18
 */
@Controller
@RequestMapping("/back/admin/stores")
@AllArgsConstructor
public class StoreBackController {

    private final StoreService StoreService;

    /**
     * 查询商品列表
     *
     * @param pageNum 当前页数
     * @param store 动态查询对象
     * @return
     */

    @ResponseBody
    @GetMapping("/list")
    public ResponseBean<PageVO<Store>> list(@RequestParam(value = "limit") int pageSize,
                                            @RequestParam(value = "page") int pageNum,
                                            Store store) {
        PageInfo<Store> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        return ResponseBean.success(StoreService.findPage(pageInfo, store));
    }
    /**
     * 新增商品
     *
     * @param store
     * @return
     */

    @ResponseBody
    @PostMapping("/add")
    public ResponseBean<Boolean> add(Store store) {
        return ResponseBean.success(StoreService.insert(store));
    }


    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseBean<Boolean> deleteStore(@PathVariable("id") long id) {
        return ResponseBean.success(StoreService.deleteById(id));
    }
    @PostMapping("/delete/all")
    @ResponseBody
    public ResponseBean<Boolean> deleteAll(@RequestParam(name = "ids[]") String[] ids) {
        return ResponseBean.success(StoreService.deleteAll(ids));
    }


    @GetMapping("/update")
    public String toUpdatePage(Long id, Model model) {
        model.addAttribute("store", StoreService.findById(id));
        return "back/stores/stores-edit";
    }

    /**
     * 更新商品
     *
     * @param store
     * @return
     */

    @PostMapping("/update")
    @ResponseBody
    public ResponseBean<Boolean> updateStore(Store store) {
        return ResponseBean.success(StoreService.update(store));
    }

    /**
     * 跳转到更新页
     *
     * @param id
     * @param model
     * @return
     */



}
