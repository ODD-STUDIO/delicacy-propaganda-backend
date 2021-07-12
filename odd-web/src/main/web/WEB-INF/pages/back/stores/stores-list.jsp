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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/back/lib/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/back/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form">
          <div class="layui-form-item">
            <label class="layui-form-label">
              <span class="x-red"></span>店铺隐藏状态
            </label>
            <div class="layui-input-inline">
              <select name="is_conceal">
                <option value="0">显示</option>
                <option value="1">隐藏</option>
              </select>
            </div>
          </div>

          <button class="layui-btn" data-type="reload"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock class="deleteAll">
        <button class="layui-btn layui-btn-danger" data-type="getCheckData" ><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加店铺信息','/back/admin/stores/add',800,600)"><i class="layui-icon"></i>添加</button>
      </xblock>

      <table class="layui-table" id="data-table" lay-filter="data-table"></table>

    </div>
<script>

      let tableIns

      layui.use(['table', 'form'], function () {
        let table = layui.table;
        let form = layui.form;
        $ = layui.jquery;

        form.render()

        tableIns = table.render({
              elem: '#data-table',
              url: '/back/admin/stores/list',
              method: 'GET',
              page: true,
              limits: [5, 8, 10, 12],
              limit: 8,
              parseData: function (res) { //res 為原始返回的數據
                console.log(res)
                return {
                  "code": res.code, //解析接口狀態
                  "msg": res.msg, //解析提示文本
                  "count": res.data.totalElements, //解析數據總長度
                  "data": res.data.data //解析數據列表
                }
              },
              response: {
                statusCode: 200
              },
              cols: [[
                { type:'checkbox', fixed: 'left', style: 'height:50px'},
                { field: 'id', width: '5%', title: 'ID', sort: true },
                { field: 'store_name', width: '11%', title: '店铺名称', style: 'height: 50px' },
                { field: 'store_opentime', width: '10%', title: '店铺营业时间' },
                { field: 'store_address', width: '10%', title: '店铺地址' },
                { field: 'store_tele', width: '10%', title: '联系方式' },
                { field: 'is_conceal', width: '7%', title: '显示状态',templet:function (d){
                    let text;
                    let clazz;
                    console.log(d.is_conceal)
                    console.log(d.is_conceal === 1)
                    if (d.is_conceal === 1) {
                      text = '隐藏'
                      clazz = "layui-btn layui-btn-sm layui-btn-danger"
                    }
                    if (d.is_conceal === 0) {
                      text = '显示'
                      clazz = "layui-btn layui-btn-sm"
                    }
                    return "<span class='"+clazz+"'>"+text+"</span>";
                  }},
                { field: 'createTime', width: '10%', title: '创建时间', sort: true},
                { field: 'updateTime', width: '10%', title: '更新时间'},
                { fixed: 'right', title: '操作', width:'30%',style:'height:50px', toolbar:"#bar"}
              ]],
            });


        form.on('submit(search)', function (data) {
          tableIns.reload({
            method : 'get',
            where : data.field,
            page : {
              curr : 1
            }
          });
          return false;
        });


      //工具条事件
      table.on('tool(data-table)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）




         if (layEvent === 'is_conceal') { //查看
          // 改变状态
          let status
          if (data.is_conceal === 0) {
            status = 1
          }
          else if (data.is_conceal === 1) {
            status = 0
          }


          let id = data.id;

          // TODO 更新 删除
          $.ajax({
            type: "post",// 提交的http方法
            url: "/back/admin/stores/update/", // 提交到后端的接口
            data: {id: id, is_conceal: status}, // 提交到后端的数据
            dataType: "json", // 后端返回的数据
            success: function (res) { // 后端成功返回数据之后的回调
              if (res.code === 200) {
                // 刷新父级的表格
                tableIns.reload();
              }
            }
          });
        } else if (layEvent === 'del') { //删除
          layer.confirm('真的删除吗?', function (index) {
            //向服务端发送删除指令
            $.ajax({
              type: "delete",// 提交的http方法
              url: "/back/admin/stores/delete/" + data.id, // 提交到后端的接口
              dataType: "json", // 后端返回的数据
              success: function (res) { // 后端成功返回数据之后的回调
                if (res.code === 200) {
                  // 刷新父级的表格
                  tableIns.reload();
                  obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                  layer.close(index);

                }
              }
            });
          });
        } else if (layEvent === 'edit') { //编辑
          //do something
          // 需要打开编辑页面
          x_admin_show('编辑该店铺信息', '/back/admin/stores/update?id=' + data.id, 800, 600)

        } else if (layEvent === 'LAYTABLE_TIPS') {
          layer.alert('Hi，头部工具栏扩展的右侧图标。');
        }
      });

      var $ = layui.$, active = {
        getCheckData: function () { //获取选中数据
          var checkStatus = table.checkStatus('data-table')
                  , data = checkStatus.data;
          if (data.length === 0) {
            layer.msg("请至少选择一项！");
            return;
          }
          // 通过遍历获取id的数组
          let ids = [];
          $(data).each(function () {
            ids.push(this.id);
          })

          // 发送异步数据执行删除
          layer.confirm('真的删除吗?', function (index) {
            $.ajax({
              type: "post",// 提交的http方法
              url: "/back/admin/stores/delete/all", // 提交到后端的接口
              data: {ids: ids}, // 提交到后端的数据
              dataType: "json", // 后端返回的数据
              success: function (res) { // 后端成功返回数据之后的回调
                if (res.code === 200) {
                  // 刷新父级的表格
                  tableIns.reload();
                  layer.close(index);
                }
              }
            })
          });
        }
      }



      $('.deleteAll .layui-btn-danger').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
         });
      });


    </script>
    <script type="text/html" id="bar">
      <a class="layui-btn layui-btn-xs" lay-event="is_conceal">改变隐藏状态</a>
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

  </body>

</html>