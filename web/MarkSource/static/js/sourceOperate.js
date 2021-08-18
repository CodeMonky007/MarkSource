function addSourceFun() {
    var source_type = $(".source_type").val();
    var source_link = $(".source_link").val();
    var source_des = $(".source_des").val();
    var source_location = $("input[type='radio']:checked").val();

    /* if (source_type.replace(/[ ]/g, "") == "") {
         layer.msg("资源类别不能为空", {
             icon: 2,
             time: 5000
         });
         return;
     }*/
    if (source_link.replace(/[ ]/g, "") == "") {
        layer.msg("资源链接不能为空", {
            icon: 2,
            time: 1000
        });
        return;
    }
    if (source_des.replace(/[ ]/g, "") == "") {
        layer.msg("资源描述不能为空", {
            icon: 2,
            time: 1000
        });
        return;
    }
    $.ajax({
        //这里的url有一个要点：前面容易漏掉斜杠
        url: "/addSourceServlet",
        type: "GET",
        dataType: "json",
        data: {
            "source_type": source_type,
            "source_des": source_des,
            "source_link": source_link,
            "source_location": source_location
        },
        success: function (data) {
            if (data.code == 200) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 2000
                }, function () {

                    window.location.href = "addSource.jsp";
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

layui.use('table', function () {
    var table = layui.table;


    table.render({
        elem: '#source-list'
        , url: '/selectSourceServlet'
        , type: 'GET'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print'],
        height: '300px'
        , title: '用户数据表'
        , page: true
        , skip: true
        , id: 'source-list'
        , cols: [[
            /*{type: 'checkbox', fixed: 'left'}*/
            /*{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true},*/
            {field: 'source_id', title: 'ID', width: 80, align: 'center'},
            {field: 'source_type', title: '资源类型', width: 196, align: 'center'},
            {field: 'source_des', title: '资源描述', width: 290, align: 'center'},
            {field: 'source_link', title: '资源链接', width: 312, align: 'center'},
            /* {field: 'create_time', title: '资源创建时间', width: 100, align: 'center'},*/
            {field: 'source_location', title: '资源定位', width: 113, align: 'center'},
            /*{field: 'right', width: 290, title: '操作', align: 'center', toolbar: '#source_oper'}*/
            {fixed: 'right', title: '操作', toolbar: '#source_oper', width: 290, align: 'center'}
        ]]
    });

    var $ = layui.$, active = {
        reload: function () {
            /*var source_type = $('#source_type');*/
            /* var param2 = $('#param2');*/

            //执行重载
            table.reload('source-list', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    key: $('#source_type').val()
                }
            }, 'data');
        }
    };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    layui.use('laypage', function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: '#demo11'
            , count: 70 //数据总数，从服务端得到
            , jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数

                //首次不执行
                if (!first) {
                    //do something
                }
            }
        });
    });


    //头工具栏事件
    table.on('tool(source-list)', function (obj) {
        var data = obj.data
            , layEvent = obj.event;
        if (layEvent == 'update') {
            layer.open({
                type: 1,
                title: '信息修改',
                skin: 'layui-layer-demo',
                area: '420px',
                anim: 2,
                shadeClose: true,
                content: `
    <input type="hidden" name="source_id" value="` + data.source_id + `" class="source_id">
        <div class="layui-form-item" style="margin-top: 35px;">
        <label class="layui-form-label">资源类型</label>
        <div class="layui-input-inline">
    <input  type="text" name="source_type" style="width: 250px;" required lay-verify="required" 
    value="` + data.source_type + `" autocomplete="off" class="layui-input source_type" >
           </div>
</div>

  
  <div class="layui-form-item">
<label class="layui-form-label">资源描述</label>
<div class="lavui-input-inline">
  <input type="text"  style="width: 250px;" name="source_des" required lay-verify="required"
value="` + data.source_des + `" autocomplete="off" class="layui-input source_des" >
   </div>
  </div>
  
<div class="layui-form-item">
<label class= "layui-form-label">资源链接</label>
<div class="layui-input-inline">
<input type="text" name="source_link" style="width: 250px;" required lay-verify="required"
  value="` + data.source_link + `" autocomplete="off" class="layui-input source_link"></div>
</div>
        
<div class="layui-form-item">
<div class="layui-input-block">
<button style="margin:5px 0 0 20%;" class="layui-btn" lay-submit onclick="update_netSource();">修改提交</button>
</div>
</div>`
            })
        } else if (layEvent == 'del') {
            layer.confirm("真的删除吗?", function (index) {
                /*obj.del();*/
                $.ajax({
                    url: '/del_netSourceServlet',
                    type: 'GET',
                    dataType: "json",
                    data: {"source_id": data.source_id},
                    success: function (data) {
                        var code = data.code;
                        if (code == 200) {
                            layer.msg(data.msg, {
                                icon: 1,
                                time: 500
                            }, function () {
                                window.location.href = "manage_netSource.jsp";
                            });
                        } else {
                            layer.msg(data.msg, {
                                icon: 2,
                                time: 2000//2秒关闭（如果不配置，默认是3秒)});
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
            })
        }
    });
});


function update_netSource() {
    var source_id = $(".source_id").val();
    var source_type = $(".source_type").val();
    var source_des = $(".source_des").val();
    var source_link = $(".source_link").val();
    if (source_type.replace(/[ ]/g, "") == "") {
        layer.msg("资源类型不能为空", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (source_des.replace(/[ ]/g, "") == "") {
        layer.msg("资源描述不能为空", {
            icon: 2,
            time: 2000
        });
        return;
    }
    if (source_link.replace(/[]/g, "") == "") {
        layer.msg("资源链接不能为空", {
            icon: 2,
            time: 2000
        });
        return;
    }
    $.ajax({
        url: "/update_netSourceServlet",
        type: "GET",
        dataType: "json",
        data: {
            "source_id": source_id,
            "source_type": source_type,
            "source_des": source_des,
            "source_link": source_link
        },
        success: function (data) {
            var code = data.code;
            if (code == 200) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 500
                }, function () {
                    window.location.href = "manage_netSource.jsp";
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