package com.zlj.user.repository;

import com.zlj.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-25 18:31
 * @description
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
