<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色授权页面</title>
	</head>
	<body>
		<html:form action="/authority" >
			<html:hidden property="dest_id" value="${id}"/>
			<table width="50%" align="center" border="1">
				<tr>
					<td>角色名称</td>
					<td>${rolename }</td>
					<td></td>
				</tr>
				<tr>
					<td>权限列表</td>
					<td>
						<c:forEach var="item" items="${priviledge}">
							<html:checkbox  property="src_id" value="${item.id}"></html:checkbox>${item.priname }
						</c:forEach>
					</td>
					<td>
						<html:errors property="src_id"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><html:submit value="确认"></html:submit></td>
					<td></td>
				</tr>
			</table>
		</html:form>
	</body>
</html>