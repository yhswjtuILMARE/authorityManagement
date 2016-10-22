<%@page import="Gloable.UploadType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>上传页面</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
			<table width="70%" align="center" border="1">
				<tr>
					<td>产品名称</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>产品分类</td>
					<td>
						<select name="type">
							<c:forEach var="enum" items="<%=UploadType.values() %>">
								<option value="${enum.type}">${enum.type}
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>添加照片</td>
					<td><input type="file" name="files"></td>
				</tr>
				<tr>
					<td>产品描述</td>
					<td><textarea rows="10" cols="40" name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</body>
</html>