package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import com.MarkSource.db.OperationSource;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Update_netSourceServlet")
public class Update_netSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source_id = request.getParameter("source_id");
        String source_type = request.getParameter("source_type");
        String source_des = request.getParameter("source_des");
        String source_link = request.getParameter("source_link");
        JSONObject json = new JSONObject();
        System.out.println(source_type);
        if (source_des == null || "".equals(source_des)) {
            json.put("code", 300);
            json.put("msg", "请输入资源描述");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            return;
        }
        if (source_link == null || "".equals(source_link)) {
            json.put("code", 300);
            json.put("msg", "请输入资源链接");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            return;
        }

        Source source = new Source();
        source.setSource_id(source_id);
        source.setSource_type(source_type);
        source.setSource_des(source_des);
        source.setSource_link(source_link);

        OperationSource operationSource = new OperationSource();
        int i = operationSource.update_netSource(source);
        if (i == 1) {
            json.put("code", 200);
            json.put("msg", "修改成功");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
        } else {
            json.put("code", 500);
            json.put("msg", "修改失败");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
        }
    }

}
