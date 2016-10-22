<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>注册中心</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
	</head>
	<body>
    	<div id="container">
        	<div id = "image">
            	<div id="context">用户注册</div>
        	<html:form action="/register">
            	<div id="table">
                	<table border="0" style="border-spacing:10px;">
                    	<tr>
                        	<td width="100px">用户名</td>
                            <td><html:text value="请输入3-8位英文或数字" property="username"></html:text></td>
                            <td><html:errors property="username"/></td>
                        </tr>
                        <tr>
                        	<td>密码</td>
                            <td><html:password property="password" redisplay="0"></html:password></td>
                            <td><html:errors property="password"/></td>
                        </tr>
                        <tr>
                        	<td>重复密码</td>
                            <td><html:password property="passtest" redisplay="0"></html:password></td>
                            <td><html:errors property="passtest"/></td>
                        </tr>
                        <tr>
                        	<td >性别</td>
                            <td>
                            	<html:radio style="margin-left:-15px;vertical-align:text-bottom;width:50px;height:15px;" property="gander" value="male"></html:radio>男
                            	<html:radio style="vertical-align:text-bottom;width:50px;height:15px;" property="gander" value="female"></html:radio>女
                            </td>
                            <td><html:errors property="gander"/></td>
                        </tr>
                        <tr>
                        	<td>您的邮箱</td>
                            <td><html:text property="email"></html:text></td>
                            <td><html:errors property="email"/></td>
                        </tr>
                        <tr>
                        	<td>您的生日</td>
                            <td><html:text property="birthday" onclick="SetDate(this,'yyyy-MM-dd')" readonly="readonly"></html:text></td>
                            <td><html:errors property="birthday"/></td>
                        </tr>
                        <tr>
                        	<td>您的昵称</td>
                            <td><html:text value="请输入3-8位英文或数字" property="nickname"></html:text></td>
                            <td><html:errors property="nickname"/></td>
                        </tr>
                        <tr></tr><tr></tr>
                        <tr>
                            <td colspan="2" align = "center" style="height:40px;">
                            	<html:submit value="提交" style="height:33px;width:110px;" styleId="button"></html:submit>
                            </td>
                        </tr>
                    </table>
                </div>
            </html:form>
            </div>
        </div>
	</body>
</html>