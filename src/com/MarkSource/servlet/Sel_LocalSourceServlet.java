package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import com.MarkSource.db.OperationSource;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Sel_LocalSourceServlet")
public class Sel_LocalSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ArrayList<LocalSource> localSources=null;*/
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer limit = Integer.valueOf(request.getParameter("limit"));
        /*ArrayList<LocalSource> localSources=null;*/
        System.out.println(page + "----" + limit);
        String sel_localSource = request.getParameter("key");
        ArrayList<Source> list = null;
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        OperationSource operationSource =new OperationSource();
        int stopItme = page * limit;
        int starItme = stopItme - limit;
        if (sel_localSource == null) {
            list = operationSource.selLocalSource(starItme, stopItme);
        } else {
            list = operationSource.sels_local(starItme, stopItme, sel_localSource);
        }


        /*operationSource.selLocalSource();*/
        /*System.out.println(localSources.size());*/
        jsonObject.put( "code",0);
        jsonObject.put( "data", list);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);

    }
}
