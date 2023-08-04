<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<h2>Ajax Test</h2>
	<input type="text">
	<button id="btnajax1">ajax1</button>
	<button id="btnajax2">ajax2</button>
<script>

$("#btnajax1").click(ajax1ClickHandler);
$("#btnajax2").click(ajax2ClickHandler);

function ajaxSuccess(result){
	alert(result);
}

//화면이 보이면서 alert창
function ajax1ClickHandler(){
	//$.ajax(object형테로 매개인자 전달);
	//var obj = {k1:12, k2:'값', k3:function(){}};
	console.log("ajax로 데이터 전달중 -1-");
	$.ajax({
		url:"${pageContext.request.contextPath}/ajax1", 
		type:"get",
		data:{n1:'값도가나?', n2:116 },
		success: ajaxSuccess
	});
	console.log("ajax로 데이터 전달중 -2-");
}

function ajax2ClickHandler(){
	//$.ajax(object형테로 매개인자 전달);
	//var obj = {k1:12, k2:'값', k3:function(){}};
	console.log("ajax로 데이터 전달중 -3-");
	$.ajax({
		url:"${pageContext.request.contextPath}/ajax2", 
		type:"post",
		success: ajaxSuccess2,
		dateType:"json"
	});
	console.log("ajax로 데이터 전달중 -4-");
}

function ajaxSuccess2(result){
	/* alert(result); */
	console.log("2 ctrl로부터 전달받은 데이터: ");
	console.log(result);
	if(result){
		for(var i = 0; i<result.length;i++){
			var dvo = result[i];
			console.log(dvo.departmentName);
		}
	}


}

</script>
</body>
</html>