<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세</title>
	</head>
	<body>
		<h1>공지사항 상세</h1>
		번호 ${notice.noticeNo } / 제목 ${notice.noticeTitle } / 작성자 ${notice.noticeWriter } / 작성일 ${notice.nCreateDate }
		<br>
		내용 ${notice.noticeContent }
		<br>
		첨부파일 ${notice.noticeFilename }
		<br>
		<c:url var="nModify" value="/notice/modifyView.kh">
			<c:param name="noticeNo" value="${notice.noticeNo }"/>
		</c:url>
		<a href="${nModify }">수정페이지로 이동</a>
		<a href="javascript:void(0)" onclick="removeCheck(${notice.noticeNo });">삭제하기</a>
	
		<script>
			function removeCheck(noticeNo) {
				if(confirm("삭제하시겠습니까?")) {
					location.href="/notice/remove.kh?noticeNo="+noticeNo;	
				}				
			}
		</script>
	</body>
</html>