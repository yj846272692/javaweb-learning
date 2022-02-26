package com.bo.service;

import com.bo.entity.User;

import java.util.List;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/24
 */
public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 用户登录功能
     *
     * @param account
     * @param password
     * @return user
     */
    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
