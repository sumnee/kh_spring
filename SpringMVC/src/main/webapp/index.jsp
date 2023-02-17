<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring Web</title>
	</head>
	<style>
	*{
	box-sizing:board-box;
	}
	 
	 .video-film {
		box-shadow: rgba(0, 7, 15, 0.7) 0 0 0 9999px;
		z-index: 100;
	}
	
	.video-background {
		background: #000;
		position: fixed;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		z-index: -99;
	}
	
	.video-foreground, .video-background iframe {
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		pointer-events: none;
	}
	
	@media ( min-aspect-ratio : 16/9) {
		.video-foreground {
			height: 300%;
			top: -100%;
		}
	}
	
	@media ( max-aspect-ratio : 16/9) {
		.video-foreground {
			width: 300%;
			left: -100%;
		}
	}
	
	h1 {
		color: white;
	}
	.center{
		potision: absolute;
		top: 60%;
		left: 47%;
		margin: -50px 0 0 -50px;
	}
	#indexBtn {
		potision: fixed;
		text-align: center;
	}
	#visual-btn {
		z-index: 50;
		color: #fff;
		font-size: 15px;
		border: 2px solid #fff;
		padding: 12px 24px;
		border-radius: 5px;
		cursor: pointer;
		background-color: rgba(0, 0, 0, 0);
	}
	#visual-btn:hover {
		color: #ff6868;
		font-size: 17px;
		border: 2px solid #ff6868;
		padding: 12px 24px;
		border-radius: 5px;
		cursor: pointer;
	}
	</style>
	<body>
		<!-- 버튼 눌러서 이동 -->
		<h1 style="text-align:center; color:#fff;">
			<img alt="img" src="/resources/images/logo.png" style="height:50%; width:50%;">
		</h1>
		<div id="indexBtn" class="center"> 
			<button id="visual-btn" onclick="location.href='/home.do';">Visit Our WebSites</button>
		</div>
		<!-- <script>
				자동으로 바로 이동
				location.href="/home.do"; 
			</script> 
		-->
		
		<div class="video-background">
			<div class="video-background">
				<div id="muteYouTubeVideoPlayer"></div>
			</div>
		</div>	
		
		<div class="video-film"></div>
		<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script async src="https://www.youtube.com/iframe_api"></script>
		<script type="text/javascript">
			var player;
			
			function onYouTubePlayerAPIReady(){
				player = new YT.Player('muteYouTubeVideoPlayer', {
					videoId : 'at1MWYlzSe8',
					playerVars : {
						autoplay : 1, 		// Auto-play the video on load
						controls : 0, 		// Show pause/play buttons in player
					},
					events:{
						onReady:function(e){
							e.target.mute();
						}
					}
				});
			}
		</script>
	</body>
</html>