package com.MarkSource.servlet;

import net.sf.json.JSONObject;
import com.MarkSource.bean.User;
import com.MarkSource.db.OperationUser;
import com.MarkSource.utils.UniqId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//这里是一个重点，idea中会自动生成@WebServlet(name="RegisterServlet")这样的形式，但是在运行时会报错，很难发现，所以先把name去掉！
@WebServlet(name="RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            System.out.println(name+"----"+password);
            String id= UniqId.getUniqIDHashString();
            JSONObject json=new JSONObject();
            if(name==null || "".equals(name)||password==null||"".equals(password)){
                json.put("code",300);
                json.put("msg","缺少用户名或密码");
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer=response.getWriter();
                writer.print(json);
                return;
            }

            User user=new User();
            user.setUser_id(id);
            user.setUser_name(name);
            user.setUser_password(password);
        OperationUser operationUser=new OperationUser();
        int i=operationUser.intitUser(user);
        System.out.println(i);
        /*JSONObject json=new JSONObject();*/
        if(i==1){
        json.put("code",200);
        json.put("msg","注册成功！");
        }else{
            json.put("code",500);
            json.put("msg","注册失败！");
        }
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=response.getWriter();
        writer.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


