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
</head>
<body>
<c:if test="${result == 1 }">
<input type="hidden" id="tableNum" value="${tableNum }">
<input type="hidden" id="totalPrice">
<input type="hidden" id="foodNames">
<table id="orderType_tbl">
	<tr>
		<th>카드결제</th>
    	<th id="kakao">카카오페이</th>
    	
	</tr>
</table>
</c:if>


<script>
getOrderList();
function getOrderList(){
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
		$("#totalPrice").val(totalPrice);
		$("#foodNames").val(foodNames);
	}
			
	xhttp.open("GET", "/user/orderlist/" + $("#tableNum").val(), true); 
		
	xhttp.send();
}

$("#kakao").on("click", function(){
	IMP.init('imp56271727');
	
	IMP.request_pay({
	    pg : 'kakao', // version 1.1.0부터 지원.
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '라멘야 : ' + $("#foodNames").val(),
	    amount : $("#totalPrice").val(), //판매 가격
	   /*  buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456' */
	}, function(rsp) {
	    if ( rsp.success ) {
	        var msg = '결제가 완료되었습니다.';
	       /*  msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid; */
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
})
</script>

</body>
</html>