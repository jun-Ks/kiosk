<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<style>
	#menu_tbl_thead{
		cursor: pointer;
	}
</style>
<body>
<h1>메뉴페이지</h1>
<hr>

<c:if test="${forhere != null }">
<h3>매장에서 식사하기 선택하셨습니다</h3>
</c:if>
<c:if test="${togo != null }">
<h3>포장해서 가져가기 선택하셨습니다</h3>
</c:if>

<hr>
<table id="menu_tbl" border="1">
	<thead id="menu_tbl_thead">
		<tr>
			<th>인기</th><th>라멘</th><th>토핑</th><th>사이드메뉴</th>
		</tr>
	</thead>
</table>
<table border="1">
	<tbody id="menu_tbl_tbody">
		<tr>
			<td id="tr"></td>
		</tr>
	</tbody>
</table>
<hr>
<table border="1">
	<tr>
		<th>음식코드</th>
		<th>담은 음식</th>
		<th>수량</th>
		<th>가격</th>
	</tr>
	<tbody id="cart_tbl_tbody">
	</tbody>
</table>
<hr>
<table border="1" id="order_tbl" style="display: none">
	<tr>
		<th>수량</th>
		<th>총 가격</th>
	</tr>
</table>
	<script>
		//메뉴 페이지 로딩시 인기메뉴 출력
		$(document).ready(function(){
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				$("#menu_tbl_tbody").empty();
				let result = this.responseText; 
				let foods = JSON.parse(result);
				for(let i = 0; i < foods.length; i++){
					$("#menu_tbl_tbody").append(
							"<tr>"+
								"<td>"+
									"이미지"+
								"</td>"+
							"</tr>"+
							"<tr>"+
								"<td>"+
									foods[i].name +
								"</td>"+
							"</tr>"+
							"<tr>"+
								"<td>"+
									foods[i].price + 
								"</td>"+
							"</tr>"+
							"<tr>"+
								"<th>"+
									"<button id='addCart' value="+foods[i].foodCode+">담기</button>"+ 
								"</th>"+
							"</tr>");
				}
			}
					
			xhttp.open("GET", "/user/foodlist?category=인기", true); 
				
			xhttp.send();
		
		})
		//카테고리 클릭 시, 메뉴 출력
		$("#menu_tbl").on("click", "#menu_tbl_thead", function(e){
			let category = $(e.target).text();
			
			
				const xhttp = new XMLHttpRequest();
				xhttp.onload = function() {
					
					$("#menu_tbl_tbody").empty();
					let result = this.responseText; 
					let foods = JSON.parse(result);
					
					$("#menu_tbl_tbody").append(
							"<tr>");
					for(let i = 0; i < foods.length; i++){
						$("#menu_tbl_tbody").append(
								"<td>"+
									"이미지"+ 
								"</td>"+
							"</tr>");
					}
					$("#menu_tbl_tbody").append(
							"<tr>");
					for(let i = 0; i < foods.length; i++){
						$("#menu_tbl_tbody").append(
								"<td>"+
									foods[i].name+ 
								"</td>"+
							"</tr>");
					}
					$("#menu_tbl_tbody").append(
							"<tr>");
					for(let i = 0; i < foods.length; i++){
						$("#menu_tbl_tbody").append(
								"<td>"+
									foods[i].price+ 
								"</td>"+
							"</tr>");
					}
					$("#menu_tbl_tbody").append(
					"<tr>");
					for(let i = 0; i < foods.length; i++){
						$("#menu_tbl_tbody").append(
								"<td>"+
									"<button id='addCart' value="+foods[i].foodCode+">담기</button>"+ 
								"</td>"+
							"</tr>");
					}
					
				}
						
				xhttp.open("GET", "/user/foodlist?category=" + category, true); 
					
				xhttp.send();
			
		});
		
		//담기버튼 누르면?
		$("#menu_tbl_tbody").on("click", "#addCart", function(e){
			let foodCode = $(e.target).val();
			
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				let result = this.responseText;
				let food = JSON.parse(result);
				$("#cart_tbl_tbody").append(
						"<tr>"+
							"<td>"+
								"<input type='text' id='foodCode' value='"+food.foodCode+"'>"+
							"</td>"+
							"<td>"+
								food.name+
							"</td>"+
							"<td id='cntBox'>"+
								"<button id='minus'> - </button>"+
								"<input type='number' id='cnt' value='1' readonly>"+
								"<button id='plus'> + </button>"+
							"</td>"+
							"<td>"+
								food.price+
							"</td>"+
							"<td>"+
								"<button id='del_cart'>삭제</button>"+
							"</td>"+
						"</tr>"
						);
				
				//주문테이블
				$("#order_tbl").show();
				$("#order_tbl").html(
						"<tr>"+
							"<td>"+
							"<input type='text' id='totalCnt' value='"+$("#cnt").val()+"'>"+
							"</td>"+
						"</tr>");
			}
					
			xhttp.open("GET", "/user/cart/"+foodCode, true); 
				
			xhttp.send();
			
			
		});
		
		//담기창에서 +, - 수량
		$("#cart_tbl_tbody").on("click", "#cntBox", function(e){
			
			if(e.target.id == "minus"){
				let cnt = $(e.target).next().val();
				let result = parseInt(cnt) - 1;
				
				$(e.target).next().val(result);
				
				if(cnt == 1){
					$(e.target).next().val(1);
				}
			}
			
			if(e.target.id == "plus"){
				let cnt = $(e.target).prev().val();
				let result = parseInt(cnt) + 1;
				let plus_cnt = $(e.target).prev().val(result);
				
				if(cnt == 10){
					alert("최대 10개까지 추가 가능합니다.");
					$(e.target).prev().val(10);
				}
			}
		});
		
		//삭제
		$("#cart_tbl_tbody").on("click", "#del_cart", function(e){
			$(e.target).parent().parent().remove();
		});
		
		
	</script>
</body>
</html>