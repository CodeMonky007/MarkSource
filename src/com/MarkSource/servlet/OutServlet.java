package com.MarkSource.servlet;

import com.MarkSource.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OutServlet")
public class OutServlet extends HttpServlet {
    private static final long serialVersionUID = 1599366365079846238L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 获取用户对象
        /*User user = (User)session.getAttribute("name");*/
        // 判断用户是否有效
        request.getSession().invalidate();//使session失效
        /*if(user != null){
            // 将用户对象逐出session
            session.removeAttribute("name");
            // 设置提示信息
            *//*request.setAttribute("info", user.getUser_name() + " 已成功退出！");*//*

        }*/
        // 转发到message.jsp页面
        response.sendRedirect(request.getContextPath()+"/MarkSource/index.jsp");
        /*request.getRequestDispatcher("/MarkSource/index.jsp").forward(request, response);*/
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //清除session
        request.getSession().invalidate();//使session失效
        //重新定向到首页
        response.sendRedirect(request.getContextPath()+"/MarkSource/index.jsp");
        //return null;

    }
}
