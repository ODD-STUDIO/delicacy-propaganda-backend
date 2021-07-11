package com.odd.delicacy.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.odd.delicacy.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基类 Service
 *
 * @author Tanglinfeng
 * @date 2021/7/6 10:36
 */
public abstract class BaseService<M extends BaseMapper<T>, T extends BaseEntity<T>> {

    @Autowired
    protected M mapper;

    /**
     * 查询多条记录
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return mapper.findList(entity);
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @param entity
     * @return
     */
    public PageVO<T> findPage(PageInfo<T> pageInfo, T entity) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        System.out.println("1");
        PageInfo<T> page = new PageInfo<>(mapper.findList(entity));
        System.out.println("2");
        // 构建 PageVO 返回对象
        return new PageVO<>(page.getTotal(), page.getPages(), page.getPageNum(), page.getPageSize(), page.getList());
    }

    /**
     * 插入单条数据
     *
     * @param entity
     * @return true if success
     */
    public boolean insert(T entity) {
        return mapper.insert(entity) > 0;
    }

    /**
     * 更新单条数据
     *
     * @param entity
     * @return true if success
     */
    public boolean update(T entity) {
        return mapper.update(entity) > 0;
    }

    /**
     * 根据 Id 删除单条数据
     *
     * @param id
     * @return true if success
     */
    public boolean deleteById(Long id) {
        return mapper.deleteById(id) > 0;
    }
}
