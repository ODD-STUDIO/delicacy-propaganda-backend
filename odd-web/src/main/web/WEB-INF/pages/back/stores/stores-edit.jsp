<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
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
            <input type="hidden" name="id" value="${store.id}">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>店铺名称
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="url" value="${store.store_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>店铺营业时间
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="url" value="${store.store_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>店铺地址
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="url" value="${store.store_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>店铺联系方式
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="url" value="${store.store_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>店铺状态
                </label>
                <div class="layui-input-inline">
                    <select name="status">
                        <option value="0" ${store.is_conceal == 0 ? 'selected' : ''}>显示</option>
                        <option value="1" ${store.is_conceal == 1 ? 'selected' : ''}>隐藏</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                </label>
                <button  class="layui-btn" lay-filter="add" lay-submit="">
                    编辑
                </button>
            </div>
        </form>
    </div>
<script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
            let form = layui.form, layer = layui.layer;
            //监听提交
            form.on('submit(add)', function(data){
                console.log(data.field);
                //发异步，把数据提交给java
                $.ajax({
                    type: "post",// 提交的http方法
                    url: "/back/admin/stores/update", // 提交到后端的接口
                    data: data.field, // 提交到后端的数据
                    dataType: "json", // 后端返回的数据
                    success: function (res) { // 后端成功返回数据之后的回调
                        if (res.code === 200){
                            layer.alert(res.msg, {icon: 6},function () {
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