<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세 정보</title>
</head>
<body>
	<h1>학생 상세 정보입니다</h1>
	<% 
	StudentVo vo = null;
	if(request.getAttribute("svo") instanceof StudentVo){
		vo = (StudentVo)request.getAttribute("svo");
	}
	%>
	
	<table border = "1">
		<tr>
			<td>이름</td>
			<td><%=vo.getStudentName() %></td>
		</tr>
		<tr>
			<td>학과번호</td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
		<tr>
			<td>학번</td>
			<td><%=vo.getStudentNo() %></td>
		</tr>
		<tr>
			<td>주빈번호</td>
			<td><%=vo.getStudentSsn() %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=vo.getStudentAddress() %></td>
		</tr>
		<tr>
			<td>입학일</td>
			<td><%=vo.getEntranceDate() %></td>
		</tr>
		<tr>
			<td>휴학여부</td>
			<td><%=vo.getAbsenceYn() %></td>
		</tr>
		<tr>
			<td>담당교수번호</td>
			<td><%=vo.getCoachProfessorNo() %></td>
		</tr>		
	</table>
	
		<h5><a href="<%=request.getContextPath()%>/student/list">메인으로</a></h5>
</body>
</html>