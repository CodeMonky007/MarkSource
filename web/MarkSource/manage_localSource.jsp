<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/6
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>本地资源管理</title>
    <link rel="stylesheet" href="./static/layui/css/layui.css">
    <link rel="stylesheet" href="./static/css/manage_netSource.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
    <legend>本地资源管理</legend>
</fieldset>

<script type="text/html" id="toolbarDemo2"></script>
<%--数据查询部分开始--%>
<div class="demoTable" >
    <label class="layui-form-label">资源搜索:</label>
    <div class="layui-inline">
        <label for="source_type"></label><input class="layui-input type" name="source_type" id="source_type"
                                                autocomplete="off" lay-search placeholder="请输入资源类型">
    </div>
    <button type="button" class="layui-btn" data-type="reload" id="search">搜索</button>
    <button type="reset" class="layui-btn" onclick="resetClick();">重置</button>
</div>
<%--数据查询部分结束--%>


<table id="source-list" lay-filter="source-list" ></table>

<script type="text/html" id="source_oper">
    <button style="display: inline-block;
    height: 38px;
    line-height: 38px;
    padding: 0 18px;
    background-color: #009688;
    color: #fff;
    white-space: nowrap;
    text-align: center;
    font-size: 14px;
    border: none;
    border-radius: 2px;
    cursor: pointer" type="button" class="layui-btn" lay-event="update"><i class="layui-icon"></i></button>
    <button style="display: inline-block;
    height: 38px;
    line-height: 38px;
    padding: 0 18px;
    background-color: #FF5722;
    color: #fff;
    white-space: nowrap;
    text-align: center;
    font-size: 14px;
    border: none;
    border-radius: 2px;
    cursor: pointer;" type="button" class="layui-btn layui-btn-danger" lay-event="del"><i class="layui-icon"></i>
    </button>
    <%--<a class="layui-btn layui-btn-danger lavui-btn-xs" lay-event="del"><i class="layui-icon"></i></a>--%>
</script>
<script>
    function resetClick() {
        $(".type").val("");
    }
</script>
<script src="./static/layui/layui.all.js"></script>
<script src="./static/layui/layui.js"></script>
<script src="./static/js/jquery.js"></script>
<%--<script src="./static/js/localSource_oper.js"></script>--%>
<script src="./static/js/localSource_oper.js"></script>
</body>
</html>
