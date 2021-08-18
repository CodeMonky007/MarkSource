package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import com.MarkSource.db.OperationSource;
import com.schoolWeb.bean.New;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SelectSourceServlet")
public class SelectSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer limit = Integer.valueOf(request.getParameter("limit"));
        /*ArrayList<LocalSource> localSources=null;*/
        System.out.println(page + "----" + limit);
        String sel_netSource = request.getParameter("key");
        ArrayList<Source> list = null;
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("id");
        /*if(user_id==null||"".equals(user_id)){
            response.sendRedirect("/MarkSource/index.jsp");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);
            return;
        }*/
        OperationSource operationSource = new OperationSource();


        int stopItme = page * limit;
        int starItme = stopItme - limit;
        if (sel_netSource == null) {
            list = operationSource.selNetSource(starItme, stopItme);
        } else {
            list = operationSource.sels_net(starItme, stopItme, sel_netSource);
        }
        /*System.out.println(localSources.size());*/

        ArrayList<Source> sources = new ArrayList<>();

      /*  for (Source source:list) {
            String str = "";
            String str2="";
            source.setSource_type(str);
            source.setSource_des(str2);
        }*/
        jsonObject.put("code", 0);
        jsonObject.put("data", list);
        /*jsonObject.put( "data", operationSource.selNetSource());*/
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);

    }
}
