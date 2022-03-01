package com.yj.web.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author: YG.
 * @Description: 获取Session对象，存储数据
 * @Date: create in 2022/2/28
 */
@WebServlet(urlPatterns = "/sessionDemo2")
@Slf4j
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取Session对象
        HttpSession session = req.getSession();
        //打印session
        log.info(String.valueOf(session));
        //获取数据
        Object username = session.getAttribute("username");
        log.info((String) username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
