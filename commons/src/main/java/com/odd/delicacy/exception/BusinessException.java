package com.odd.delicacy.exception;

import com.odd.delicacy.api.ResultCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常
 *
 * @author Tanglinfeng
 * @date 2021/7/6 9:52
 */
@Getter
@ToString
public class BusinessException extends RuntimeException {

    private final ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        this(resultCode.msg(), resultCode);
    }

    public BusinessException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }
}
