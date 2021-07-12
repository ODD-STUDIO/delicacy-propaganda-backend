package com.odd.delicacy.entity.news;

import com.odd.delicacy.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News extends BaseEntity<News> {
//    private long id;
    private String newsTitle;
    private String newsContent;
    private String newsDesc;
    private NewsType newsType;
    private String newsThumb;
//    private long isDeleted;
//    private java.sql.Timestamp createTime;
//    private java.sql.Timestamp updateTime;
}
