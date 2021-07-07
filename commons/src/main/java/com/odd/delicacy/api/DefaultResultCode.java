package com.odd.delicacy.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用状态码
 *
 * @author Tanglinfeng
 * @date 2021/7/6 9:40
 */
@AllArgsConstructor
public enum DefaultResultCode implements ResultCode {

    SUCCESS(200, "响应成功"),
    FAIL(400, "请求失败"),
    ERROR(500, "系统繁忙")

    ;

    private final int code;

    private final String msg;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
