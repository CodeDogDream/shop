package com.dream.login.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.dream.login.dao.LoginDao;
import com.dream.login.entity.Login;
import com.dream.login.exception.UserLoginException;
import com.dream.login.service.LoginService;
import com.dream.login.utils.EncryptUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    @Override
    public void userLogin(String username, String password) throws UserLoginException {
        Login userLogin = loginDao.findUserLogin(username);
        if (userLogin == null) {
            throw new UserLoginException("用户不存在");
        }
        if (!StringUtils.equals(userLogin.getPassword(),
                EncryptUtils.getMd5Pwd(userLogin.getSalt(), password))) {
            throw new UserLoginException("密码错误");
        }

    }

    @Override
    public void addUserLogin(Login login) throws UserLoginException {
        //todo 权限处理
        String salt = EncryptUtils.getSalt();
        login.setSalt(salt);
        login.setUId(EncryptUtils.getUUID());
        login.setPassword(EncryptUtils.getMd5Pwd(salt, login.getPassword()));
        loginDao.addUserLogin(login);
    }
}
