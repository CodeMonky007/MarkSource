<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%
    String user=session.getAttribute("name").toString();
%>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户界面</title>
    <link rel="stylesheet" href="./static/layui/css/layui.css">
    <link rel="stylesheet" href="./static/layui/css/modules/layer/default/layer.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: 16px;font-weight: 700">Mark Source <span style="font-size: 14px;">资源管理中心</span></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="./static/images/user.png" class="layui-nav-img">
                    ${name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/OutServlet">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"> <%--<li class="layui-nav-item layui-nav-itemed">--%>
                    <a  href="javascript:;">资源管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" onclick="onAddSource();">资源登记</a></dd>
                        <dd><a href="javascript:;" onclick="mange_netSource();">网络资源</a></dd>
                        <dd><a href="javascript:;" onclick="mange_localSource();">本地资源</a></dd>
                        <%--<dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">文件资源管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" onclick="addFileSource();">资源登记</a></dd>
                        <dd><a href="javascript:;">资源管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="onUpdatePwd();">密码修改</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body" >

        <!-- 内容主体区域 -->
        <div style="height:90%;padding: 0;">
            <iframe width="100%" height="100%" style="overflow: visible;" class="bg-content" id="bg-content-iframe"
                    src="" > <%--frameborder="no" scrolling="no" hidden--%>

            </iframe>
        </div>
    </div>

    <div class="layui-footer" style="font-weight: 600;opacity: .8;">
        <!-- 底部固定区域 -->
        © Mark Source 资源管理中心 - 底部固定区域
    </div>
</div>
<script src="static/js/jquery.js"></script>
<script src="./static/layui/layui.js"></script>
<script src="./static/layui/lay/modules/layer.js"></script>
<script src="static/js/userInterface.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
    //登录进入的欢迎弹窗
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: true
        ,area: '650px'
        ,shade: 0.6
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        /*,btn:  'OK'*/
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="background: rgb(35,38,46);width:450px;height:100px;padding: 100px; line-height: 22px; background-color: #494d55; color: #fff;font-size: 20px; font-weight: 600;text-align: center;letter-spacing: .5em;">欢迎来到您的资源管理中心</div>'
        /*,content: '<div style="background: url(\'./static/images/p1.gif\') no-repeat center ;width:450px;height:100px;padding: 100px; line-height: 22px; background-color: #494d55; color: #fff;font-size: 24px; font-weight: 600;text-align: center;letter-spacing: .5em;">欢迎来到您的资源管理中心</div>'*/
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
           /* btn.find('.layui-layer-btn0').attr({
                href: 'http://www.layui.com/'
                ,target: '_blank'
            });*/
        }
    });
</script>
</body>
</html>