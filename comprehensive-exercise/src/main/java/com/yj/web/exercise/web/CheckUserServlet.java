package com.yj.web.exercise.web;


import com.yj.web.exercise.entity.User;
import com.yj.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author YG.
 * @date 2022/3/2 10:35
 */
@WebServlet(urlPatterns = "/checkU")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User build = User.builder().username(username).build();
        UserService userService = new UserService();
        boolean register = userService.register(build);
        resp.getWriter().write(String.valueOf(register));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
