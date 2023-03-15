<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>adminPage</h1>
<hr>
<form action="/admin/food" method="post">
	<table border="1">
		<tr>
			<th>이름</th><td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>가격</th><td><input type="text" name="price"></td>
		</tr>
		<tr>
			<th>카테고리</th><td><input type="text" name="category"></td>
		</tr>
		<tr>
			<th>재고</th><td><input type="text" name="inventory"></td>
		</tr>
		<tr>
			<th>이미지</th>
		</tr>
		<tr>
			<th><input type="submit" value="등록하기">
		</tr>
	</table>
</form>
</body>
</html>