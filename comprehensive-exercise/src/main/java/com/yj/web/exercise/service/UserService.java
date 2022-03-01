package com.yj.web.exercise.service;

import com.yj.web.exercise.entity.User;
import com.yj.web.exercise.mapper.UserMapper;
import com.yj.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/28
 */
public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        // 获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法
        User user = mapper.findUser(username, password);
        // 释放资源
        sqlSession.close();
        return user;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        //1. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }
}
