		<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<a href="${pageContext.request.contextPath}/ShowDataServlet?page=1">首页</a>
		<c:if test="${data.currentPage - 1 >=1 }">
			<a href="${pageContext.request.contextPath}/ShowDataServlet?page=${data.currentPage-1}">上一页</a>
		</c:if>
		<c:forEach var="num" begin="${data.startPage}" end="${data.endPage}" step="1">
			<a href="${pageContext.request.contextPath}/ShowDataServlet?page=${num}">${num}</a>
		</c:forEach>
		<c:if test="${data.currentPage +1 <= data.totalPage}">
			<a href="${pageContext.request.contextPath}/ShowDataServlet?page=${data.currentPage+1}">下一页</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/ShowDataServlet?page=${data.totalPage}">尾页</a>
		共有${data.totalRecord}条记录