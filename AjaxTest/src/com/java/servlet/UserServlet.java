package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ajax 训练
 * */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String first = request.getParameter("first");           //从前端获取数据first
        String second = request.getParameter("second");         //从前端获取数据second
        String result=first+second;
        System.out.println(result);                                      //用于测试 ，判断是否成功获取到数据；
        out.println(result);                                                 //将数据传到前端


    }
}