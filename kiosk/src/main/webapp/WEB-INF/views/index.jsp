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
<table id="orderType">
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

<div class="adminLogin">관리자페이지</div>
<div class="modal_outer" style="display:none">
	<div id="modal_inner">
		<div id="close_box">
			<button id="close_btn"> X </button>
		</div>
		<div id="modal_header">관리자 로그인</div>
		<table id="login_tbl">
			
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id" id="id"></th>
			</tr>
			<tr>
				<th>패스워드</th>
				<th><input type="password" name="pw" id="pw"></th>
			</tr>
			<tr>
				<th colspan="2"><button id="login">로그인</button></th>
			</tr>
		</table>
	</div>
</div>
<script src="/resources/js/index.js"></script>

</body>
</html>