package com.zlj.user.controller;

import com.zlj.user.constant.CookieConstant;
import com.zlj.user.dataobject.UserInfo;
import com.zlj.user.enums.ResultEnum;
import com.zlj.user.enums.RoleEnum;
import com.zlj.user.service.UserService;
import com.zlj.user.utils.CookieUtil;
import com.zlj.user.utils.ResultVOUtil;
import com.zlj.user.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.zlj.user.constant.CookieConstant.*;

/**
 * @author Tori
 * @version V1.0.0
 * @date 2018-09-26 09:01
 * @description
 */

@RestController
@RequestMapping("/login")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response) {

        // 1.openid匹配数据库数据
        UserInfo userInfo = userService.findByOpenid(openid);
        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 3.cookie里设置openid
        CookieUtil.set(response, OPENID, openid, expire);

        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        Cookie cookie = CookieUtil.get(request, TOKEN);

        if (null != cookie
                && !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        // 1.openid匹配数据库数据
        UserInfo userInfo = userService.findByOpenid(openid);
        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3.往redis里面写
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        redisTemplate.opsForValue().set(String.format(TOKEN_TEMPLATE, token), openid, expire, TimeUnit.SECONDS);

        // 3.cookie里设置openid
        CookieUtil.set(response, TOKEN, token, expire);

        return ResultVOUtil.success();
    }
}
