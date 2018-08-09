<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script language="JavaScript">
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
</script>
</HEAD>

<BODY>
	<table width="690" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><input type="image" src="../img/title_04.gif"></td>
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

	<p>
		<br>
</BODY>
</HTML>