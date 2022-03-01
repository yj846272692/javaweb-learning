package com.yj.web.exercise.web;

import com.yj.web.exercise.entity.Brand;
import com.yj.web.exercise.entity.User;
import com.yj.web.exercise.service.BrandService;
import com.yj.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * 登录逻辑处理
 */

@WebServlet(urlPatterns = "/index")
@Slf4j
public class IndexServlet extends HttpServlet {


    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        log.info("user:{}", user);
        //1. 调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();
        //2. 存入request域中
        req.setAttribute("brands", brands);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
