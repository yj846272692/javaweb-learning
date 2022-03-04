package com.yj.web.quickstart.servlet;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/3/3
 */

import com.alibaba.fastjson.JSON;
import com.yj.web.quickstart.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 接收前端表单请求，向客户端返回JSON数据
 *
 * @author YG.
 */
@WebServlet(urlPatterns = "/login1")
public class LoginServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account + password);
        User user = new User(account, password);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        out.write(JSON.toJSONString(user));
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}