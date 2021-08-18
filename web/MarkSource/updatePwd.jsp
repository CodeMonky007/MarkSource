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
    <title>密码修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./static/layui/css/layui.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
    <legend>密码修改</legend>
</fieldset>

<form class="layui-form form1" action="" lay-filter="example" name="form1" style="width:500px;height:400px;margin: 20px auto;">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入账号" id="username" class="layui-input username">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">原密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入原密码" autocomplete="off"  id="password" class="layui-input password">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-block">
            <input type="password" name="new_password" placeholder="请输入新密码" autocomplete="off"  id="new_password" class="layui-input new_password">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="updatePwd();">提交修改</button>
            <button type="reset" class="layui-btn layui-btn-normal" id="LAY-component-form-setval">重置</button>
        </div>
    </div>
</form>
<script>
    function updatePwd() {
        var username= $('.username').val();
        var new_password = $('.new_password').val();
        var password = $('.password').val();
        if (username.replace(/[]/g, "") == "") {
            layer.msg("账号不能为空", {
                icon: 2,
                time: 2000
            });
            return;
        }
        if (password.replace(/[]/g, "") == "") {
            layer.msg("原密码不能为空", {
                icon: 2,
                time: 2000
            });
            return;
        }
        if (new_password.replace(/[]/g, "") == "") {
            layer.msg("新密码不能为空", {
                icon: 2,
                time: 2000
            });
            return;
        }
        $.ajax({
            url: '/Update_pwdServlet',
            type: "GET",
            dataType: "json",
            data: {
                "username": username,
                "new_password": new_password,
                "password":password
            },
            success: function (data) {
                var code = data.code;
                if (code == 200) {
                    layer.msg(data.msg, {
                        icon: 1,
                        time: 2000
                    }, function () {
                        window.location.href = "updatePwd.jsp";
                    })
                } else {
                    layer.msg(data.msg, {
                        icon: 1,
                        time: 2000
                        //2秒关闭(如果不配置，默认是3秒)
                    });
                }
            },
            error: function () {
                layer.msg("系统异常", {
                    icon: 2,
                    time: 2000 //2秒关闭 (如果不配置，默认是3秒)
                });
            }
        });
    }
</script>
<script src="./static/js/jquery.js"></script>
<script src="./static/js/swiper-bundle.min.js"></script>
<script src="./static/layui/layui.all.js"></script>
<script src="./static/layui/layui.js"></script>


<%--<script src="static/js/sourceOperate.js"></script>--%>
</body>
</html>
