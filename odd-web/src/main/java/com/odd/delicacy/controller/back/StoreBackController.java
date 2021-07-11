package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.store.Store;
import com.odd.delicacy.service.store.StoreService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.valid.Create;
import com.odd.delicacy.valid.Update;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台商品相关接口
 *
 * @author Potato
 * @date 2021/7/5 18:18
 */
@RestController
@RequestMapping("/back/stores")
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
    @GetMapping("/list/{pageNum}")
    public PageVO<Store> listStores(@PathVariable("pageNum") int pageNum, Store store) {
        // 构建分页查询对象
        // ...
        // TODO 这里写死为一页 6 条，后期可以更改为前端传值
        PageInfo<Store> pageInfo = PageUtil.pageInfo(pageNum, 6);
        return StoreService.findPage(pageInfo, store);
    }

    /**
     * 新增商品
     *
     * @param store
     * @return
     */
    @PostMapping("/add")
    public ResponseBean<Boolean> createStore(@Validated(Create.class) @RequestBody Store store) {
        return ResponseBean.success(StoreService.insert(store));
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteStore(@PathVariable("id") long id) {
        return ResponseBean.success(StoreService.deleteById(id));
    }

    /**
     * 更新商品
     *
     * @param store
     * @return
     */
    @PutMapping("/update")
    public ResponseBean<Boolean> updateStore(@Validated(Update.class) @RequestBody Store store) {
        return ResponseBean.success(StoreService.update(store));
    }
}
