package com.odd.delicacy.controller.back;

import com.github.pagehelper.PageInfo;
import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.good.Good;
import com.odd.delicacy.entity.news.News;
import com.odd.delicacy.entity.picture.Picture;
import com.odd.delicacy.service.news.NewsService;
import com.odd.delicacy.util.PageUtil;
import com.odd.delicacy.valid.Create;
import com.odd.delicacy.valid.Update;
import com.odd.delicacy.vo.PageVO;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/back/news")
@AllArgsConstructor
public class NewsBackController {

    private final NewsService newsService;

    /**
     * 查询所有新闻
     * @param pageNum
     * @param news
     * @return
     */
//    @GetMapping("/list/{pageNum}")
//    public ResponseBean<PageVO<News>> listNews(@PathVariable("pageNum") int pageNum, News news) {
//        // 构建分页查询对象
//        // ...
//        // TODO 这里写死为一页 6 条，后期可以更改为前端传值
//        PageInfo<News> pageInfo = PageUtil.pageInfo(pageNum, 6);
//        return ResponseBean.success(newsService.findPage(pageInfo, news));
//    }
    @ResponseBody
    @GetMapping("/list")
    public ResponseBean<PageVO<News>> list(@RequestParam(value = "limit") int pageSize,
                                              @RequestParam(value = "page") int pageNum,
                                              News news) {
        PageInfo<News> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
        return ResponseBean.success(newsService.findPage(pageInfo, news));
    }

    /**
     * 新增新闻
     * @param news
     * @return
     */
    @PostMapping("/add")
    public ResponseBean<Boolean> createNews( News news) {
        return ResponseBean.success(newsService.insert(news));
    }

    /**
     * 根据新闻id删除，逻辑删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseBean<Boolean> deleteNews(@PathVariable("id") long id){
        return ResponseBean.success(newsService.deleteById(id));
    }

    /**
     * 更新一条新闻信息
     * @param news
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseBean<Boolean> updateNews(News news){
        return ResponseBean.success(newsService.update(news));
    }

}
