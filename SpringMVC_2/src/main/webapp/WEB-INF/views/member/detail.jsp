<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멤버 상세보기</title>
	</head>
	<body>
		<h1>멤버 상세보기</h1>
		<ul>
			<li>Id : ${member.memberId }</li>
			<li>Pw : ${member.memberPw }</li>
			<li>Name : ${member.memberName }</li>
			<li>Email : ${member.memberEmail }</li>
			<li>Phone : ${member.memberPhone }</li>
			<li>Address : ${member.memberAddr }</li>
		</ul>
		<a href="/member/mypage.kh?memberId=${member.memberId}">수정하기</a>
	</body>
</html>