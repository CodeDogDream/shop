package com.dream.login.service;

import com.dream.login.entity.Login;
import com.dream.login.exception.UserLoginException;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
public interface LoginService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @throws UserLoginException 登录失败的异常
     */
    void userLogin(String username, String password) throws UserLoginException;

    /**
     * 增加用户登录信息
     *
     * @param login 新增的用户信息
     * @throws UserLoginException 异常
     */
    void addUserLogin(Login login) throws UserLoginException;
}