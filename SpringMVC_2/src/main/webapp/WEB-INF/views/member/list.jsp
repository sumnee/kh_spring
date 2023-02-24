<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멤버 목록</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입날짜</th>
					<th>가입여부</th>
				</tr>
			</thead>
				<c:forEach items="${mList }" var="member">
				<tr>
					<th><a href="/member/detail.kh?memberId=${member.memberId }">${member.memberId }</a></th>
					<th>${member.memberName }</th>
					<th>${member.memberEmail }</th>
					<th>${member.memberPhone }</th>
					<th>${member.memberAddr }</th>
					<th>${member.enrollDate }</th>
					<th>${member.mStatus }</th>						
				</tr>
				</c:forEach>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<input type="text" placeholder="검색어를 입력하세요">
					</td>
					<td>
						<input type="submit" value="검색">
					</td>	
			</tfoot>
		</table>
	</body>
</html>