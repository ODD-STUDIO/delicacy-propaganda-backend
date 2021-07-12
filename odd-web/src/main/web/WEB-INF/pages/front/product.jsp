<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <title>product</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/reset.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/front/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/front/js/js_z.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/front/plugins/FlexSlider/flexslider.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/front/plugins/FlexSlider/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/front/js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/thems.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/front/css/responsive.css">

</head>

<body>
<!--头部-->
<div class="header">
    <div class="head_bg">&nbsp;</div>
    <div class="head clearfix">
        <div class="logo"><a href="index"><img src="${pageContext.request.contextPath}/static/front/images/logo.png"
                                          alt="黑茶"/></a></div>
        <ul class="nav clearfix">
            <li><a href="/index">首页<span>HOME</span></a></li>
            <li><a href="/about">关于我们<span>ABOUT</span></a></li>
            <li class="now"><a href="/product">产品简介<span>PRODUCT</span></a></li>
            <li><a href="/join">加盟说明<span>JOIN</span></a></li>
            <li><a href="/store">门店资讯<span>STORE</span></a></li>
            <li><a href="/news">新闻中心<span>NEWS</span></a></li>
            <li><a href="/contact">联系我们<span>CONTACT</span></a></li>
        </ul>
        <div class="nav_m">
            <span class="n_icon">&nbsp;</span>
            <ul>
                <li><a href="/index">首页<span>HOME</span></a></li>
                <li><a href="about">关于我们<span>ABOUT</span></a></li>
                <li class="now"><a href="product">产品简介<span>PRODUCT</span></a></li>
                <li><a href="join">加盟说明<span>JOIN</span></a></li>
                <li><a href="store">门店资讯<span>STORE</span></a></li>
                <li><a href="news">新闻中心<span>NEWS</span></a></li>
                <li><a href="contact">联系我们<span>CONTACT</span></a></li>
            </ul>
        </div>
    </div>
</div>
<!--头部-->
<!--幻灯片-->
<div class="banner banner_s">
    <img src="${pageContext.request.contextPath}/static/front/upload/banner_a.jpg" alt=""/>
    <div class="jt">&nbsp;</div>
</div>
<!--幻灯片-->
<div class="box">
    <div class="pst">
        <p>PRODUCT</p>
        <span>产品简介</span>
        <div class="wz">当前位置：<a href="">首页</a>><a href="">产品简介</a></div>
    </div>
</div>
<div class="pro_lei">
    <div class="lei_bg">&nbsp;</div>
    <div class="lei_m clearfix">
        <div class="lei_ml">
            <p>Product<br/>description</p>
            <span>产品简介</span>
            <div class="line">&nbsp;</div>
        </div>
        <ul class="lei_mr clearfix">
            <c:forEach var="type" items="${goodCategory}">
                <li><a href="/product/1?id=${type.id}">${type.goodCategoryName}<em></em></a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="space_hx">&nbsp;</div>
<div class="pro_l">
    <div class="top">
        <div class="name">PRODUCT<br/>鲜泡单品茶系</div>
    </div>
    <ul class="p_list clearfix">
        <c:forEach var="good" items="${goods.data}">
            <li>
                <div class="p_m">
                    <div class="tu"><img src="http://img.afblog.love/${good.goodThumb}" alt=""/>
                    </div>
                    <div class="wen">
                        <div class="title">${good.goodName}</div>
                        <p>${good.goodDesc}</p>
                        <span class="more" onclick="getCarousel(${good.id})">MORE+</span>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
    <div class="page">
        <c:if test="${categoryId != null}">
            <a href="/product/${goods.pageNum - 1}?id=${categoryId}">上一页</a>
            <a href="/product/${goods.pageNum + 1}?id=${categoryId}">下一页</a>
        </c:if>
        <c:if test="${categoryId == null}">
            <a href="/product/${goods.pageNum - 1}">上一页</a>
            <a href="/product/${goods.pageNum + 1}">下一页</a>
        </c:if>
    </div>
</div>
<div class="space_hx">&nbsp;</div>
<div class="foot">
    <div class="foot_m clearfix">
        <div class="f_nav">
            <a href="">关于我们</a>
            <a href="">联系我们</a>
            <a href="">在线留言</a>
            <a href="">加入我们</a>
            <a href="">门店资讯</a>
        </div>
        <span>Copyright © 2007-2013 heicha.com All Rights Reserved</span>
        <div class="share">
            <span>分享到：</span>
            <a href=""><img src="${pageContext.request.contextPath}/static/front/images/icon1.png" alt=""/></a>
        </div>
    </div>
</div>
<div class="tck_bg">
    <div class="tck">
        <div class="close">&nbsp;</div>
        <div class="tck_m">
            <div class="slider">
                <div class="flexslider">
                   <ul class="slides" id="carousel">
<%--                        <li>--%>
<%--                            <img src="${pageContext.request.contextPath}/static/front/upload/pic3.png" alt=""/>--%>
<%--                            <div class="name">--%>
<%--                                <p class="ying">Hai Yan cheese</p>--%>
<%--                                <span><em>招牌</em>黑茶</span>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <img src="${pageContext.request.contextPath}/static/front/upload/pic3.png" alt=""/>--%>
<%--                            <div class="name">--%>
<%--                                <p class="ying">Hai Yan cheese</p>--%>
<%--                                <span><em>招牌</em>果茶</span>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <img src="${pageContext.request.contextPath}/static/front/upload/pic3.png" alt=""/>--%>
<%--                            <div class="name">--%>
<%--                                <p class="ying">Hai Yan cheese</p>--%>
<%--                                <span><em>经典</em>奶茶</span>--%>
<%--                            </div>--%>
<%--                        </li>--%>
                    </ul>
                </div>
            </div>
            <script>

               function getCarousel(id) {
                   $.ajax({
                       type: 'GET',
                       url: '/product/carousel',
                       data: {
                           id: id
                       },
                       dataType: 'json',
                       success: function (res) {
                           if (res.code === 200) {
                               $('.flexslider').flexslider({
                                   animation: "slide",
                               });
                               let str = ''
                               for (let i = 0; i < res.data.length; i++) {
                                   str = "<li><img src='http://img.afblog.love/"+res.data[i]+"' />" +
                                           "<div class='name'>" +
                                           "<p class='ying'>ODD</p>" +
                                           "<span><em>招牌</em></span>" +
                                           "</div>" +
                                           "</li>";

                                   $('.flexslider').data('flexslider').addSlide(str);
                               }

                               console.log(str)


                           }
                       }
                   })
               }


            </script>
        </div>
    </div>
</div>

<div style="text-align: center; position: fixed; bottom: 0; width: 100%; line-height: 150%; background: #f5f5f5; border-top: 1px solid #ddd;">
    <a style="color:blue" target="_blank" href=" https://ibaotu.com/ui/"> </a>
</div>
</body>
</html>
