package com.odd.delicacy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询返回对象
 *
 * @author Tanglinfeng
 * @date 2021/7/6 17:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> {

    /** 总记录数 */
    private long totalElements;

    /** 总页数 */
    private int totalPages;

    /** 当前页码 */
    private int pageNum;

    /** 一页大小 */
    private int pageSize;

    /** 当前页数据 */
    private List<T> data;
}
