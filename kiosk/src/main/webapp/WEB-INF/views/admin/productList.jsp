<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우마이라멘 - 제품조회</title>
<link rel="stylesheet" href="/resources/css/productList.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<header>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<section>
	<jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
	<div id="listBox">
		<h2>제품조회</h2>
		<hr>
		<div id="listView">
			<table id="foodList" border="1">
				<thead>
					<tr>
						<th>코드</th>
						<th>카테고리</th>
						<th>이미지</th>
						<th>제품명</th>
						<th>가격</th>
						<th>재고</th>
						<th>판매량</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
	</div>
</section>
<script src="/resources/js/productList.js"></script>
</body>
</html>