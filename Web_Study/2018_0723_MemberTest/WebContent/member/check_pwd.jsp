<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>
	function pwd_send(f) {
		var type = "${type}";
		var idx = "${idx}"
		var op;

		op = {
			url : "check_pwd_send.do",
			data : {
				'pwd' : f.pwd,
				'idx' : idx
			},
			success : function(result) {
				console.log(result);
				if (result.indexOf("no")) {
					alert("비밀번호가 올바르지 않습니다.");
					return;
				}
			}
		};

		$.ajax(op);

		alert("비밀번호가 맞습니다");

	}
</script>
</head>
<body>


	<form>
		<p>확인을 위해비밀번호를 입력하세요</p>
		<input name="pwd" type="password"> <input type="button"
			onclick="pwd_send(this.form)">
	</form>



</body>
</html>