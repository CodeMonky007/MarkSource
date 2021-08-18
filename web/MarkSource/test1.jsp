<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/11
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>数据页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./static/layui/css/layui.css">
</head>
<body>

<form action="LoginUp/changePassWd" method="post">
    输入账号<input type="text" name="username"/><br>
    输入新密码<input type="password" name="passwd"/><br>
    <%--    再输一次密码<input type="password" name="passWd"/><br>--%>
    <input type="submit" name="get"/>
</form>
</body>





<script src="./static/js/jquery.js"></script>
<script src="./static/layui/layui.js"></script>
<script src="./static/layui/layui.all.js"></script>
</body>
</html>
