package com.zlj.user.enums;

import lombok.Getter;

/**
 * @author tori
 * @description
 * @date 2018/9/4 下午1:37
 */

@Getter
public enum ResultEnum {

    LOGIN_FAIL(1, "登录失败"),

    ROLE_ERROR(2, "权限异常")
    ;
    private String message;

    private Integer code;

    ResultEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
