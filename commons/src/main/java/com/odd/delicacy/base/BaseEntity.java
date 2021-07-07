package com.odd.delicacy.base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类基类
 *
 * @author Tanglinfeng
 * @date 2021/7/6 10:20
 */
@Data
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionID = 19843513542L;

    private Long id;

    private Integer isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
