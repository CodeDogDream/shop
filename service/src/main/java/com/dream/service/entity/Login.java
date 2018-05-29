package com.dream.service.entity;

/**
 * Created by Dream on 2018/5/17.
 *
 * @author Dream
 */
public class Login {
    /***
     * id 生成的唯一id
     * username 登录的用户名
     * password 加密后的用户密码
     * salt 加密所用的盐
     * UId 用户唯一UUID
     */
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String UId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", UId='" + UId + '\'' +
                '}';
    }
}
