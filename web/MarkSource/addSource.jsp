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
    <title>资源登记</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./static/layui/css/layui.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<%--<blockquote class="layui-elem-quote layui-text">
    鉴于小伙伴的普遍反馈，先温馨提醒两个常见“问题”：1. <a href="/doc/base/faq.html#form" target="_blank">为什么select/checkbox/radio没显示？</a> 2. <a href="/doc/modules/form.html#render" target="_blank">动态添加的表单元素如何更新？</a>
</blockquote>--%>

<!-- 示例-970 -->
<%--<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>--%>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
    <legend>资源登记</legend>
</fieldset>

<form class="layui-form form1" action="" lay-filter="example" name="form1" style="width:500px;height:400px;margin: 0 auto; ">
    <div class="layui-form-item">
        <label class="layui-form-label">资源所属</label>
        <div class="layui-input-block">
            <input type="radio" class="source_location" name="source_location" value="网络资源" title="网络资源" checked="">
            <input type="radio" class="source_location" name="source_location" value="本地资源" title="本地资源">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">资源链接</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入资源链接" class="layui-textarea source_link" id="source_link" name="source_link"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">资源分类</label>
        <div class="layui-input-block">
            <input type="text" name="source_type" lay-verify="title" autocomplete="off" placeholder="请输入资源类别" id="source_type" class="layui-input source_type">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">资源描述</label>
        <div class="layui-input-block">
            <input type="text" name="source_des" placeholder="请描述资源" autocomplete="off"  id="source_des" class="layui-input source_des">
        </div>
    </div>

    <%--<div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <input type="checkbox" name="like[write]" title="写作">
            <input type="checkbox" name="like[read]" title="阅读">
            <input type="checkbox" name="like[daze]" title="发呆">
        </div>
    </div>--%>



    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="addSourceFun();">提交</button>
            <button type="reset" class="layui-btn layui-btn-normal" id="LAY-component-form-setval">重置</button>
            <%--<button type="button" class="layui-btn layui-btn-normal" id="LAY-component-form-getval">取值</button>--%>

        </div>
    </div>
</form>


<script src="./static/js/swiper-bundle.min.js"></script>
<script src="./static/layui/layui.all.js"></script>
<script src="./static/layui/layui.js"></script>
<script src="./static/js/jquery.js"></script>
<script src="static/js/sourceOperate.js"></script>
</body>
</html>
