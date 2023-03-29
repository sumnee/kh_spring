<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 상세</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	</head>
	<body>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle" value="${board.boardTitle}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boardWriter" value="${board.boardWriter}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="boardContents" id="" cols="30" rows="10">${board.boardContents}</textarea></td>
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
		<!-- 	댓글 영역 -->
<!-- 	댓글 등록 -->
		<table align="center" width="500" border="1">
			<tr>
				<td><textarea rows="3" cols="55" id="rContents"></textarea></td>
				<td><button id="rSubmit">등록하기</button>
			</tr>
		</table>
<!-- 	댓글 목록 -->
		<table align="center" width="500" border="1" id="replyTable">
			<thead>
				<tr>
<!-- 					댓글갯수 -->
					<td colspan="4"><b id="replyCount"></b></td>
				</tr>
			</thead>
			<tbody>
							
			</tbody>
		</table>
		<script>
			$("#rSubmit").on("click", function() {
				$.ajax({
					url : "/reply/register",
					data : {}
					type : "",
					success : function() {
						
					},
					error : function() {
						
					}
				})
			})
		</script>
	</body>
</html>
			
	