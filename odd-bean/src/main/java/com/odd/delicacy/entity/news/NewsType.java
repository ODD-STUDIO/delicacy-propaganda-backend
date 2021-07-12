package com.odd.delicacy.entity.news;

import com.odd.delicacy.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsType extends BaseEntity<NewsType> {

    private String newsTypeName;
}
