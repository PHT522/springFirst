<%@page import="kh.com.a.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- ajax를 하기위해 -->
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>여기는 helloSpring.jsp입니다.</h1>


<!-- 1번예제 -->
<%
MyClass mycls = (MyClass)request.getAttribute("mycls");
%>

번호:<%=mycls.getNumber() %>
<br>
이름:<%=mycls.getName() %>
<br><br>




<!-- 2번 -->
<form action="inputData.do">
번호:<input type="text" name="number">
<br>
이름:<input type="text" name="name">
<input type="submit" value="전송">
</form>
<br><br>

<!-- 3번 ajax이용 json방식(키,값)-->
<form method="get">
아이디:<input type="text" id="formid">
<br>
<button type="button" onclick="idcheck()">체크</button>
<!-- <button type="button" id="_check"></button> -->
</form>

<script type="text/javascript">
function idcheck() {
	$.ajax({
		url:"idcheck.do",
		type:"get",
		data:"id=" + $('#formid').val(),	// idcheck.do?id=aaa 와 동일
		success:function(data){	//data:json형식 , map형태(key.value), 
			alert("data:" + data);		
		},
		error:function(request, status, error){
			alert("실패");
		}
	});	
}
</script>
<br><br>

<!-- 4번 -->
<form method="post">
이름:<input type="text" id="name"><br>
전화:<input type="text" id="tel"><br>
이메일:<input type="text" id="email"><br>
생년월일:<input type="text" id="birth"><br>
<button type="button" onclick="account()">account</button>
</form>
<br><br>
<script type="text/javascript">
function account() {
	//데이타를 모아주는 방법 json방식
	var data = {
			name:$("#name").val(),
			tel:$("#tel").val(),
			email:$("#email").val(),
			birth:$("#birth").val()			
	};	
	
	$.ajax({
		dataType:'json',
		url:'account.do',
		data:data,
		type:'post',
		async:true,	//비동기
		success:function(resp){
			alert("success");
			alert(resp.msg);
		},
		error:function(r, s, e){
			alert("error");
		}
	});	
	
}
</script>

<!-- 5번  -->
<form method="post">
이름:<input type="text" id="_name"><br>
전화:<input type="text" id="_tel"><br>
이메일:<input type="text" id="_email"><br>
생년월일:<input type="text" id="_birth"><br>
<button type="button" onclick="_account()">account</button>
</form>
<script type="text/javascript">
function _account() {
	var data = {};	// json 초기화
	
	data["name"] = $("#_name").val();
	data["tel"] = $("#_tel").val();
	data["email"] = $("#_email").val();
//	data["_birth"] = $("#_birth").val();		// 2018-10-11이렇게 넘어오면
	var birth = $("#_birth").val();
	data["birth"] = birth.replace(/-/g, '');	// 20181011로 만듬
	
	$.ajax({
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data),		// 자바스크립트값(배열)을 json문자열로 변경
		url:'updateUser.do',
		type:'POST',
		success:function(res){
			alert("success");
		},
		error:function(r, s, e){
			alert("error");
		}		
	});	
}
</script>



</body>
</html>