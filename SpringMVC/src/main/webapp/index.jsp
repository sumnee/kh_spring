<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring Web</title>
	</head>
	<body>
		<form action="/member/login.do" method="post">
			ID : <input type="text" name="member-id"> <br>
			PW : <input type="password" name="member-pw"> <br>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
		</form>
	</body>
</html>