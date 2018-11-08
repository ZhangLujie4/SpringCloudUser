package com.zlj.user.service.impl;

import com.zlj.user.dataobject.UserInfo;
import com.zlj.user.repository.UserInfoRepository;
import com.zlj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-25 18:33
 * @description
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
