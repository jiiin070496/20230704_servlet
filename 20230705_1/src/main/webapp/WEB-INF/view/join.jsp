<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<style>
.hint{
	font-size: .7em;
	color: blue;
	visibility: hidden; 
}


</style>

<script>
	window.onload = loadedHandler;
	function loadedHandler(){
		$("[type=text]").click(inputClickHandler);
		$("[type=password]").click(inputClickHandler);
		$("[type=email]").click(inputClickHandler);
	}
	function inputClickHandler(){
		$(".hint").css("visibility", "hidden");
		var $hintElement = $(this).parent("tr").next(".hint");
		$hintElement.css("visibility", "visible");
	}
</script>

</head>
<body>
<h1>회원가입</h1>
	<div>
		<%-- <form action="<%=request.getContextPath() %>/join" method="post"> --%>
		<form id="frmJoin">	
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" placeholder = "(5-9, 영문자로 시작, 숫자,특수기호(_!)만 가능)"></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(5-9, 영문자로 시작, 숫자,특수기호(_!)만 가능)</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="mpwd" placeholder = "(5-9, 대문자, 소문자, 숫자, 특수문자(!_#) 최소 1개 이상포함"></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(5-9, 영문자로 시작, 숫자,특수기호(_!)만 가능)</td>
				</tr>
				<tr>
					<th>이름(2-10, 한글)</th>
					<td><input type="text" name="mname" ></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(2-10, 한글)</td>
				</tr>
				<tr>
					<th>전화번호(7-30)</th>
					<td><input type="text" name="mtel"></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(7-30)</td>
				</tr>
				<tr>
					<th>이메일(5-100)</th>
					<td><input type="email" name="memail"></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(5-100)</td>
				</tr>
				<tr>
					<th>주민번호(14)</th>
					<td><input type="text" name="msno"></td>				
				</tr>
				<tr class = "hint">
					<td></td>
					<td>(14)</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>				
				</tr>
			</table>
		</form>
	</div>
	
<script>
	$("#frmJoin [type=button]").click(submitHandler);
	
	function submitHandler(){
		console.log("여기 들어왔?");
		//유효성 검사
		var id = $("[name=mid]").val();
		var regEx_id = /^[a-zA-Z][a-zA-Z0-9_!]{4,9}$/; //정규표현식
		console.log(typeof(regEx_id)); //Object
		if(!regEx_id.test(id)){
			alert("아이디는 5-9자 영문자로 시작하고 영문자와 숫자만 입력해주세요.");
		}
 		/*
 		var id = $("[name=mid]").val();
		if(id.length < 5 || id.length > 16){
			//조건식으로 오류체크
			alert("5-16자 입력해주세요.");
			$("[name=mid]").focus();
			return;
		} 
		*/
		//String 객체 메소드 중에
		//includes("a");
		
		//id가 정상적으로 입력되어있다면 다음 pwd 체크함
		var pwd = $("[name=mpwd]").val();
		var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[a-zA-Z0-9!_#]{5,9}$/;
		if(!regEx_pwd.test(pwd)){
			console.log("정규표현식 부적합");
			alert("8-20자 입력해주세요.");
			$("[name=mpwd]").focus();
			return;
		}else{
			console.log("정규표현식 적합");
		}
/* 		if(pwd.length < 8 || pwd.length > 20){
			//정상
			alert("8-20자 입력해주세요.");
			$("[name=mpwd]").focus();
			return;
		} */
		
		var name = %("[name=mpwd]").val(); //(2-10, 한글)
		var regEx_name = /^[가-힣]{2, 10}$/
		if(!regEx_name.test(name)){
			alert("2-10자 입력해주세요");
			$("[name=mname]").focus();
			return;
		}
		var tel = %("[name=mname]").val(); //(7-30)
		var regEx_tel = /^01[016789]-[0-9]{3,4}-[0-9]{4}$/
		if(!regEx_tel.test(tel)){
			alert("다시 입력해주세요");
			$("[name=mtel]").focus();
			return;
		}
		var sno = %("[name=mtel]").val();
		var regEx_sno = /^[0-9]{6}-[1234][0-9]{6}$/
		if(!regEx_sno.test(sno)){
			alert("다시 입력해주세요");
			$("[name=mtel]").focus();
			return;
	}
</script>

</body>
</html>


















