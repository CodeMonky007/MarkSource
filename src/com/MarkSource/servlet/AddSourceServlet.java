package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import com.MarkSource.db.OperationSource;
import com.schoolWeb.utils.UniqId;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddSourceServlet")
public class AddSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  source_type=request.getParameter("source_type");
        String  source_des=request.getParameter("source_des");
        String  source_link=request.getParameter("source_link");
        String  source_location=request.getParameter("source_location");

        JSONObject jsonObject=new JSONObject();
        Integer columnWights=0;
        if(source_link==null||source_link.equals("")){
            jsonObject.put("code",300);
            jsonObject.put("msg","请输入资源链接");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
            return;
        }
        if(source_des==null||source_des.equals("")){
            jsonObject.put("code",300);
            jsonObject.put("msg","请输入资源描述");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
            return;

        }

        Source source =new Source();
        source.setSource_id(UniqId.getUniqIDHashString());
        source.setSource_type(source_type);
        source.setSource_link(source_link);
        source.setSource_des(source_des);
        source.setSource_location(source_location);

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        source.setCreate_time(sdf.format(date));

        /*localSource.setCol_wight(columnWights);*/
        OperationSource operationLocalSource=new OperationSource();
        int i=operationLocalSource.initSource(source);
        if(i==1){
            jsonObject.put("code",200);
            jsonObject.put("msg","资源登记成功");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
        }else{
            jsonObject.put("code",500);
            jsonObject.put("msg","资源登记失败");
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
        }


    }
}
