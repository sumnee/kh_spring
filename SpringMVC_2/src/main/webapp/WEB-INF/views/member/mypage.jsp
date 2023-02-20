<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<form action="/member/modify.kh" method="post">
			${memberId }
			Id <input type="submit value="${member.memberId }" readonly>
			PW <input type="submit value="${member.memberPw }" readonly>
			Name <input type="submit value="${member.memberName }" readonly>
			Email <input type="submit value="${member.memberEmail }" readonly>
			Phone <input type="submit value="${member.memberPhone }" readonly>
		ADdr <input type="submit value="${member.memberAddr }" readonly>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		
		</form>
	</body>
</html>