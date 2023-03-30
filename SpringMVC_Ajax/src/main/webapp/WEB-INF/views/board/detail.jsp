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
		<table align="center">
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
				<td colspan="2" align="center">
					<input type="submit" value="수정">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	<!-- 	댓글 등록 -->
		<table align="center" width="500" border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" id="rWriter"></td>
			</tr>
			<tr>
				<td><textarea rows="3" cols="55" id="rContents"></textarea></td>
				<td><button id="rSubmit">등록하기</button></td>
			</tr>
		</table>
		<!-- 	댓글 목록 -->
		<table align="center" width="500" border="1" id="replyTable">
			<thead>
				<tr>
					<!-- 댓글갯수 -->
					<td colspan="4"><b id="replyCount"></b></td>
				</tr>
			</thead>
			<tbody>
							
			</tbody>
		</table>
		<script>
			getReplyList();
			//새로고침하거나 페이지 열면 바로 실행되도록
			function getReplyList() {
				const boardNo = "${board.boardNo}";
				$.ajax({
					url : "/reply/list",
					data : {"boardNo" : boardNo },
					type : "get", 
					success : function(data) {
						const tableBody = $("#replyTable tbody");
						tableBody.html("");
						let tr;
						let rWriter;
						let rContents;
						let rCreateDate;
						let btnArea;
						if(data.length > 0) {
							for(let i in data) {
								tr = $("<tr>");
								rWriter = $("<td width='100'>").text(data[i].replyWriter);
								rContents = $("<td>").text(data[i].replyContents);
								rCreateDate = $("<td width='100'>").text(data[i].rCreateDate);
								tr.append(rWriter);
								tr.append(rContents);
								tr.append(rCreateDate); //tr 밑에 td 3개 들어간 상태
								tableBody.append(tr);
							}
						};
					},
					error : function() {
						alert("Ajax 처리 실패");
					}
				});
			}



			$("#rSubmit").on("click", function() {
				const rContents 	= $("#rContents").val();
				const boardWriter 	= $("#rWriter").val();
				const boardNo 		= "${board.boardNo}"
				$.ajax({
					url : "/reply/register",
					data : {
						  "refBoardNo" : boardNo 
						, "replyContents" : rContents 
						, "replyWriter" : boardWriter },
					type : "post",
					success : function(result) {
						if(result == '1') {
							alert("댓글 등록 성공")
							$("#rContents").val("");
							$("#rWriter").val("");
							//댓글 작성 후 작성란 비우기
						} else {
							alert("댓글 등록 실패, 로그 확인 필요!")
							console.log(result);
						}						
					},
					error : function() {
						alert("Ajax 처리 실패")					
					}
				})
			})
		</script>
	</body>
</html>
			
	