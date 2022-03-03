package com.yj.web.exercise.web;

import com.yj.web.exercise.entity.Brand;
import com.yj.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/3/1
 */
@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        System.out.println(id);


        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));


        //2. 调用service 完成修改
        brandService.delete(brand);


        //3. 重定向到查询所有Servlet
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/index");
    }
}