package com.odd.delicacy.service.news;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.news.News;
import com.odd.delicacy.mapper.news.NewsMapper;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends BaseService<NewsMapper, News> {
}
