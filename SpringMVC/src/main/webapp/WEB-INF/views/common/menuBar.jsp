<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<style>
		h1 {
			text-align: center;
		}
		ul {
			list-style-type: none;
		}
		a{
			display: block;
			/* 글씨만 선택해야하는게 아니라 li태그 전체를 클릭 가능 */
		}
		a:link, a:visited  {
			text-decoration: none;
			color: gray;
		}
		a:hover {
			cursor: pointer;
			background: white;
			color: navy;
			font-weight: bold;
		}
		#navigator {
			margin: 0;
			padding: 0;
			height: 100px
		}
			.item {
				float: left;
				width: 25%;
				text-align: center;
				line-height: 50px;
				background-color: skyblue;
			}
		#login-wrapper {
			width: 250px;
			border: 1px solid #ccc;
			padding-left: 10px;
			margin-bottom: 20px;
			margin-left: auto;
		}
			#login-area {
				margin: 0;
				padding: 0;
			}
				.login-item {
					margin: 10px 0px;
				}
					.login-item label {
						width: 33px;
						text-align: left;
						float: left;
					}
	</style>
	</head>
	<body>
		<h1>
			Welcome to  >> Spring WEB <<
		</h1>
	<!-- 리다이렉트용으로 jsp forward 사용 가능 / 여기서는 안씀 -->
	
		<c:if test="${sessionScope.loginUser eq null }">
			<div id="login-wrapper">
				<form action="/member/login.do" method="post">
					<ul id="login-area">
						<li class="login-item">
							<label>ID </label>
							<input type="text" name="member-id">
						</li>
						<li class="login-item">
							<label>PW </label>
							<input type="password" name="member-pw">
						</li>
					</ul>
					<div>
						<input type="submit" value="로그인">
						<input type="reset" value="취소">
					</div>
				</form>
			</div> 
		</c:if>
		<c:if test="${sessionScope.loginUser ne null }">
			${sessionScope.loginUser.memberName }님 환영합니다. <br>
			<a href="/member/logout.do">로그아웃</a>
		</c:if>
		<ul id="navigator">
			<li class="item"><a href="javascript:void(0);" onclick="goHome();">Home</a></li>
			<li class="item"><a href="#" onclick="goNotice();">공지사항</a></li>
			<li class="item"><a href="#">자유게시판</a></li>
			<li class="item"><a href="#">관리자페이지</a></li>
		</ul>
		<script>
			function goHome() {
				location.href = "/home.do";
			}
			function goNotice() {
				event.preventDefault();
				//javascript:void(0) 이거나 return false 이것도 같은 기능!
				location.href = "/notice/list.do";
				
			}
		</script>
	</body>
</html>