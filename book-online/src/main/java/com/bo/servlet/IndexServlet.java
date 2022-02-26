package com.bo.servlet;

import com.bo.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/24
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        List<Book> bookList = (List<Book>) servletContext.getAttribute("bookList");

        req.setAttribute("bookList", bookList);
        resp.setContentType("text/plain;charset=utf-8");
//        resp.getWriter().print(bookList.toString());
        //通过服务器端转发，将数据带过去，保持地址栏不变
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
