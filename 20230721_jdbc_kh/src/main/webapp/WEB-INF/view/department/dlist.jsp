<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h2>학과 리스트</h2>
	<% 
	List<DepartmentVo> volist = (List<DepartmentVo>)request.getAttribute("departmentList");
	%>
	
	<table border = "1">
		<tr>
			<th>학과 번호</th>
			<th>학과명</th>
			<th>과분류</th>
			<th>개강여부</th>
			<th>인원수</th>
		</tr>
		<%
		for(int i = 0; i <volist.size(); i++){
			DepartmentVo vo = volist.get(i);
		%>
		
		<tr>
			<%-- 학번 누르면 페이지 변경. ex)/student/get?no=A131333 --%>
		 	<td><a href="<%=request.getContextPath()%>/department/dget?dno=<%=vo.getDepartmentNo()%>"><%=vo.getDepartmentNo()%></a></td>
			<%-- <td><%=vo.getDepartmentNo() %></td> --%>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYn() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
		
		
		<%
		}
		%>
	</table>
	</body>
</html>