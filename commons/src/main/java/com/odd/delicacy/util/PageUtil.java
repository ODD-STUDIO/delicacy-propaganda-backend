package com.odd.delicacy.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * PageInfo 工具类
 *
 * @author Tanglinfeng
 * @date 2021/7/6 10:47
 */
public class PageUtil {

    /**
     * 构建普通分页对象
     *
     * @param pageNum  当前页数，从 0 开始
     * @param pageSize 一页大小
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> pageInfo(int pageNum, int pageSize) {
        PageInfo<T> page = new PageInfo<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        return page;
    }

    /**
     * 构建带排序的分页对象
     *
     * @param pageNum  当前页数，从 0 开始
     * @param pageSize 一页大小
     * @param column   排序字段
     * @param order    排序规则：ASC 或 DESC
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> pageInfo(int pageNum, int pageSize, String column, String order) {
        PageInfo<T> page = new PageInfo<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        PageHelper.orderBy(order(column, order));

        return page;
    }

    private static String order(String column, String order) {
        if ("desc".equalsIgnoreCase(order)) {
            return column + " DESC ";
        }
        return column + " ASC ";
    }
}
