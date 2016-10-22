<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>网上商城</title>
	</head>
	<frameset rows="14%,*" frameborder="1" framespacing="0" border="2px">
        <frame src="${pageContext.request.contextPath}/public/top.jsp" name="top" scrolling="no"/>
        <frameset cols="14%,*" frameborder="1" framespacing="0" border="2px">
        	<frame src="${pageContext.request.contextPath}/public/left.jsp" name="top" scrolling="no"/>
			<frame src="${pageContext.request.contextPath}/public/right.jsp" name="bottom" scrolling="yes"/>
    	</frameset>
    </frameset>
	<body>
	</body>
</html>