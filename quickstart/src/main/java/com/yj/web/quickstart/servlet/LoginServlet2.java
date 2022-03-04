package com.yj.web.quickstart.servlet;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/3/3
 */
@WebServlet(urlPatterns = "/login2")
public class LoginServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=utf-8");
        //将字符串转换成JSON对象返回
        out.print(JSONObject.parseObject(json.toString()));
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
