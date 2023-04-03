<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사진 게시판</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	</head>
	<body>
		<h1>사진 게시판</h1>
		<div id="photo-wrapper" style="padding:100px;"></div>
		<div id="photo-btn-container" style="text-align:center;">
			<input type="hidden" id="more-var" totalCount="5" currentSum="0" currentCount="0">
		</div>
		
		
		<script>
			const photoWrapper = $("#photo-wrapper");
			const moreVar = $("#more-var");
			photoMoreAjax(1);
			function photoMoreAjax(start) {
				$.ajax({
					url : "/photo/more",
					data : { "start" : start },
					type : "post",
					success : function(result) {
						let html = "";
						for(let i=0; i<result.length; i++) {
							html += "<div>"
							html += 	"<img src='/resources/bFileUploads/"+result[i].photoFileRename+"' width='100%'";
							html += 	"<p class='caption'>"+result[i].photoContent+"</p>";
							html += "</div>";
						}
						moreVar.val(Number(start) +1);
						moreVar.attr("currentSum", Number(moreVar.attr("currentSum"))+result.length); //지금까지 쿼리한 수
						moreVar.attr("currentCount", 0); //
						photoWrapper.append(html);
					},
					error : function() {
						alert("처리실패");
					}
				});
			}
			
			//스크롤 이벤트
			$(window).scroll(function() {
				let scrollTop = $(window).scrollTop();
				let innerHeight = $(window).innerHeight();
				let scrollHeight = $("body").prop("scrollHeight");
				if(scrollTop + innerHeight >= scrollHeight) {
					console.log("ff");
					if(moreVar.attr("totalCount") != moreVar.attr("currentSum")) {
						photoMoreAjax(moreVar.val());
					}
				}
			})
		</script>
	</body>
</html>