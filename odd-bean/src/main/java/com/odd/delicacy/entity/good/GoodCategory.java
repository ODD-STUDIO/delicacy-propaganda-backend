package com.odd.delicacy.entity.good;

import com.odd.delicacy.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品分类
 *
 * @author Tanglinfeng
 * @date 2021/7/6 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodCategory extends BaseEntity<GoodCategory> {

    private String goodCategoryName;

    /** 商品分类状态：0 表示正常，1 表示有上新，2 表示屏蔽 */
    private Integer goodCategoryStatus;
}
