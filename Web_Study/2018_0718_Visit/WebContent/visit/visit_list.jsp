<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/visit.css">
</head>
<body>
	<div id="main_box">
		<h1>::::방명록::::</h1>
		<div style="text-align: center;">
			<input type="button" value="글쓰기" onclick="location.href = 'insert_form.do'">

		</div>
		<hr>
		<!-- 데이터가 없을 경우 -->
		<c:if test="${empty list}">
			<div class="empty_style">등록된 게시물이 읎다.</div>
		</c:if>


		<c:forEach var="visit" items="${list}">

			<div class="box_style">
				<div class="user">
					<span class="id">${visit.name}</span><br> <span
						class="ip">${visit.ip}</span><br><span class="date">${visit.regdate}</span>
				</div>
				<div class="content_style">${visit.content}</div>
				<div class = "pwd">
					비밀번호:${visit.pwd}<input type="password"><input
						type="button" value="삭제"><input type="button" value="수정">
				</div>
			</div>
		</c:forEach>

	</div>

</body>
</html>