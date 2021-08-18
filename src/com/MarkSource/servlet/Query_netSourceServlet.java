package com.MarkSource.servlet;

import com.MarkSource.bean.Source;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Query_netSourceServlet")
public class Query_netSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /*private void queryList(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        String str = request.getParameter("source_type2");
        String pindex = request.getParameter("page");
        String limit = request.getParameter("limit");
        response.setStatus(200);
        String aid = null;
        int pagesize=15;
        int index = 0;
        int total = 0;
        if (str != null && str.length() > 0) {
            aid = str;

        }
        if (pindex != null) {
            index = Integer.parseInt(pindex);
            pagesize=Integer.parseInt(limit);
        }


        WeiMobUvDao dao = new WeiMobUvDao();

        StringBuilder sbtotal = new StringBuilder();
        sbtotal.append("SELECT count(1) as count FROM source");
        if (aid > 0) {
            sbtotal.append(" where aid=");
            sbtotal.append(aid);

        }
        total = dao.GetCount(sbtotal.toString());
        if (total > 0) {

            StringBuffer sb = new StringBuffer();
            sb.append("SELECT Id,AId,Uv,DataType,Date FROM WpMulShopDataUv_1 ");
            if (aid > 0) {
                sb.append(" where aid=");
                sb.append(aid);

            }
            if (total > pagesize) {
                sb.append(" Limit ");
                int start = (index - 1) * pagesize;
                if (start < 0) {
                    start = 0;

                }
                sb.append(start);
                sb.append(",");
                sb.append(pagesize);
            }

           *//* List<Source> list = dao.QueryUv(sb.toString());

            ArrayList<Source> result = new ArrayList<Source>(total, list);*//*

           *//* String jsonstr= ConvertListToPageJson(list,total);
            System.out.println(jsonstr);
            request.setAttribute("result", jsonstr);
            response.getWriter().print(jsonstr);*//*

        }else {
           *//* ArrayList<Source> result = new ArrayList<Source>(total, null);
            JSONObject obj = new JSONObject(result);
            response.getWriter().print(obj);*//*

        }
    }*/

   /* public  String ConvertListToPageJson(List<?> list, int countList) {
        // 新建一个json数组
        JSONArray jsonArray = new JSONArray();
        // 新建一个json对象
        JSONObject jsonObject = null;
        // 遍历泛型集合
        for (Object object : list) {
            jsonObject = new JSONObject(object);
            jsonArray.put(jsonObject);
        }
        // 转换数据格式
        String json = jsonArray.toString();
        // 拼接字符串
        StringBuffer sb = new StringBuffer();
        sb.append("{\"count\":");
        sb.append(countList);
        sb.append(",\"code\":");
        sb.append(0);
        sb.append(",\"msg\":");
        sb.append("null");
        sb.append(",\"data\":");
        sb.append(json);
        sb.append("}");
        String jsonString = sb.toString();
        return jsonString;

    }*/
    }


