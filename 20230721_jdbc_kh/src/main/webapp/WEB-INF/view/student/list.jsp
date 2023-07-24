<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<% 
	// <% = jsp tag- java문법 	
/* 	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc");	*/	
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	%>
	
	<%-- <%= a %> --%>
	<%-- <%= b %> --%>
	<%-- <%= c %> --%>
	<%-- <%= volist %> --%>
	
	<table border = "1">
		<tr>
			<th>학번</th>
			<th>학과번호</th>
			<th>이름</th>
			<th>입학일</th>
			<th>주소</th>
			<th>주민번호</th>
		</tr>
		<%
		for(int i = 0; i <volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		
		<tr>
			<!-- 학번 누르면 페이지 변경. ex)/student/get?sno=A131333 -->
			<td><a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo()%>"><%=vo.getStudentNo()%></a></td>
			<td><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getStudentAddress() %></td>
			<td><%=vo.getStudentSsn() %></td>
		</tr>
		
		
		<%
		}
		%>
		
			
	</table>
	
	

	
	
	
</body>
</html>