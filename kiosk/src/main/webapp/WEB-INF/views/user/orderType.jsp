<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link rel="stylesheet" href="/resources/css/orderType.css">
</head>
<body>
<header>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
</header>
<c:if test="${result == 1 }">
<table id="orderType_tbl">
	<tr>
		<th id="card">
			<img src="/resources/imgs/card.png" id="card_img"><br>
			카드결제
		</th>
    	<th id="kakao">
	    	<img src="/resources/imgs/kakao.png" id="kakao_img"><br>
	    	카카오페이
    	</th>
    	
	</tr>
</table>
</c:if>
<div class="modal_outer">
	<div id="modal_inner">
		<table id="modal_tbl">
			<tr>
				<th id="index1">주문완료!</th>
			</tr>
			<tr>
				<th id="index2">주문번호</th>
			</tr>
			<tr>
				<th id="tableNum">${tableNum }</th>
			</tr>
			
			<tr>
            	<th id="alert">이 창은 <span id="countdown"></span>초 후에 자동으로 닫힙니다.</th>
			</tr>
		</table>
	</div>
</div>

<script src="/resources/js/orderType.js"></script>
<script>
	$("#kakao").on("click", function(){
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			let result = this.responseText; 
			let order = JSON.parse(result);
			let totalPrice = 0;
			let foodNames = new Array();
			for(let i = 0; i < order.length; i++){
				totalPrice = parseInt(totalPrice) + parseInt(order[i].totalPrice);
				foodNames.push(order[i].name);
			}
			$("#orderType").text(order[0].type);
			
			IMP.init('imp56271727');
			
			IMP.request_pay({
			    pg : 'kakao', 
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '라멘야 : ' + foodNames,
			    amount : totalPrice, //판매 가격
			}, function(rsp) {
			    if ( rsp.success ) {
			        var msg = '결제가 완료되었습니다.';
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        
				    paySuccess();
				    
				    alert(msg);
			        
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        alert(msg);
			    }
			});
		}
				
		xhttp.open("GET", "/user/orderlist/" + ${tableNum}, true); 
			
		xhttp.send();
		
	});
	
	//결제 성공시 state 1로 수정
	function paySuccess(){
		
	 	const xhttp = new XMLHttpRequest();
		xhttp.onload = function() { //이름이 없는 함수 = 익명함수
			let result = this.responseText; 
			
			if(result != 0){
				
				$(".modal_outer").css("display", "block");
				countdown();
			}
		}
		
		xhttp.open("PUT", "/user/state/" + ${tableNum}, true); 
		
		xhttp.send(); 
	}
</script>

</body>
</html>