<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/resources/css/menu.css">

</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"/>
	</header>

	<c:if test="${forhere != null }">
	<h3>매장에서 식사하기 선택하셨습니다</h3>
	</c:if>
	<c:if test="${togo != null }">
	<h3>포장해서 가져가기 선택하셨습니다</h3>
	</c:if>
	
	<hr>
	<section>
		<div class="menu_section">
			<table id="menu_tbl">
				<thead id="menu_tbl_thead">
					<tr>
						<th class="menu_index">인기</th>
						<th class="menu_index">라멘</th>
						<th class="menu_index">토핑</th>
						<th class="menu_index">음료/사이드</th>
					</tr>
				</thead>
			</table>
			<div class="menu_tbl_box">
				<div id="background">
					<table id="menu_tbl_2">
						<tbody id="menu_tbl_tbody">
							
						</tbody>
						
					</table>
				</div>
			</div>
		</div>
	<div class="order_section">
		<form action="order" method="post">
			<table id="cart_tbl">
				<tr>
					<th id="cart_food">담은 음식</th>
					<th id="cart_cnt">수량</th>
					<th id="cart_price">가격</th>
					<th id="cart_del">삭제</th>
				</tr>
				
				<tbody id="cart_tbl_tbody">
				</tbody>
			</table>
			<table id="order_tbl">
				<tbody id="order_tbl_tbody">
					<tr>
						<th id="order_totalCnt">총 수량</th>
						<th id="order_totalPrice">총 가격</th>
					</tr>
					<tr>
						<th><input type="text" id="totalCnt" readonly></th>
						<th><input type="text" id="totalPrice" readonly></th>
					</tr>
					<tr>
						<th></th>
						<th><input type="submit" id="order_btn" value="주문하기"></th>
					</tr>
				</tbody>
			</table>
			
		<c:if test="${forhere != null }">
			<input type="hidden" name="type" value="매장">		
		</c:if>
		<c:if test="${togo != null }">
			<input type="hidden" name="type" value="포장">
		</c:if>
		<input type="hidden" name="tableNum" id="tableNum">
	</form>
	</div>
	</section>
	
	<script src="/resources/js/menu.js"></script>
</body>
</html>