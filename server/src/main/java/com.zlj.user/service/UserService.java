package com.zlj.user.service;

import com.zlj.user.dataobject.UserInfo;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-25 18:32
 * @description
 */
public interface UserService {

    /**
     * 通过openid获取用户
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
