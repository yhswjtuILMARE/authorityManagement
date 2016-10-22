<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost:8088" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色信息显示</title>
	</head>
	<body style="text-align:center;">
		<table border="1" align="center" width="50%">
			<tr>
				<td>角色名称</td>
				<td>角色描述</td>
				<td>角色操作</td>
			</tr>
			<c:forEach var="list" items="${data.list}">
				<tr>
					<td>${list.rolename}</td>
					<td>${list.description}</td>
					<td>
						<a href="${pageContext.request.contextPath}/DeletServlet?id=${list.id}&method=role">删除</a>
						<a href="${pageContext.request.contextPath}/AuthorityUI.do?id=${list.id}&rolename=${list.rolename}">为角色授权</a>
					</td>
				</tr>
			</c:forEach>
		</table><br/>
		<%@ include file="/WEB-INF/public/page.jsp" %>
	</body>
</html>