package com.yj.web.exercise.service;

import com.yj.web.exercise.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class UserServiceTest {

    @Test
    void login() {
        UserService userService = new UserService();
        User user = userService.login("zhangsan", "123");
        if (user != null) {
            log.info(String.valueOf(user));
            System.out.println(user);
        }
    }

    @Test
    void register() {
        UserService userService = new UserService();
        User user = new User(3, "yangjing", "123");
        boolean r1 = userService.register(user);
        log.info(String.valueOf(r1));

    }
}