<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>首页</title>
        <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
        <script>
			$(document).ready(function(e) {
                $("#word").animate({
					fontSize:'36px',
					marginTop:'9px',
					marginLeft:'50px'
					},"slow");
				$("#top button").animate({
					width:'130px',
					height:'35px',
					borderRadius:'5px',
					marginRight:'20px',
					marginLeft:'10px',
					marginTop:'10px'
					},"slow");
            });
			function login(){
				window.location.href="/bookstore/LoginUI";
			}
			function register(){
				window.location.href="/bookstore/RegisterUI.do";
			}
			function mangage(){
				window.location.href="/bookstore/ManagerServlet";
			}
			function cancel(){
				window.location.href="/bookstore/RemoveSession";
			}
			function message(but){
				var str = but.innerHTML;
				but.innerHTML = "Welcome";
				but.onmouseout=function(){
					but.innerHTML=str;
				}
			}
        </script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/body.css">
    </head>
    <body>
    	<div id="container">
        	<div id="top">
            	<div id="word">IL MARE</div>
                <div>
                	<c:if test="${user == null}">
                		<button onclick="login()">LOGIN</button>
                		<button onclick="register()">REGISTER</button>
					</c:if>
                	<c:if test="${user != null}">
                		<button onmouseover="message(this)">欢迎您，${user.nickname}${user.gander=="male"?"先生":"女士"}</button>
						<button onclick="cancel()">CANCEL</button>
					</c:if>
                    <button onclick="mangage()">MANAGE</button>
                </div>
            </div>
        	<div id="bottom">
            	<div id="img">
            		
                </div>
            </div>
        </div>
    </body>
</html>