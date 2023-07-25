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
	<div>
		<form action="<%=request.getContextPath()%>/department/dlist" method="get">
			<input type="search" name="searchWord">
			<input type="button" value="찾기">
		</form>
	</div>
	
	<% 
	List<DepartmentVo> volist = (List<DepartmentVo>)request.getAttribute("departmentList");
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null){
		%>
		<h3><%=searchWord %>검색결과</h3>
		<h5><a href="<%=request.getContextPath()%>/department/dlist">전체보기</a></h5>		
		<% 
	}
	if(volist == null || volist.size() == 0){
		%>
		<h2>결과물이 없습니다.</h2>
		<% 
	}else{
	
	%>
	
	<table border = "1">
		<tr>
			<th>학과 번호</th>
			<th>학과명</th>

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
		</tr>
		
		
		<%
		}
		%>
	</table>
	<% 
	}
	%>
	
	
	</body>
</html>