package com.yj.web.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/28
 */
@WebServlet(urlPatterns = "/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //发送Cookie
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username", "yangjing");
        Cookie name = new Cookie("SSS", "你好cookie");
        //2.对Cookie持久化
        cookie.setMaxAge(60 * 60 * 24 * 7);
        //3.通过response发送Cookie
        resp.addCookie(cookie);
        resp.addCookie(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
