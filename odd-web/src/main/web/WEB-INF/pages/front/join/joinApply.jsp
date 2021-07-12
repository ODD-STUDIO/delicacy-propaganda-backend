<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<title>join</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/reset.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/front/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/front/js/js_z.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/front/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/back/lib/layui/layui.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/thems.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/responsive.css">

</head>

<body>
<!--头部-->
<div class="header">
	<div class="head_bg">&nbsp;</div>
    <div class="head clearfix">
        <div class="logo"><a href="index"><img src="${pageContext.request.contextPath}/static/front/images/logo.png" alt="黑茶"/></a></div>
        <ul class="nav clearfix">
            <li><a href="index">首页<span>HOME</span></a></li>
            <li><a href="about">关于我们<span>ABOUT</span></a></li>
            <li><a href="product">产品简介<span>PRODUCT</span></a></li>
            <li class="now"><a href="">加盟说明<span>JOIN</span></a></li>
            <li><a href="store">门店资讯<span>STORE</span></a></li>
            <li><a href="news">新闻中心<span>NEWS</span></a></li>
            <li><a href="contact">联系我们<span>CONTACT</span></a></li>
        </ul>
        <div class="nav_m">
        	<span class="n_icon">&nbsp;</span>
            <ul>
            	<li><a href="index">首页<span>HOME</span></a></li>
                <li><a href="about">关于我们<span>ABOUT</span></a></li>
                <li><a href="product">产品简介<span>PRODUCT</span></a></li>
                <li class="now"><a href="">加盟说明<span>JOIN</span></a></li>
                <li><a href="store">门店资讯<span>STORE</span></a></li>
                <li><a href="news">新闻中心<span>NEWS</span></a></li>
                <li><a href="contact">联系我们<span>CONTACT</span></a></li>
            </ul>
        </div>
    </div>
</div>
<!--头部-->
<!--幻灯片-->
<%--<div class="banner banner_s">--%>
<%--	<img src="${pageContext.request.contextPath}/static/front/upload/banner_c.jpg" alt=""/>--%>
<%--    <div class="jt">&nbsp;</div>--%>
<%--</div>--%>
<!--幻灯片-->
<div class="box">
	<div class="pst">
    	<p>JOIN APPLICATION</p>
        <span>申请加盟</span>
        <div class="wz">当前位置：<a href="/index">首页</a>><a href="/join/apply">申请加盟</a></div>
    </div>
</div>
<div class="space_hx">&nbsp;</div>
<div class="t_box">
    <a href="/join">加盟条件<em>></em></a>
    <a href="/join/advantage">加盟优势<em>></em></a>
    <a href="/join/flow">加盟流程<em>></em></a>
    <a href="/join/apply" class="now">申请加盟<em>></em></a>
</div>
<div class="space_hx">&nbsp;</div>
<div class="join">
    <form class="layui-form" style="height: 60%">
        <div class="layui-form-item" style="height: 15%;">
            <label class="layui-form-label">
                <span class="x-red">*</span>申请人
            </label>
            <div class="layui-input-inline">
                <input type="text" id="franchiseesName" name="franchiseesName" lay-verify="required|name" style="height: 40%; width: 20%" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="height: 15%">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="franchiseesPhonenum" name="franchiseesPhonenum" lay-verify="required|phoneNum" style="height: 40%; width: 30%" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="height: 15%">
            <label class="layui-form-label">
                <span class="x-red"></span>所在地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="franchiseesAddress" name="franchiseesAddress" lay-verify="address" style="height: 40%; width: 50%" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text"  style="height: 45%">
            <label class="layui-form-label">申请理由</label>
            <div class="layui-input-block">
                <textarea style="height: 40%; width: 60%" id="franchiseesReason" name="franchiseesReason" lay-verify="reason" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item" style="height: 10%">
            <label class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" style="height: 100%; width: 10%" lay-submit="">
                申请加盟
            </button>
        </div>

    </form>

<%--	<div class="ye1">&nbsp;</div>--%>
<%--    <div class="ye2">&nbsp;</div>--%>
    <dl class="clearfix">
<%--    	<dt><img src="${pageContext.request.contextPath}/static/front/upload/map.jpg" alt=""/></dt>--%>


    </dl>
</div>
<div class="space_hx">&nbsp;</div>
<div class="foot">
	<div class="foot_m clearfix">
    	<div class="f_nav">
            <a href="/about">关于我们</a>
            <a href="/contact">联系我们</a>
            <a href="">在线留言</a>
            <a href="/join">加入我们</a>
            <a href="/store">门店资讯</a>
        </div>
        <span>Copyright © 2007-2013 heicha.com All Rights Reserved</span>
        <div class="share">
        	<span>分享到：</span>
            <a href=""><img src="${pageContext.request.contextPath}/static/front/images/icon1.png" alt=""/></a>
        </div>
    </div>
</div>
<script>
$(function(){
})
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
        console.log(data.field);
        $.ajax({
            type: "post",// 提交的http方法
            url: "/front/admin/join/add", // 提交到后端的接口
            data: data.field, // 提交到后端的数据
            dataType: "json", // 后端返回的数据
            success: function (res) { // 后端成功返回数据之后的回调
                if (res.code === 200){
                    layer.msg("提交成功");
                    $('#franchiseesName').val('');
                    $('#franchiseesPhonenum').val('');
                    $('#franchiseesAddress').val('');
                    $('#franchiseesReason').val('');
                }
            }
        })
        return false;
    });

});

</script>
<div style="text-align: center; position: fixed; bottom: 0; width: 100%; line-height: 150%; background: #f5f5f5; border-top: 1px solid #ddd;"> <a style="color:blue" target="_blank" href=" https://ibaotu.com/ui/"> </a>
	</div>
</body>
</html>
