<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 상세 정보</title>
</head>
<body>
	<h1>학과 상세 정보입니다</h1>
	<% 
	DepartmentVo vo = null;
	if(request.getAttribute("dvo") instanceof DepartmentVo){
		vo = (DepartmentVo)request.getAttribute("dvo");
	}
	%>
	
	<table border = "1">	
		<tr>
			<td>과번호</td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
		<tr>
			<td>학과이름</td>
			<td><%=vo.getDepartmentName() %></td>
		</tr>
		<tr>
			<td>학과분류</td>
			<td><%=vo.getCategory() %></td>
		</tr>
		<tr>
			<td>개강여부</td>
			<td><%=vo.getOpenYn() %></td>
		</tr>
		<tr>
			<td>인원수</td>
			<td><%=vo.getCapacity() %></td>
		</tr>
	</table>
</body>
</html>