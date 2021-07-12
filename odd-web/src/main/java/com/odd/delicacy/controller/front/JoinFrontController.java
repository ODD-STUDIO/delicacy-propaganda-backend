package com.odd.delicacy.controller.front;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.join.JoinInfo;
import com.odd.delicacy.service.join.JoinService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台申请相关接口
 *
 * @author zy
 * @date 2021/7/5 18:18
 */

@Controller
@RequestMapping("/front/admin/join")
public class JoinFrontController {

    @Autowired
    private JoinService joinService;

    /**
     * 分页查询轮播图列表
     *
     * @param pageSize 默认一条 10 页
     * @param pageNum
     * @param name
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public ResponseBean<PageVO<JoinInfo>> list(@RequestParam(value = "limit") int pageSize, @RequestParam(value = "page") int pageNum, @RequestParam(value = "jName") String name) {
        PageInfo<JoinInfo> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        JoinInfo joinInfo = new JoinInfo();
        joinInfo.setFranchiseesName(name);
        System.out.println(joinInfo);
        return ResponseBean.success(joinService.findPage(pageInfo, joinInfo));
    }
    /**
     * 新增加盟者
     *
     * @param joinInfo
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public ResponseBean<Boolean> createJoinInfo(JoinInfo joinInfo) {
        return ResponseBean.success(joinService.insert(joinInfo));
    }
    /**
     * 删除加盟者
     *
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteJoinInfo(@PathVariable("id") long id) {
        return ResponseBean.success(joinService.deleteById(id));
    }
    /**
     * 更新加盟者
     *
     * @param joinInfo
     * @return
     */
    @ResponseBody
    @PostMapping("/update")
    public ResponseBean<Boolean> updateJoinInfo(JoinInfo joinInfo) {
        return ResponseBean.success(joinService.update(joinInfo));
    }
    /**
     * 更新页面
     *
     * @param id
     * @return
     */
    @GetMapping("/update/page")
    public String updateJoinInfo(Integer id, Model model) {
        JoinInfo joinInfo = joinService.findById(id.longValue());
        model.addAttribute("joinInfo", joinInfo);
        return "back/join/join-edit";
    }
    @ResponseBody
    @PostMapping("/delete/all")
    public ResponseBean<Boolean> deleteAll(@RequestParam(name = "ids[]") String[] ids) {
        return ResponseBean.success(joinService.deleteAll(ids));
    }
}
