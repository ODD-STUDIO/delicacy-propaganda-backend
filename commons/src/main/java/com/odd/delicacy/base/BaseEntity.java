package com.odd.delicacy.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
}
