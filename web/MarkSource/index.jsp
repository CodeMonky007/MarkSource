<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/11
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./static/layui/css/layui.css">
    <link rel="stylesheet" href="./static/css/index.css">

</head>
<body>

<%--
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>水平导航菜单</legend>
</fieldset>
--%>

<ul class="layui-nav" style="line-height: 60px;">
    <li style="float: left;line-height: 60px;font-size: 16px;font-weight: 600;margin-right: 10px;"><span style="font-size:20px; font-weight: 600;">Mark</span> Source</li>
    <li class="layui-nav-item"><a href="">最新活动</a></li>
    <li class="layui-nav-item layui-this">
        <a href="javascript:;">产品</a>
        <dl class="layui-nav-child">
            <dd><a href="">选项1</a></dd>
            <dd><a href="">选项2</a></dd>
            <dd><a href="">选项3</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">大数据</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">解决方案</a>
        <dl class="layui-nav-child">
            <dd><a href="">移动模块</a></dd>
            <dd><a href="">后台模版</a></dd>
            <dd class="layui-this"><a href="">选中项</a></dd>
            <dd><a href="">电商平台</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">社区</a></li>
    <div style="float: right;" onclick="loginFun();"><a href="javascript:;" style="margin-right: 10px;font-size: 20px;font-weight: 600;color: white;">注册</a></div>
</ul>
<%--登录开始--%>
<div class="bc">
    <form action="/LoginServlet" class="box layui-form login-form" method="post">
        <input type="hidden" class="msg-input" value="<%=request.getAttribute("msg")%>">
        <h1>Login</h1>
        <label>
            <input type="text" name="username" class="login-name" placeholder="请输入用户名" size="20" maxlength="20">
        </label>
        <label>
            <input type="password" name="password" class="login-password" placeholder="请输入密码" size="20" maxlength="20">
        </label>
        <div>
            <button style="padding: 0 25px;height: 50px;" class="layui-btn layui-btn-primary"   type="button" lay-submit lay-filter="fromDemo" onclick="loginClickFun();">登录</button>

            <button style="padding: 0 25px;height: 50px;" type="reset" class="layui-btn layui-btn-primary" onclick="resetClick();">重置</button>
        </div>
    </form>
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<script src="./static/js/jquery.js"></script>
<link rel="stylesheet" href="./static/css/swiper-bundle.min.css">
<script src="./static/js/swiper-bundle.min.js"></script>
<script src="./static/layui/layui.all.js"></script>
<script src="./static/layui/layui.js"></script>
<script src="./static/js/login.js"></script>
</body>
</html>
