<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost:8088" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息显示</title>
	</head>
	<body style="text-align:center;">
		<table border="1" align="center" width="70%">
			<tr>
				<td>用户名</td>
				<td>性别</td>
				<td>电子邮箱</td>
				<td>生日</td>
				<td>昵称</td>
				<td>操作</td>
			</tr>
			<c:forEach var="list" items="${data.list}">
				<tr>
					<td>${list.username}</td>
					<td>${list.gander}</td>
					<td>${list.email}</td>
					<td>${fn:DateFormat(list.birthday)}</td>
					<td>${list.nickname}</td>
					<td>
						<a href="${pageContext.request.contextPath}/DeletServlet?id=${list.username}&method=user">删除</a>
						<a href="${pageContext.request.contextPath}/userAuthorityUI.do?id=${list.username}">赋权</a>
					</td>
				</tr>
			</c:forEach>
		</table><br/>
		<%@ include file="/WEB-INF/public/page.jsp" %>
	</body>
</html>