package com.MarkSource.servlet;

import com.MarkSource.db.OperationSource;
import com.schoolWeb.db.OperationColumn;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Del_netSourceServlet")
public class Del_netSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String source_id= request.getParameter( "source_id" );
        OperationSource operationSource = new OperationSource();
        /*int id = Integer.valueOf(source_id);*/
        int i = operationSource.del_netSource(source_id);
        JSONObject json = new JSONObject();
        if(i==1){
            json.put( "code" ,200);
            json.put("msg","网络资源删除成功！");
            response.setContentType( "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
        }else {
            json.put( "code" ,500);
            json.put( "msg","网络资源删除失败！");
            response.setContentType( "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
        }

    }
}
