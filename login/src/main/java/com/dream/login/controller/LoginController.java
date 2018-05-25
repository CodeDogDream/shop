package com.dream.login.controller;

import com.dream.login.entity.Login;
import com.dream.login.exception.UserLoginException;
import com.dream.login.service.LoginService;
import com.dream.login.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Dream on 2018/5/24.
 *
 * @author Dream
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public Map<String, Object> userLogin(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        //todo 判断用户是否登录，如果用户已经登录了，那么就重定向到首页去
        try {
            loginService.userLogin(username, password);
        } catch (UserLoginException e) {
            return ResponseUtils.getBasicResponse(-1, e.getMessage(), null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseUtils.getBasicResponse(-1, "服务器内部错误", null);
        }
        //todo 生成token存到redis里去，返回给前端
        return ResponseUtils.getBasicResponse(1, "登录成功", null);
    }

    @RequestMapping("/add")
    public Map<String, Object> add(@RequestBody Login login) {
        //todo 权限验证
        loginService.addUserLogin(login);
        return ResponseUtils.getBasicResponse(1, "success", null);
    }
}