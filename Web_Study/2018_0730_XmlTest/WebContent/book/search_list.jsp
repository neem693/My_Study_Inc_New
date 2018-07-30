<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">

<html>
<head>
<style>
table {
	width: 50%;
	border-collapse: collapse;
	margin: 0 auto;
}

td, th {
	padding: 10px;
	border: 1px solid black;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>번호</th>
			<th>책 제목</th>
			<th>이미지</th>
			<th>작가</th>
			<th>출판사</th>
			<th>정가</th>
			<th>할인 정보</th>
			<th>출판 날짜</th>
		</tr>

		<c:forEach var="vo" items="${list }" varStatus="i">
			<tr>
				<td>${i.index +1 }</td>

				<td><a href="${vo.link}">${vo.title }</a></td>
				<td><img alt="${vo.title }" src="${vo.image}"></td>
				<td>${vo.author}</td>
				<td>${vo.publisher }</td>
				<td><fmt:formatNumber maxFractionDigits="3"
						value="${vo.price }"></fmt:formatNumber>원</td>
				<td><c:choose test="
						<fmt:formatNumber maxFractionDigits="3"
						value="${vo.discount }"></fmt:formatNumber>==0">할인정보 없다</c:if>원</td>
				<td>${vo.pubdate}</td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>