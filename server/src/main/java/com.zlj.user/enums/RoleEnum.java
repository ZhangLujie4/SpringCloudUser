package com.zlj.user.enums;

import lombok.Getter;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-26 10:53
 * @description
 */

@Getter
public enum RoleEnum {

    BUYER(1, "买家"),

    SELLER(2, "卖家"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
