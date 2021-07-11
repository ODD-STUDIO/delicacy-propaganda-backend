package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.join.JoinInfo;
import com.odd.delicacy.service.join.JoinService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.valid.Create;
import com.odd.delicacy.valid.Update;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台申请相关接口
 *
 * @author zy
 * @date 2021/7/5 18:18
 */
@RestController
@RequestMapping("/back/join")
@AllArgsConstructor
public class JoinBackController {

    private final JoinService joinService;

    /**
     * 查询加盟者列表
     *
     * @param pageNum 当前页数
     * @param joinInfo 动态查询对象
     * @return
     */
    @GetMapping("/list/{pageNum}")
    public ResponseBean<PageVO<JoinInfo>> listGoods(@PathVariable("pageNum") int pageNum, JoinInfo joinInfo) {
        // 构建分页查询对象
        // ...
        // TODO 这里写死为一页 6 条，后期可以更改为前端传值
        PageInfo<JoinInfo> pageInfo = PageUtil.pageInfo(pageNum, 6);
        return ResponseBean.success(joinService.findPage(pageInfo, joinInfo));
    }

    /**
     * 新增加盟者
     *
     * @param joinInfo
     * @return
     */
    @PostMapping("/add")
    public ResponseBean<Boolean> createGood(@Validated(Create.class) @RequestBody JoinInfo joinInfo) {
        return ResponseBean.success(joinService.insert(joinInfo));
    }

    /**
     * 删除加盟者
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteGood(@PathVariable("id") long id) {
        return ResponseBean.success(joinService.deleteById(id));
    }

    /**
     * 更新加盟者
     *
     * @param joinInfo
     * @return
     */
    @PutMapping("/update")
    public ResponseBean<Boolean> updateGood(@Validated(Update.class) @RequestBody JoinInfo joinInfo) {
        return ResponseBean.success(joinService.update(joinInfo));
    }
}
