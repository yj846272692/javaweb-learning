package com.yj.web.exercise.web;

import com.alibaba.fastjson.JSON;
import com.yj.web.exercise.entity.Brand;
import com.yj.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 处理前端请求，返回品牌列表JSON数据
 */

@WebServlet("/selectAllServlet")
public class ServletAllServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据 -> 序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据  application/json
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
