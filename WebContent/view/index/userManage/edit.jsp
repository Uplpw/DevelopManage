<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="../js/jquery-1.5.1.js"></script>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
	<%
		String tableOperation = request.getParameter("tableOperation");
		if (tableOperation == null) {

		} else { 
	%>
	<fieldset class="layui-elem-field layui-field-title ">
		<legend>
			<li id="icon" class="layui-icon layui-icon-face-smile layui-anim layui-anim-rotate " style="font-size: 30px; color: #1E9FFF;" data-anim="layui-anim-rotate"></li> <span style="font-size: 8px">我在等风，也在等你</span>
		</legend>
		<br>
		<div class="layui-field-box" style="width: 97%">
			<form class="layui-form" action="" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名 :</label>
					<div class="layui-input-block">
						<input type="text" name="username" <%if ("edit".equals(tableOperation)) {%> disabled="disabled" value="<%;%>" <%}%> autocomplete="off" class="layui-input">
						<div class="layui-form-mid layui-word-aux">这里是用户名，不能重复的</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类别 :</label>
					<div class="layui-input-block">
						<input type="text" name="petName" lay-verify="petName" autocomplete="off" placeholder="请输入名称" class="layui-input">
						<div class="layui-form-mid layui-word-aux">这里填类别</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">头像 :</label>
					<div class="layui-input-block">
						<button type="button" class="layui-btn" name="userPicture" id="userPicture">
							<i class="layui-icon">&#xe67c;</i>上传图片
						</button>
						<!-- <input type="text" name="userPicture" placeholder="请输入class" autocomplete="off" class="layui-input"> -->
						<div class="layui-form-mid layui-word-aux"></div>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号 :</label>
					<div class="layui-input-block">
						<input type="text" name="userTelephone" lay-verify="userTelephone" placeholder="请输入排序" autocomplete="off" class="layui-input">
						<div class="layui-form-mid layui-word-aux">这里是手机号</div>
					</div>
				</div>
				<br> <br>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>

	</fieldset>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script type="text/javascript" src="../layui/layui.js"></script>
	<script>
	window.onload = function () {
		layui
        .use(
            [ 'form', 'layedit', 'laydate' ],
            function() {
                var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
                //自定义验证规则  对应：lay-verify="menuSort"
                form.verify({
                    petName : function(value) {
                        if (value.length < 1) {
                            $("#icon").removeClass(
                                "layui-icon-face-smile");
                            $("#icon").addClass(
                                "layui-icon-face-cry")
                            return '类别至少得1个字符啊';
                        }
                    },
                    userTelephone : [ /^1[34578]\d{9}$/, '必需为11位数字' ]
                });
    
                //注意：parent 是 JS 自带的全局对象，可用于操作父页面
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                //监听提交
                form.on('submit(formDemo)', function(data) {
                    layer.load();
                    $.ajax({
                        url : '/DevelopManage-master/UserInfoServlet?type=staff&operation=' + '<%=tableOperation%>', //提交信息
                        type : 'post',
                        async : false,
                        data : {
                            map : JSON.stringify(data.field)
                        },
                        dataType : 'json',
                        async : false,
                        success : function(json) {
                            if (json["code"] == 0) {
                                layer.msg('操作成功....', {
                                    icon : 6
                                });
                                setTimeout(function() {
                                    parent.layer.close(index);
                                    parent.layui.table
                                        .reload('table');
                                }, 20);
                            } else if(json["code"] == -2) {
                                layer.msg('用户名重复啦！', {
                                    icon : 5
                                });
                            }else{
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
                    return false;
                });
            });

        console.log(layui);
        alert(1);
        console.log(document.getElementById("userPicture"));
        document.getElementById("userPicture").onClick = function(){  
        	alert(2);
            layui.use('upload', function() { //上传图片
            var upload = layui.upload;
            //执行实例
            var uploadInst = upload.render({
                elem : '#userPicture' //绑定元素
                ,
                url : '/UploadPicServlet' //上传接口
                ,
                done : function(res) {
                    //上传完毕回调
                    alert(1);
                },
                error : function() {
                    //请求异常回调
                }
            });
        });
        };
	}
    function child(data) {
    }
	</script>
	<%
		}
	%>
</body>
</html>
