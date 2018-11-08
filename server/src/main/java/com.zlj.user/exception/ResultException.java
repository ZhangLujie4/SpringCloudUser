package com.zlj.user.exception;

import com.zlj.user.enums.ResultEnum;

/**
 * @author tori
 * @description
 * @date 2018/9/4 下午1:35
 */
public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
