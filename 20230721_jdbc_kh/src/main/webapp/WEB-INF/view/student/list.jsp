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
	<div>
		<form action = "<%=request.getContextPath()%>/student/list" method = "get">
			<input type = "search" name = "searchWord">
			<input type = "submit" value = "찾기">
		</form>
	</div>
	
	
	<% 
	// <% = jsp tag- java문법 	
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null){
		%>
		<h3><%=searchWord %> 검색결과</h3>
		<h5><a href="<%=request.getContextPath()%>/student/list">전체보기</a></h5>
		<%
	}
	if(volist == null || volist.size() == 0){   // 연산자 순서에 의해 volist == null이 먼저 쓰임. 밑에 if문보다 추천
	//if(volist == null){
	//if(volist.size() < 1){ - dao에서 new를 어느시점에 하느냐에 따라 다름.
		%>
		<h2>결과물이 없습니다.</h2>
		<% 
	}else{
	%>
	

	<table border = "1">
		<tr>
			<th>학번</th>
			<th>이름</th>
		</tr>
		<%
		for(int i = 0; i <volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		
		<tr>
			<!-- 학번 누르면 페이지 변경. ex)/student/get?sno=A131333 -->
			<td><a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo()%>"><%=vo.getStudentNo()%></a></td>
			<td><%=vo.getStudentName() %></td>
		</tr>
		
		
		<%
		} //for
		%>
		
			
	</table>	
	<div>
	<%
	for(int i=1;i<=10;i++){
	%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
		|
	<%
	}  // for
	%>
	</div>
	<%
	}  //else
	%>
	
	
	
</body>
</html>