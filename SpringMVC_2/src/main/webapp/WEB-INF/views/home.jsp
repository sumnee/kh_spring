<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<c:if test="${loginUser eq null }">
	<fieldset>
		<legend>로그인</legend>
		<form action="/member/login.kh" method="post">
			ID <input type="text" name="member-id"> <br>
			PW <input type="password" name="member-pw"> <br>
			<input type="submit" value="로그인">
			<input type="reset" value="초기화">
		</form>
	</fieldset>
	<c:url var="regiView" value="/member/registerView.kh"></c:url>
	<a href="${regiView }">회원가입</a>
	</c:if>
	<c:if test="${loginUser ne null }">
		<b>${loginUser.memberName }님 환영합니다.</b> <br>
		<a href="/member/mypage.kh">마이페이지</a>
		<a href="/member/logout.kh">로그아웃</a>
	</c:if>
	<c:url var="notiView" value="/notice/list.kh"></c:url>
	<a href="${notiView }">공지사항</a>
</body>
</html>
