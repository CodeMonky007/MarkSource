package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import com.MarkSource.bean.User;
import com.MarkSource.db.OperationSource;
import com.MarkSource.db.OperationUser;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Update_pwdServlet")
public class Update_pwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String new_password = request.getParameter("new_password");
        String password = request.getParameter("password");
        JSONObject json = new JSONObject();

        if (username == null || "".equals(username)) {
            json.put("code", 300);
            json.put("msg", "请输入账号");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            return;
        }
        if (password == null || "".equals(password)) {
            json.put("code", 300);
            json.put("msg", "请输入原密码");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            return;
        }
        if (new_password == null || "".equals(new_password)) {
            json.put("code", 300);
            json.put("msg", "请输入新密码");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            return;
        }

        User user = new User();
       user.setUser_password(new_password);
        user.setUser_name(username);

        OperationUser operationUser = new OperationUser();
        User user2=operationUser.selPwd(username);
        if(password.equals(user2.getUser_password())) {
            int i = operationUser.updatePwd(user);
            if (i == 1) {
                json.put("code", 200);
                json.put("msg", "修改成功");
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.print(json);
                /*response.sendRedirect("/MarkSource/index.jsp");*/
            } else {
                json.put("code", 500);
                json.put("msg", "修改失败");
                response.setContentType("text/html; charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.print(json);
            }
        }else{
            json.put("code",500);
            json.put("msg","原密码不正确！");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            writer.print(json);
        }
    }

}
