<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../layui/css/layui.css">
<title>Insert title here</title>
</head>
<body>

	<div style="padding: 10px; background-color: #fff9ec">
		<div class="demoTable">
			搜索用户：
			<div class="layui-inline">
				<input class="layui-input" name="keyword" id="demoReload" autocomplete="off" placeholder="请在这里输入用户名哦">
			</div>
			<button class="layui-btn" data-type="reload">搜索</button>
		</div>
		<div style="width: auto;">
			<table id="table" lay-filter="dataTable"></table>
			<script type="text/html" id="bar">
  <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
			<script type="text/javascript" src="../layui/layui.js"></script>
			<script>
			layui.use('table', function() {
				var table = layui.table;
				table.render({
					elem : '#table',
					height : 400,
					url : '/DevelopManage-master/UserInfoServlet?type=customer', //数据接口
					page : true, //开启分页
					totalRow: true, //开启合计行
					toolbar: 'default' ,//开启工具栏，此处显示默认图标，可以自定义模板，详见文档
					even : true,
					skin : 'line',
					done : function(res, curr, count) { //表格数据加载完后的事件
						//调用示例
						layer.photos({//点击图片弹出
							photos : '.layer-photos-demo',
							anim : 1
						//0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
						});
						//如果是异步请求数据方式，res即为你接口返回的信息。
					},
					cols : [ [ //表头
					{
						type : 'checkbox',
                        fixed: 'left'
					}, {
						field : 'username',
						title : '用户名',
						width : 120,
						sort : true,
					}, {
						field : 'petName',
						title : '类别',
						width : 120,
						sort : true,
					}, {
						field : 'userPicture',
						unresize: true,
						title : '头像',
						width : 120,
						templet:function (d) {
	                        return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer;">
	                                      <img layer-pid="图片id，可以不写"  layer-src="/images/bug-success-bg.jpg" src="/images/bug-success-bg.jpg" alt="头像">
	                                    </div>`;
	                    },
						sort : true,
					}, {
						field : 'userTelephone',
						title : '电话号码',
						width : 120,
						sort : true,
					}, {
						field : 'userReal',
						title : 'userReal',
						width : 120,
						sort : true,
					}, {
						field : 'userCredit',
						title : '积分',
						sort : true,
					}] ]
				});
				table.on('toolbar(dataTable)', function(obj){
                    var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
                    switch(obj.event){
                      case 'add':
                        layer.alert('无权限！');
                      break;
                      case 'update':
                    	  layer.alert('无权限！');
                      break;
                      case 'delete':
                    	  layer.alert('无权限！');
                      break;
                    };
                  });
			});
		</script>
		</div>
	</div>
</body>
</html>