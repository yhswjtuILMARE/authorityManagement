<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色管理页面</title>
	</head>
	<body>
		<html:form action="/role">
			<table width="70%" align="center" border="1">
				<tr>
					<td>角色名称</td>
					<td><html:text property="rolename"></html:text></td>
					<td><html:errors property="rolename"/></td>
				</tr>
				<tr>
					<td>角色描述</td>
					<td><html:textarea rows="10" cols="40" property="description"></html:textarea></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><html:submit value="提交"></html:submit></td>
					<td></td>
				</tr>
			</table>
		</html:form>
	</body>
</html>