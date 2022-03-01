package com.yj.web.exercise.web;

import com.yj.web.exercise.util.VerifyCodeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/3/1
 */
@WebServlet(urlPatterns = "/check")
public class CheckCodeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获得session，并把字符串保存在session中，为后面的对比做基础
        HttpSession session = request.getSession();

        //禁用缓存，每次访问此页面，都重新生成
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //调用里面的方法，返回的是生成的验证码中的字符串
        String str = VerifyCodeUtil.generate(response.getOutputStream());

        session.setAttribute("code", str);
    }
}
