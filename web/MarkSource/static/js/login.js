var layer;
var $;
var popup;
layui.use(['layer', 'jquery'], function () {
    this.layer = layui.layer;
    this.$ = layui.$;
});

function loginFun() {
    popup = layer.open({
        type: 1,
        title: '新用户注册',
        closeBtn: 0,
        area: '500px',
        shadeClose: true,
        offset: '100px',
        anim: 1,
        content: `
<div class="prompt-text">
                <div class="layui-form-item">
                    <label  class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input   style="width: 300px;margin-top: 20px;" type="text" name="username" required placeholder="请输入用户名" autocomplete="off" class="layui-input user-name">
                </div>
                </div>
            </div>
                <div class="prompt-text">
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input  style="width: 300px;" type="password" name="password" id="password"  required placeholder="请输入密码" autocomplete="off" class="layui-input user-password">
                        </div>
                    </div>
                    
                    <div class="layui-form-item">
                         <label class="layui-form-label">确认密码</label>
                        <div class="layui-input-block">
                            <input  style="width: 300px;" type="password" name="password2" id="password2"  required placeholder="请再次确认密码" autocomplete="off" class="layui-input user-detpassword">
                        </div>
                    </div>
                </div>
            <div class="submit-style">
                <div class="layui-form-item">
                    <div class="layui-input-block ">
                        <button   style="display: inline-block;
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
    cursor: pointer" class="layui-btn layui-btn-warm" lay-submit lay-filter="fromDemo" onclick="registerClick();">注册</button>
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
    cursor: pointer" type="reset"  class="layui-btn" layui-btn-primary" onclick="resetClick();">重置</button>
                    </div>
                </div>
            </div>
`

    })
}
/*注册的方法*/
function registerClick() {
    var name = $(".user-name").val();
    var password = $(".user-password").val();
    var detpassword = $(".user-detpassword").val();
    /*var name1=name.replace(/[]/g," ");*/
    if (name.replace(/[ ]/g, " ") == "") {
        /*alert("用户名不能为空");*/
        layer.msg("用户名不能为空", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (password.replace(/[ ]/g, " ") == "") {
        layer.msg("密码不能为空", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (password !== detpassword) {
        layer.msg("两次密码不一致", {
            icon: 2,
            time: 2000
        });
        return;
    }
    var patt = /^\w{6,12}$/;
    if (patt.test(password.replace(/[ ]/g, " " == ""))) {
        layer.msg("输入密码不合法,密码必须6到12位，且不能出现空格", {
            icon: 2,
            time: 2000
        });
        return;
    }

    $.ajax({
        url: "/RegisterServlet",
        type: "POST",
        dataType: "json",
        data: {
            "name": name,
            "password": password
        },
        success: function (data) {
            var code = data.code;
            if (code == 200) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 2000
                }, function () {
                    layer.close(popup);
                });
            } else {
                layer.msg(data.msg, {
                    icon: 2,
                    time: 2000
                });
            }
        },
        error: function () {
            layer.msg("系统异常", {
                icon: 2,
                time: 2000
            });

        }
    });

}
/*注册的方法结束*/
/*$(function () {
       var msgs=$(".msg-input").val;
       if(msgs!=null&&msgs!="null"){
           layer.msg("msg",{
               icon:2,
               time:1000
           });

       }
   });*/
/*登录的方法开始*/
function loginClickFun() {
    var name = $(".login-name").val();
    var password = $(".login-password").val();
    if (name.replace(/[ ]/g, " ") == "") {
        /*alert("用户名不能为空");*/
        layer.msg("用户名不能为空", {
            icon: 2,
            time: 1000
        });
        return;
    }
    if (password.replace(/[ ]/g, " ") == "") {
        layer.msg("密码不能为空", {
            icon: 2,
            time: 1000
        });
        return;
    }
    var patt1= /^\w{6,12}$/;
    if (patt1.test(name.replace(/[ ]/g, ""))) {
        layer.msg('输入用户名不合法', {
            icon: 2,
            time: 1000
        }, function () {
            return;
        });
        return false;
    }
    var patt = /^\w{6,12}$/;
    if (patt.test(password.replace(/[ ]/g, ""))) {
        layer.msg('输入密码不合法', {
            icon: 2,
            time: 1000
        }, function () {
            return;
        });
        return false;
    }
    $(".login-form").submit();
    /*$.ajax({
        url: "/LoginServlet",
        type: "POST",
        dataType: "json",
        data: {
            "name": name,
            "password": password
        },
        success: function () {

        },
        error: function () {

        }
    });*/
}
/*登录的方法结束*/


/*重置的方法*/
function resetClick() {
    $(".user-name").val("");
    $(".user-password").val("");
    $(".user-detpassword").val("");
}