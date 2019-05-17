<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title></title>
	<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
		<div class="layui-header">
        <div class="layui-logo">网上订餐后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
		
		<!--header 左侧显示导航栏-->
        <ul class="layui-nav layui-layout-left">
        </ul>
		
		<!--header 右侧显示导航栏-->
        <ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					lpw
				</a>
				<dl class="layui-nav-child">
					<dd><a href="">基本资料</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="login.jsp" target="_top">登陆</a></li>
			<li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
		</div>
      
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
			  
            <li class="layui-nav-item layui-nav-itemed">
				<a class="" href="javascript:;">菜单管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;" >菜单查询</a></dd>
					<dd><a href="javascript:;">菜单添加</a></dd>
					<dd><a href="javascript:;">菜单修改</a></dd>
					<dd><a href="javascript:;">菜单删除</a></dd>
				</dl>
            </li>
			
            <li class="layui-nav-item">
				<a href="javascript:;">菜单分类管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;">菜单分类查询</a></dd>
					<dd><a href="javascript:;">菜单分类添加</a></dd>
					<dd><a href="javascript:;">菜单分类修改</a></dd>
					<dd><a href="javascript:;">菜单分类删除</a></dd>
				</dl>
            </li>
			
            <li class="layui-nav-item">
				<a href="javascript:;">餐厅公告管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;">添加新公告</a></dd>
					<dd><a href="javascript:;">显示餐厅公告</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a href="javascript:;">系统用户管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;">查询用户</a></dd>
					<dd><a href="javascript:;">添加新用户</a></dd>
					<dd><a href="javascript:;">删除用户</a></dd>
				</dl>
			</li>
          </ul>
        </div>
      </div>
      
      <div class="layui-body" >
		  <iframe id="option1" name="option1" src="" style="overflow: visible;" 
								scrolling="no" frameborder="no" width="100%" height="100%">
		  </iframe>
      </div>
      
      <div class="layui-footer">
        <h4 style="text-align: center;">Copyright © 2019.Company Agile All rights reserved</h4>
      </div>
    </div>
<script src="layui/layui.js"></script>
<script>
    layui.use('element', function(){
      var element = layui.element;
      
    });
</script>
</body>
</html>
          