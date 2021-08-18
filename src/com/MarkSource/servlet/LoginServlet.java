package com.MarkSource.servlet;

import com.MarkSource.bean.User;
import com.MarkSource.db.OperationUser;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //下面的转码是一个重点，解决中文用户名不能登录的问题，问题就是编码冲突，因此需要下面的方法
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(name+"****"+password);
        if(name==null||name.equals("")||password==null||password.equals("")){
            //Servlet的连接
            request.setAttribute("msg","用户名，密码不能为空");
            /*RequestDispatcher requestDispatcher=request.getRequestDispatcher("/MarkSource/index.jsp");
            requestDispatcher.forward(request,response);*/
            response.sendRedirect("/MarkSource/index.jsp");
            return;
        }
        JSONObject jsonObject=new JSONObject();
        OperationUser operationUser=new OperationUser();
        User user=operationUser.loginUser(name);


        if(name.equals(user.getUser_name())&&password.equals(user.getUser_password())){
            session.setAttribute("id",user.getUser_id());
            session.setAttribute("name",user.getUser_name());
            session.setAttribute("password",user.getUser_password());
            //重定向的写法
            String path="/MarkSource/userInterface.jsp";
            response.sendRedirect(path);
        }else{
            response.getWriter().write("用户名或者密码错误，登录失败！");
           request.setAttribute("msg","用户名或密码不正确");
            /*RequestDispatcher requestDispatcher=request.getRequestDispatcher("/MarkSource/index.jsp");
            requestDispatcher.forward(request,response);*/
            response.sendRedirect("/MarkSource/index.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
