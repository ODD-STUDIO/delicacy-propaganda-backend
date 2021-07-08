package com.odd.delicacy.entity.picture;

import com.odd.delicacy.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 存放所有图片
 *
 * @author Tanglinfeng
 * @date 2021/7/8 18:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture extends BaseEntity<Picture> {

    private String url;

    /** 关联 id */
    private Long associateId;

    /** 图片状态：0表示正常，1表示屏蔽 */
    private Integer status;

    /** 图片排序，大的在前小的在后，默认为 0 */
    private Integer orderNum;

    /** 图片类型：GOOD、NEWS 等 */
    private String type;
}
