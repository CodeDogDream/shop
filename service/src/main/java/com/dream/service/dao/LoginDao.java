package com.dream.service.dao;


import com.dream.service.entity.Login;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
@Repository
public interface LoginDao {
    /**
     * 根据用户名获取用户登录信息然后判断密码是否正确
     *
     * @param username 用户名
     * @return 用户登录信息
     */
    Login findUserLogin(String username);

    /**
     * 增加用户登录信息
     *
     * @param login 用户登录信息
     * @return 插入行数
     */
    int addUserLogin(Login login);
}
