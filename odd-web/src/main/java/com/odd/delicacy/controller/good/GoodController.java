package com.odd.delicacy.controller.good;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.service.good.GoodService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.valid.Create;
import com.odd.delicacy.valid.Update;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品相关接口
 *
 * @author Tanglinfeng
 * @date 2021/7/5 18:18
 */
@RestController
@RequestMapping("/good")
@AllArgsConstructor
public class GoodController {

    private final GoodService goodService;

    /**
     * 查询商品列表
     *
     * @param pageNum 当前页数
     * @param good 动态查询对象
     * @return
     */
    @GetMapping("/list/{pageNum}")
    public ResponseBean<PageVO<Good>> listGoods(@PathVariable("pageNum") int pageNum, Good good) {
        // 构建分页查询对象
        // ...
        // TODO 这里写死为一页 6 条，后期可以更改为前端传值
        PageInfo<Good> pageInfo = PageUtil.pageInfo(pageNum, 6);
        return ResponseBean.success(goodService.findPage(pageInfo, good));
    }

    /**
     * 新增商品
     *
     * @param good
     * @return
     */
    @PostMapping("/add")
    public ResponseBean<Boolean> createGood(@Validated(Create.class) @RequestBody Good good) {
        return ResponseBean.success(goodService.insert(good));
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteGood(@PathVariable("id") long id) {
        return ResponseBean.success(goodService.deleteById(id));
    }

    /**
     * 更新商品
     *
     * @param good
     * @return
     */
    @PutMapping("/update")
    public ResponseBean<Boolean> updateGood(@Validated(Update.class) @RequestBody Good good) {
        return ResponseBean.success(goodService.update(good));
    }
}
