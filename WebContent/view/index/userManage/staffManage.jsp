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
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
			<script type="text/javascript" src="../layui/layui.js"></script>
			<script type="text/javascript" src="../js/jquery-1.5.1.js"></script>
			<script>
            layui.use('table', function() {
                function open(a,data) {
                    layer.open({
                        type: 2,
                        title: '' +
                        '<li id="icon" class="layui-icon layui-icon-release layui-anim layui-anim-scaleSpring" ' +
                        'style="font-size: 30px; color: #009688;" data-anim="layui-anim-scaleSpring"></li> 编辑 ',
                        shadeClose: true,
                        shade: false,
                        maxmin: true, //开启最大化最小化按钮
                        area: ['470px', '600px'],//area: [window.screen.width / 2 + 'px', window.screen.height / 2 + 'px'], //宽高
                        content: "edit.jsp?tableOperation=" + a,
                        success: function(layero, index){ //成功打开frame之后的回调
                            var body = layer.getChildFrame('body',index);//建立父子联系
                            // 获取子页面的iframe
                            var iframe = window['layui-layer-iframe' + index];
                            // console.log(arr); //得到iframe页的body内容
                            // console.log(body.find('input'));
                            var inputList = body.find('input');
                            if (data!=null){
	                            var json=JSON.parse(JSON.stringify(data));
	                            for(let d in json){
	                                body.find('input[name="'+d+'"][type="text"],[type="hidden"]').val(json[d])
	                            }
	                        }
                            iframe.child(data);//调用子窗体的child方法
                        }
                    });                 
                }
                var table = layui.table;
                table.render({
                    elem : '#table',
                    url : '/DevelopManage-master/UserInfoServlet?type=staff', //数据接口
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
                        title : '姓名',
                        width : 120,
                        sort : true,
                    }, {
                        field : 'petName',
                        title : '类别',
                        sort : true,
                        width : 120
                    }, {
                        field : 'userPicture',
                        unresize: true,
                        title : '头像',
                        templet:function (d) {
                            return `<div class="layer-photos-demo" style="cursor:pointer;">
                                          <img layer-pid="图片id，可以不写"  layer-src="/images/bug-success-bg.jpg" src="/images/bug-success-bg.jpg" alt="头像">
                                        </div>`;
                        },
                        sort : true,
                        width : 120
                    }, {
                        field : 'userTelephone',
                        title : '电话号码',
                        sort : true,
                        width : 120
                    }, {
                        field : 'userReal',
                        title : 'userReal',
                        sort : true,
                        width : 120
                    }, {
                        field : 'operation',
                        title : '操作',
                        toolbar : "#bar"
                    } ] ]
                });
                var ldd;
                table.on('toolbar(dataTable)', function(obj){
                    var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
                    switch(obj.event){
                      case 'add':
                        layer.msg('添加');
                        open("add");
                      break;
                      case 'update':
                        if(data.length === 0){
                          layer.msg('请选择一行');
                        } else if(data.length > 1){
                          layer.msg('只能同时编辑一个');
                        } else {
                        	open("edit",data[0]);
                        }
                      break;
                      case 'delete':
                        if(data.length === 0){
                          layer.msg('请选择一行');
                        } else {
                        	layer.confirm('确定要删除Ta么',function(){
                        		for (var i = 0;i < data.length; i++){
                        			$.ajax({
                                        url : '/DevelopManage-master/UserInfoServlet?type=staff&operation=del',  //提交删除信息
                                        type : 'post',
                                        async : false,
                                        data : {
                                            map : JSON.stringify(data[i])
                                        },
                                        dataType : 'json',
                                        async : false,
                                        success : function(json) { //回调json
                                            if (json["code"] == 0) {
                                                layer.msg('操作成功....', {
                                                    icon : 6
                                                });
                                                setTimeout(function() {
                                                    table.reload('table');
                                                }, 0);
                                            } else {
                                                layer.msg('操作失败', {
                                                    icon : 5
                                                });
                                            }  
                                        },
                                        error : function() {
                                            layer.alert("网络忙，请稍后重试！");
                                        },
                                        complete : function() {
                                            layer.closeAll('loading');
                                        }
                                    });
                        		}
                        	});
                        }
                      break;
                  };
                });
                  table.on('tool(dataTable)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                        var data = obj.data; //获得当前行数据
                        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                        var tr = obj.tr; //获得当前行 tr 的DOM对象
                        if (layEvent === 'del') { //删除
                            layer.confirm('真的要删除Ta吗', function(index) {
                                layer.close(index);
                                //向服务端发送删除指令
                                $.ajax({
                                    url : '/DevelopManage-master/UserInfoServlet?type=staff&operation=del',  //提交删除信息
                                    type : 'post',
                                    async : false,
                                    data : {
                                        map : JSON.stringify(data)
                                    },
                                    dataType : 'json',
                                    async : false,
                                    success : function(json) { //回调json
                                        if (json["code"] == 0) {
                                        	obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                            layer.msg('操作成功....', {
                                                icon : 6
                                            });
                                            setTimeout(function() {
                                                parent.layer.close(index);
                                                parent.layui.table
                                                        .reload('table');
                                            }, 0);
                                        } else {
                                            layer.msg('操作失败', {
                                                icon : 5
                                            });
                                        }
                                    },
                                    error : function() {
                                        layer.alert("网络忙，请稍后重试！");
                                    },
                                    complete : function() {
                                        layer.closeAll('loading');
                                    }
                                });
                            });
                        } else if (layEvent === 'edit') { //编辑
                            open("edit",data);
                        }
                    }); 
            });
        </script>
		</div>
	</div>
</body>
</html>