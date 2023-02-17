<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
		<style>
			table, th, td {
				border: 1px solid #ccc;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp"></jsp:include>
		<table>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>가입날짜</th>
				<th>수정날짜</th>
			</tr>
			<c:forEach items="${mList }" var="member" varStatus="s">
			<tr>
				<td>${s.count }</td>
				<td><a href="/member/detail.do?memberId=${member.memberId }">${member.memberId }</a></td>
				<td>${member.enrollDate }</td>
				<td>${member.updateDate }</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>