<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax정리</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	</head>
	<body>
		<h1>Ajax 개요</h1>
		<p>
			Ajax는 Asynchronous Javascript And XML이란 용어로<br> 서버로부터 데이터를 가져와 전체
			페이지를 새로 고치지 않고 일부만 로드할 수 있게 하는 기법<br> 비동기식 요청을 함.
		</p>
		<h3>동기식/비동기식이란?</h3>
		<p>
			동기식은 서버와 클라이언트가 동시에 통신하여 프로세스를 수행 및 종료까지 같이하는 방식<br> 이에 반해 비동기식은
			페이지 리로딩없이 서버요청 사이사이 추가적인 요청과 처리 가능
		</p>
		<h3>Ajax 구현(Javascript)</h3>
		<h4>1. ajax로 서버에 전송값 보내기</h4>
		<p>버튼 클릭시 전송값을 서버에서 출력</p>
		<input type="text" id="msg-1">
		<button onclick="jsFuncPost();">보내기(JS)</button>


		<h3>Ajax 구현(jQuery)</h3>
		<h4>2. ajax(jQuery)로 서버에 전송값 보내기</h4>
		<p>버튼 클릭시 전송값을 서버에서 출력</p>
		<input type="text" id="msg-2">
		<button onclick="jqueryFunc();">보내기(jQuery)</button>

		<h3>3. 버튼 클릭시 서버에서 보낸 값 수신</h3>
		<button id="jq-btn3">서버에서 보낸값 확인</button>
		<p id="confirm-area"></p>

		<h4>4. 서버로 전송값 보내고 결과 문자열 받아서 처리</h4>
		<p>숫자 2개를 전송하고 더한 값 받기</p>
		첫번째 수 :
		<input type="text" id="num-1">
		<br> 두번째 수 :
		<input type="text" id="num-2">
		<br>
		<button id="jq-btn4">전송 및 결과확인</button>
		<p id="p4"></p>


		<h1>JSON 개요</h1>
			<p>
				Ajax 서버 통신시 데이터 전송을 위한 포맷
				<br>
				JSON(Javscript Object Notation) : 자바스크립트 객체 표기법
				<br>
				JSON을 사용하면 모든 데이터형을 서버와 주고 받을 수 있다.(사용목적)
				<br> 숫자, 문자열, boolean, 배열, 객체, null
				<br>
				'{'으로 시작하여 '}'로 끝나며 그 속에 데이터를 표기하고 'key : value(값)' 쌍으로 구성된다.
				<pre>
					{
						"name" : "이순신",
						"age" : 27,
						"birth" : "1990-01-01",
						"gender" : "남",
						"marry" : true,
						"address" : "서울특별시 중구 인사동",
						"family" : {  
									"father" : "아버지",
									"mother" : "어머니",
									"brother" : "동생"
								}
					}
				</pre>
			</p>
			
			<h4>5. 서버로 전송값 보내고 결과 JSON으로 받아서 처리</h4>
			유저 번호 입력 : <input type="text" id="user-num"><br>
			<p id="p5"></p>
			<button id="jq-btn5">실행 및 결과확인</button>
			
			<h4>6. 서버로 전송값을 보내고 JSONArray로 결과 받아서 처리</h4>
			<p>유저 번호를 보내서 해당 유저를 가져오고, 없는 경우 전체리스트 가져오기</p>
			유저 번호 입력 : <input type="text" id="find-num"><br>
			<p id="p6"></p>
			<button id="jq-btn6">실행 및 결과확인</button>
			
			<h4>7. GSON을 이용한 List 변환</h4>
			<p>전체리스트 가져오기</p>
			<p id="p7"></p>
			<button id="jq-btn7">실행 및 결과확인</button>
			<br><br>
			
			
			
		<script>
		
			// 4. 값 주고받기(숫자만)
			$("#jq-btn4").on("click", function() {
				const num1 = $("#num-1").val();
				const num2 = $("#num-2").val();
				$.ajax({
					url : "/ajax/fourth",
					data : {"numOne" : num1, "numTwo" : num2},
					type : "get",
					success : function(result) {
						$("#p4").html("연산결과 : " + result);
					}, 
					error : function() {
						console.log("처리 실패");
					}
				});
			});

			// 3. 서버에서 값 받아오기(값을 받아오는거니까 data를 쓰지 않음)
			document.querySelector("#jq-btn3").addEventListener("click", function() {
				$.ajax({
					url : "/ajax/third",
					type : "get",
					success : function(data) {
						$("#confirm-area").html(data);
					}, 
					error : function() {
						console.log("처리 실패");
					}
				});
			})
			
			// 1. javascript 사용하기
			function jsFuncPost() {
				//1. XMLHttpREquest 객체 설정
				var xHttp = new XMLHttpRequest();
				var message = document.querySelector("#msg-1").value;
				//2. 요청 정보 설정
				xHttp.open("GET", "/ajax/first?msg="+message, true);
				//3. 콜백 함수 설정
				xHttp.onreadystatechange = function() {
					if(this.readyState == 4 && this.status == 200) {
						// status -> 200(요청성공) 404(page,url없음) 500(서버오류) 
						//			 403(접근거부) 400(쿼리스트링 오류)
						console.log("서버 전송 성공");
					} else if(this.readyState == 4 && this.status == 404) {
						console.log("Page Not Found");
					}	
				}
				//4. 전송
				xHttp.send();
			}
			
			// 2. jQuery사용하기
			function jqueryFunc() {
				var message = document.querySelector("#msg-2").value;
				$.ajax({
					url : "/ajax/second",
					data : {"msg" : message},
					type : "get",
					success : function() {
						console.log("서버 전송 성공");
					}, 
					error : function() {
						console.log("서버 전송 실패");
					}
				});
			}
			
			
			/////5번 6번 복습하기
			// 5. 값 주고받기(객체형태)
			document.querySelector("#jq-btn5").addEventListener("click", function(){
				const memberId = $("#user-num").val();
				$.ajax({
					url : "/ajax/fifth",
					data : {"memberId" : memberId},	//"memberId"라는 키값으로 보내짐
					type : "get",
					success : function(result){
						$("#p5").html("아이디 : " + result.memberId + ", 비밀번호 : " + result.memberPw);
// 						console.log(result);
					},
					error : function(){
						
					}
				})
			})
			
			// 6. 값 주고받기(여러개의 값 받기)
			document.querySelector("#jq-btn6").addEventListener("click", function(){
				const memberId = $("#find-num").val();
				$.ajax({
					url : "/ajax/sixth",
					data : {"memberId" : memberId},
					type : "get",
					success : function(result){
						let str = "";
						for(var i = 0; i < result.length; i++){
							 str += result[i].memberId + " : " + result[i].memberPw + "<br>";
						}
						document.querySelector("#p6").innerHTML = str;
						// $("#p6").html(str);
					},
					error : function(){
						
					}
				})
			})
			
			// 7. GSON -> List 대체
			$("#jq-btn7").on("click", function() {
				$.ajax({
					url : "/ajax/seventh",
					type : "get",
					success : function(data) {
						let str = "";
						for(let i=0; i<data.length;i++) {
							str += data[i].memberId + " : " + data[i].memberPw + "<br>"
						}
						$("#p7").html(str);
					},
					error : function() {
						console.log("서버 처리 실패");
					}
				});
			});
		</script>
	</body>
</html>