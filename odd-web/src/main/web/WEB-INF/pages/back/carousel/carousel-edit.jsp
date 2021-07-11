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
            <input type="hidden" name="id" value="${picture.id}">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>轮播跳转地址
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="url" value="${picture.url}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>轮播图状态
                </label>
                <div class="layui-input-inline">
                    <select name="status">
                        <option value="0" ${picture.status == 0 ? 'selected' : ''}>显示</option>
                        <option value="1" ${picture.status == 1 ? 'selected' : ''}>隐藏</option>
                        <option value="2" ${picture.status == 2 ? 'selected' : ''}>首页显示</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>轮播图分类
                </label>
                <div class="layui-input-inline">
                    <select name="type">
                        <option value="GOODS" ${picture.type == "GOODS" ? 'selected' : ''}>GOODS</option>
                        <option value="NEWS" ${picture.type == "NEWS" ? 'selected' : ''}>NEWS</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>关联ID
                </label>
                <div class="layui-input-inline">
                    <input type="text"  value="${picture.associateId}" name="associateId" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label  class="layui-form-label">
                    <span class="x-red">*</span>轮播排序
                </label>
                <div class="layui-input-inline">
                    <input type="number" value="${picture.orderNum}"  name="orderNum" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    数字越大越靠前
                </div>
            </div>
            <div class="layui-form-item">
                <label  class="layui-form-label">
                    <span class="x-red">*</span>轮播图片
                </label>
                <div class="layui-input-inline">
                    <div class="layui-upload-drag" id="up-btn">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将图片拖拽到此处</p>
                    </div>
                    <input type="hidden"  name="url" required=""  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                </label>
                <button  class="layui-btn" lay-filter="add" lay-submit="">
                    编辑
                </button>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                </label>
                <div class="layui-hide" id="thumb">
                    <hr>
                    <img src="" alt="上传成功后渲染" style="width: 600px">
                </div>
            </div>
        </form>
    </div>
<script>
        layui.use(['form','layer','upload'], function(){
            $ = layui.jquery;
            let form = layui.form, layer = layui.layer;
            let upload = layui.upload;

            //执行实例
            let uploadInst = upload.render({
                elem: '#up-btn', //绑定元素
                url: '/back/admin/carousel/upload', //上传接口
                accept: 'images',
                done: function (res) {
                    //上传完毕回调
                    if (res.code === 200){
                        layer.msg("上传成功")
                        layui.$("#thumb").removeClass('layui-hide').find('img').attr('src', 'http://img.afblog.love/'+res.data);
                        // 存放到隐藏域中，用于存放到数据库
                        $("input[name=url]").val(res.data);
                    }
                },
                error: function() {
                    //请求异常回调
                    layer.msg("上传失败！")
                }
            });


            //监听提交
            form.on('submit(add)', function(data){
                console.log(data.field);
                //发异步，把数据提交给java
                $.ajax({
                    type: "post",// 提交的http方法
                    url: "/back/admin/carousel/update", // 提交到后端的接口
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