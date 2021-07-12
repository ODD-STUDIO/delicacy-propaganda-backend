<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>

<head>
    <meta charset="UTF-8">
    <title>增加申请人</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/back/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/back/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/back/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/back/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>申请人
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="franchiseesName" lay-verify="required|name" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="franchiseesPhonenum" lay-verify="required|phoneNum" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>所在地址
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="franchiseesAddress" lay-verify="address" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">申请理由</label>
            <div class="layui-input-block">
                <textarea name="franchiseesReason" lay-verify="reason" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>

    </form>
</div>
<script>
    layui.use(['form',"layer"], function () {
        $ = layui.jquery;

        var form = layui.form
            ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            name: function(value){
                if(value.length > 20){
                    return '姓名不能超过20个字符';
                }
            },
            phoneNum: [/[0-9]{11}/,'联系方式只能为11个数字'],
            address: function(value){
                if(value.length > 64){
                    return '地址不能超过64个字符';
                }
            },
            reason: function(value){
                if(value.length > 255){
                    return '申请原因不能超过255个字符';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            //发异步，把数据提交给java
            $.ajax({
                type: "post",// 提交的http方法
                url: "/back/admin/join/add", // 提交到后端的接口
                data: data.field, // 提交到后端的数据
                dataType: "json", // 后端返回的数据
                success: function (res) { // 后端成功返回数据之后的回调
                    console.log("ababa");
                    if (res.code === 200){
                        console.log("121212");
                        layer.alert(res.msg, {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            // 刷新父级的表格
                            window.parent.location.reload()
                        });
                    }
                }
            })
            return false;
        });

    });
</script>

</body>

</html>