<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>用户登陆中心</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
	</head>
	<body>
	    	<div id = "container">
	        	<div id="top">
	            	<div id="top-1">
	            		<a id="" target="_blank" href="http://dean.swjtu.edu.cn/">教务首页</a>
	                	<a id="lonno" target="_blank" href="http://202.115.71.132/help/Frame.jsp?sid=109&SmallTypeID=23&BigTypeID=7&SetAction=View">无法登录？</a>
	                	<a id="" target="_blank" href="http://202.115.71.132/help/Frame.jsp?sid=110&SmallTypeID=23&BigTypeID=7&SetAction=View">最佳体验</a>
	                	<a id="" target="_blank" href="http://202.115.67.50/service/userset.jsp">忘记密码？</a>
	                </div>
	            </div>
	            <div id="middle">
	            	<div id="image">
	                <form action="${pageContext.request.contextPath }/login.do" method="post">
		                	<div id="image-1">
		                		<input type="text" name="username"/>
		                    	<input type="password" name="password"/>
		                    </div>
		                    <div id="image-2">
		                    	<input type="radio" name="lo" value="c" checked="checked"/>中文版
		                        <input type="radio" name="lo" value="e"/>English Version (Beta)
		                    </div>
		                    <div id="image-3">
		                    	<input id="but1" type="submit" value="" />
		                        <input id="but2" type="button" />
		                    </div>
		              </form>
		                    <div id="image-4">您是新生吗？第一次使用教务系统，点击<a target="_blank" href="http://jiaowu.swjtu.edu.cn/service/userset.jsp">账号初始设置</a>。</div>
	                </div>
	            </div>
	            <div id="bottom">
	            </div>
	        </div>
	</body>
</html>