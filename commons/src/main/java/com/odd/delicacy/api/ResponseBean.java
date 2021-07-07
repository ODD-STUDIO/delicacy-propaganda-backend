package com.odd.delicacy.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * 接口统一返回类
 *
 * @author Tanglinfeng
 * @date 2021/7/6 9:28
 */
@Data
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionID = 14522145339L;

    private int code;

    private String msg;

    private T data;

    private long timestamp = Instant.now().toEpochMilli();

    /**
     * 不带参数的成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> success() {
        return success(null);
    }

    /**
     * 带参数的成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> success(T data) {
        return new ResponseBean<>(DefaultResultCode.SUCCESS, data);
    }

    /**
     * 错误响应
     *
     * @param resultCode 错误状态码
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(ResultCode resultCode) {
        return new ResponseBean<>(resultCode, null);
    }

    /**
     * 错误响应
     *
     * @param code 错误代码
     * @param msg 错误信息
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(int code, String msg) {
        return new ResponseBean<>(code, msg, null);
    }

    /**
     * 响应是否成功
     *
     * @return true if success
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == DefaultResultCode.SUCCESS.code();
    }

    public ResponseBean(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.data = data;
    }

    public ResponseBean() {
    }

    public ResponseBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
