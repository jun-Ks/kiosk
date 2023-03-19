<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서오세요. 우마이라멘 입니다!</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/resources/css/index.css">
</head>

<body>
<header>
	<jsp:include page="/WEB-INF/views/header.jsp"/>

</header>
<table>
	<tr>
		<th>
			<a href="/user/menu/food-orders=togo">
				<span id="a_togo">
					<span id="highlight">
						포장
					</span
					>해서 가져가기
				</span>
			</a>
		</th>
		<th>
			<a href="/user/menu/food-orders=forhere">
				<span id="a_forhere">
					<span id="highlight">
						매장
					</span
					>에서 식사하기
				</span>
			</a>
		</th>
	</tr>
	<tr>
		<th>
			<a href="/user/menu/food-orders=togo">
				<img src="resources/imgs/togo.png" id="togoimg">
			</a>
		</th>
		<th>
			<a href="/user/menu/food-orders=forhere">
				<img src="resources/imgs/forhere.png" id="forhereimg">
			</a>
		</th>
	</tr>
</table>

<a href="admin/adminPage">관리자페이지</a>

<script>
	$("#a_togo, #a_forhere").on("mouseover", function(e){
		$(this).css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
		$(this).children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});

	});
	$("#a_togo, #a_forhere").on("mouseleave", function(e){
		$(this).css("background-color", "white");
		$(this).children().css({"background-color" : "#F8D7DA", "color" : "black"});
	});
	
	$("#togoimg").on("mouseover", function(e){
		$("#a_togo").css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
		$("#a_togo").children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});
	});
	$("#togoimg").on("mouseleave", function(e){
		$("#a_togo").css("background-color", "white");
		$("#a_togo").children().css({"background-color" : "#F8D7DA", "color" : "black"});
	});
	
	$("#forhereimg").on("mouseover", function(e){
		$("#a_forhere").css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
		$("#a_forhere").children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});
	});
	$("#forhereimg").on("mouseleave", function(e){
		$("#a_forhere").css("background-color", "white");
		$("#a_forhere").children().css({"background-color" : "#F8D7DA", "color" : "black"});
	});

</script>
</body>
</html>