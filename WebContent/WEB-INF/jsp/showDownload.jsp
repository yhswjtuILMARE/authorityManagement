<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>下载页面</title>
	</head>
	<body style="text-align:center;">
		<table align="center" border="1" width="50%">
			<tr>
					<td>资源名称</td>
					<td>下载</td>
					<td>删除</td>
				</tr>
			<c:forEach var="list" items="${data.list}">
				<tr>
					<td>${list.filename }</td>
					<td><a href="${pageContext.request.contextPath}/DownloadServlet?id=${list.id}">下载</a></td>
					<td><a href="${pageContext.request.contextPath}/DeletServlet?id=${list.id}&method=download">删除</a></td>
				</tr>
			</c:forEach>
		</table><br/>
		<%@ include file="/WEB-INF/public/page.jsp" %>
	</body>
</html>