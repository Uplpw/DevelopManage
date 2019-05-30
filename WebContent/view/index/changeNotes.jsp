<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<jsp:useBean id="au" class="com.manage.bean.TB_AboutUs" scope="request"></jsp:useBean>
<title></title>
<link rel="stylesheet" href="view/index/layui/css/layui.css">
</head>
<body class="layui-layout-body">

	<script src="view/index/layui/layui.js"></script>
	<script>
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>

	<form class="layui-form"
		action="/DevelopManage-master/ChangeNotesServlet?type=changeA"
		method="post">
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label"><jsp:getProperty
					property="name" name="au" /></label>
			<div class="layui-input-block">
				<textarea rows="20" cols="80" style="resize: none"
					placeholder="请输入内容" class="layui-textarea" id="content"
					name="content"> <jsp:getProperty property="content"
						name="au" /> </textarea>


			</div>
			<jsp:setProperty property="content" name="au" />
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" type="submit">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>

			</div>
		</div>
	</form>
</body>
</html>
