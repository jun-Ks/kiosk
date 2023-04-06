<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우마이라멘 - 제품상세조회</title>
<link rel="stylesheet" href="/resources/css/productInfo.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"/>
	</header>
	<section>
		<jsp:include page="/WEB-INF/views/admin/sidebar.jsp"/>
		<div id="listBox">
			<h2>제품상세조회</h2>
			<hr>
			<div class="update">
			<table id="updateForm_tbl">
				<tr>
					<th>제품코드</th>
					<td><input type="text" name="foodCode" id="foodCode" value="${food.foodCode }" readonly></td>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type="text" name="name" id="name" value="${food.name }"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" id="price" value="${food.price }"></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><input type="text" name="category" id="category" value="${food.category }"></td>
				</tr>
				<tr>
					<th>재고</th>
					<td><input type="text" name="inventory" id="inventory" value="${food.inventory }"></td>
				</tr>
				<tr>
					<th>판매량</th>
					<td><input type="text" name="sales" id="sales" value="${food.sales }" readonly></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" name="productImg" id="productImg" accept="image/*" onchange="setThumbnail(event)"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="del_btn">삭제</button>
						<button type="button" id="submit">수정</button>
					</td>
				</tr>
			</table>
			<div id="preview_img">
				<img src="/resources/productImg/${food.img }">
			</div>
		</div>
		</div>
	</section>
	
	<script src="/resources/js/productInfo.js"></script>
</body>
</html>