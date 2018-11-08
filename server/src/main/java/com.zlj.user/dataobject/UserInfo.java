package com.zlj.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-25 18:29
 * @description
 */

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
