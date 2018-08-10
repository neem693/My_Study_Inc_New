<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
	function del(f) {
		if (confirm("삭제 하시겠습니까?")) {

			f.action = 'delete.do?page=${param.page}';
			alert(f.idx.value);
			f.submit();

		}
	}
	function modify(f) {

		f.action = "modify_form.do?page=${param.page}";

		f.submit();

	}
	function reply() {

		location.href = "reply_form.do?idx=${param.idx}&page=${(empty param.page)?1:param.page}";

	}
	function comment_send() {
		if ('${empty user}' == 'true') {

			if (confirm('댓글은 로그인 하신후에 사용가능합니다\n로그인 하시겠습니까?')) {
				location.href = '../member/login_form.do?url='
						+ encodeURIComponent(location.href);
				return;
			}

		}
		var id = '${user.id}';
		var b_idx = '${vo.idx}';
		var name = '${user.name}';
		var content = $('#content').val();
		if (content == '') {
			alert("댓글 내용을 입력하세요");
			$('#content').focus();
			return;
		}

		$.ajax({
			url : 'comment_insert.do',
			data : {
				'b_idx' : b_idx,
				'id' : id,
				'name' : name,
				'content' : content
			},
			success : function(data) {
				data = eval(data);
				alert(data[0].result);

				comment_list(1);
			}
		})

	}

	function comment_list(page) {
		var b_idx = '${vo.idx}';

		$.ajax({
			url : 'comment_list.do',
			data : {
				'b_idx' : '${vo.idx}'
			},
			success : function(data) {
				$('#disp').html(data);
			}
		})

	}
	function login() {
		location.href = '../member/login_form.do?url='
				+ encodeURIComponent(location.href);
		return;
	}
	function del_re(idx) {
		if(confirm("정말 삭제하시겠습니까?")==false){
			return;
		}

		$.ajax({
			url : 'comment_delete.do',
			data : {
				'idx' : idx
			},
			success : function(data) {
				alert(data);
				data = eval(data);
			
				if (data[0].result == "fail")
					alert("삭제실패");
				if (data[0].result == "success")
					alert("삭제성공");
				comment_list(1);
			}
		});

	}

	$(document).ready(function() {
		comment_list(1);
	});
</script>
<style>
#comment_box, #comment_box * {
	margin: 0
}

#comment_box {
	clear: both; width : 700px;
	height: 100px;
	left: 600px;
	width: 700px;
}

#comment_input_box {
	width: 100%;
	height: 100px;
}

#comment_input_box>textarea {
	width: 80%;
	height: 100%;
	background-color: yellow;
	box-sizing: border-box;
	resize: none;
	color: black;
	font-weight: bold;
}

#comment_btn {
	box-sizing: border-box;
	height: 100%;
	float: right;
	width: 20%;
}

body {
	width: 50%;
	clear: both;
	margin: 0 auto;
}

footer {
	height: 500px;
}
</style>

</HEAD>

<BODY>


	<div style="width: 700px; margin: auto; text-align: right;">

		<c:if test="${empty user }">
			<input type="button" value="로그인" onclick="login()">
		</c:if>

		<c:if test="${not empty user}">
${user.name}(${user.id})님 환영합니다.
			<input type="button" value="로그아웃"
				onclick="location.href ='${pageContext.request.contextPath}/member/logout.do?page=${param.page }';">
		</c:if>

	</div>
	<table width="690" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><input type="image" src="../img/title_04.gif" onclick="location.href ='list.do'"></td>
		</tr>
	</table>

	<form method="post">
		<input type="hidden" name="idx" value="${vo.idx}"> <input
			type="hidden" name="id" value="${vo.id}">
		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="120" height="25" class="td_d">제목</td>
				<td class="td_d_1">${vo.subject }</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성자</td>
				<td class="td_d_2">${vo.name }(${vo.id})</td>
			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">작성일</td>
				<td class="td_d_2">${vo.viewdate}</td>
			</tr>
			<tr>
				<td width="120" class="td_d_4">내용</td>
				<td class="td_d_3" width="570"
					style="word-wrap: break-word; word-break: break-all"><pre>${vo.content}</pre>
				</td>
			</tr>
		</table>

		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td><input type="image" src="../img/btn_list.gif"
					onClick="location.href='list.do?page=${(empty param.page)?1:param.page}';return false;"
					style="cursor: pointer;"> <c:if test="${not empty user}">
						<input type="image" src="../img/btn_reply.gif"
							onClick="reply(); return false;" style="cursor: pointer">
					</c:if> <c:if test="${vo.id eq user.id}">
						<input type="image" src="../img/btn_modify.gif"
							onClick="modify(this.form); return false;"
							style="cursor: pointer">
						<input type="image" src='../img/btn_delete.gif'
							onClick='del(this.form); return false;' style='cursor: pointer'>
					</c:if></td>
			</tr>
		</table>
	</form>


	<div id="disp"></div>
	<div id="comment_box">
		<p>
			<c:if test="${not empty user.id}">작성자: ${user.name}(${user.id})</c:if>
			<br>
		</p>
		<div id="comment_input_box">
			<textarea id="content" rows="" cols=""><c:if
					test="${empty user.id}">로그인 한후 이용하세요.</c:if></textarea>
			<input id="comment_btn" type="button" onclick="comment_send()"
				value="댓글쓰기">
		</div>
	</div>

	<footer></footer>
</BODY>
</HTML>