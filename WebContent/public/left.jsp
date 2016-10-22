<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>top</title>
	</head>
	<style>
		.menu{
		margin-top:5px;
	}
	.div{
		margin-top:15px;
	}
	</style>
	<body style="text-align:left;">
		<div class="div">
			<div><p>用户管理</p></div>
			<div class="menu">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1&method=user" target="bottom">管理所有用户</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="div">
			<div><p>产品管理</p></div>
			<div class="menu">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1&method=download" target="bottom">管理所有产品</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/upload.do"  target="bottom">添加产品</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="div">
			<div><p>权限管理</p></div>
			<div class="menu">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1&method=priviledge" target="bottom">管理所有权限</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/priviledgeUI.do" target="bottom">添加权限</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1&method=url" target="bottom">为URL添加权限</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="div">
			<div><p>角色管理</p></div>
			<div class="menu">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1&method=role" target="bottom">管理所有角色</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/roleUI.do" target="bottom">添加角色</a>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>