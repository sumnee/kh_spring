<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 작성</title>
	</head>
	<body>
		<h1>게시글 등록</h1>
		<form action="/board/register" method="post">
			<table align="center">
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardTitle"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="boardWriter"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="boardContents" id="" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>