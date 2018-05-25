package com.dream.login.dao;

import com.alibaba.druid.util.StringUtils;
import com.dream.login.entity.Login;
import com.dream.login.utils.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginDaoTest {
    @Resource
    private LoginDao loginDao;

    @Test
    public void findUserLogin() {
        Login userLogin = loginDao.findUserLogin("admin");
        String password = userLogin.getPassword();
        String salt = userLogin.getSalt();
        String result = EncryptUtils.getMd5Pwd(salt, "admin");
        if (StringUtils.equals(result, password)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }

    }

    @Test
    public void addUserLogin() {
        Login login = new Login();
        String salt = EncryptUtils.getSalt();
        login.setSalt(salt);
        String password = "admin";
        String username = "admin";
        login.setPassword(EncryptUtils.getMd5Pwd(salt, password));
        login.setUsername(username);
        login.setUId(EncryptUtils.getUUID());
        loginDao.addUserLogin(login);
    }
}