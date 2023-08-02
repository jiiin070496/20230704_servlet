<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h2>학과 리스트</h2>
	
	<div>
		<form action="<%=request.getContextPath()%>/dept/get" method="get">
			학과 번호: <input type="text" name="departmentNo"><br>
			<input type="submit" value="찾기">
		</form>
	</div>
<%-- 	
 	[${deptList }]
	<table border="1">
		<tr>
			<td>학과 번호</td>
			<td>학과 이름</td>
			<td>계열</td>
			<td>개설여부</td>
			<td>정원</td>
		</tr>
	</table>  
--%>

	<c:choose>
		<c:when test="${empty deptList }">
			<h2>결과 없습니다.</h2>
		</c:when>
	<c:otherwise>
		<table border="1">
		<tr>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>계열</td>
			<td>개설여부</td>
			<td>정원</td>
		</tr>
	<c:forEach items="${deptList }" var="item">
		<tr>
			<td>
			<a href="<%=request.getContextPath()%>/dept/get?departmentNo=${item.departmentNo } %>">
			${item.departmentNo }
			</a></td>
			<td>
			<a href="<%=request.getContextPath()%>/dept/get?departmentNo=${item.departmentNo }">
			${item.departmentName }
			</a>
			</td>
			<td>${item.category}</td>
			<td>${item.openYn }</td>
			<td>${item.capacity }</td>
		</tr>
	</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
</body>
</html>