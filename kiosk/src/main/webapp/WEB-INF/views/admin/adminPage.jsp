<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우마이라멘 - 관리자 페이지</title>
<link rel="stylesheet" href="/resources/css/adminPage.css">
</head>
<body>
<header>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<section>
	<jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
	<div id="registForm">
		<h2>제품등록</h2>
		<hr>
		<form action="/admin/food" class="regist" method="post">
			<table id="regForm_tbl">
				<tr>
					<th>제품명</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><input type="text" name="category"></td>
				</tr>
				<tr>
					<th>재고</th>
					<td><input type="text" name="inventory"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" name="productImg"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록하기">
				</tr>
			</table>
			<div id="preview_img">
				미리보기
			</div>
		</form>
	</div>
</section>
</body>
</html>