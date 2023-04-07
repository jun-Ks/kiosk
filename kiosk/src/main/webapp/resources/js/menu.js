//테이블 넘버 생성
$(document).ready(getTableNum);
function getTableNum(){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText; 
		$("#tableNum").val(result);
	}
			
	xhttp.open("GET", "/user/table-nums", true); 
		
	xhttp.send();
};
	
//메뉴 페이지 로딩시 인기메뉴 출력
 $(document).ready(function(){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		$("#menu_tbl_tbody").empty();
		let result = this.responseText; 
		let foods = JSON.parse(result);
		$("#menu_tbl_tbody").empty();

		for(let i = 0; i < foods.length; i++){
		    if(i % 4 === 0 && i > 0){
		        $("#menu_tbl_tbody").append("<tr>");
		    }
		    $("#menu_tbl_tbody").append(
		        "<td>" +
		            "<img src='/resources/productImg/"+foods[i].img+"' id='productImg'>" +
		            "<br>" +
		            foods[i].name+
		            "<hr>"+
		            foods[i].price+
		            "<hr>"+
		            "<button id='addCart' value="+foods[i].foodCode+">담기</button>"+ 
		        "</td>"
		    );
		}
	}
	xhttp.open("GET", "/user/foodlist?category=인기", true); 
		
	xhttp.send();
});

//카테고리 클릭 시, 메뉴 출력
$("#menu_tbl").on("click", "#menu_tbl_thead", function(e){
	let category = $(e.target).text();
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			
			let result = this.responseText; 
			let foods = JSON.parse(result);
			$("#menu_tbl_tbody").empty();

			for(let i = 0; i < foods.length; i++){
			    if(i % 4 === 0 && i > 0){
			        $("#menu_tbl_tbody").append("<tr>");
			    }
			    $("#menu_tbl_tbody").append(
			        "<td>" +
			            "<img src='/resources/productImg/"+foods[i].img+"' id='productImg'>" +
			            "<br>" +
			            foods[i].name+
			            "<hr>"+
			            foods[i].price+
			            "<hr>"+
			            "<button id='addCart' value="+foods[i].foodCode+">담기</button>"+ 
			        "</td>"
			    );
			}
			
		}
				
		xhttp.open("GET", "/user/foodlist?category=" + category, true); 
			
		xhttp.send();
	
});

//담기버튼 누르면?
$("#menu_tbl_tbody").on("click", "#addCart", function(e){
	$(".order_section").css("display", "block");
	let foodCode = $(e.target).val();
	let foodCodes = document.querySelectorAll("#foodCode");
	
	for(let i = 0; i < foodCodes.length; i++){
		if(foodCode == foodCodes[i].value){
			alert("이미 담은 음식입니다. \n수량을 조절하시려면 아래 수량 칸을 조절해주세요.")					
			return false;
		}
	}
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText;
		let food = JSON.parse(result);
		$("#cart_tbl_tbody").append(
				"<tr>"+
					"<input type='hidden' id='foodCode' name='foodCode' value='"+food.foodCode+"'>"+
					"<td>"+
						food.name+
					"</td>"+
					"<td id='cntBox'>"+
						"<button type='button' id='minus'> - </button>"+
						"<input type='text' id='cnt' name='totalCnt' value='1' readonly>"+
						"<button type='button' id='plus'> + </button>"+
					"</td>"+
					"<td>"+
						"<input type='hidden' id='realPrice' value='"+food.price+"'>"+
						"<input type='text' id='price' name='totalPrice' value='"+food.price+"' readonly>"+
					"</td>"+
					"<td>"+
						"<button type='button' id='del_cart'> X </button>"+
					"</td>"+
				"</tr>"
				);
		
		getCnt();
	}
			
	xhttp.open("GET", "/user/cart/"+foodCode, true); 
		
	xhttp.send();
	
	
});

//담기창에서 +, - 수량
$("#cart_tbl_tbody").on("click", "#cntBox", controllMinus);
$("#cart_tbl_tbody").on("click", "#cntBox", cotrollPlus);
function controllMinus(e){
	
	if(e.target.id == "minus"){
		let cnt = $(e.target).next().val();
		let result = parseInt(cnt) - 1;
		let price = e.target.parentElement.parentElement.children[3].children[1];
		let realPrice = parseInt(e.target.parentElement.parentElement.children[3].children[0].value);
		
		$(e.target).next().val(result);
		
		if(cnt == 1){
			$(e.target).next().val(1);
		}
		
		price.value = parseInt($(e.target).next().val()) * realPrice;
		
	}
};

//수량조절한계설정
function cotrollPlus(e){
	if(e.target.id == "plus"){
		let cnt = $(e.target).prev().val();
		let result = parseInt(cnt) + 1;
		let plus_cnt = $(e.target).prev().val(result);
		let price = e.target.parentElement.parentElement.children[3].children[1];
		let realPrice = parseInt(e.target.parentElement.parentElement.children[3].children[0].value);
		
		if(cnt == 10){
			alert("최대 10개까지 추가 가능합니다.");
			$(e.target).prev().val(10);
		}
		
		price.value = parseInt($(e.target).prev().val()) * realPrice;
	}
};

//삭제
$("#cart_tbl_tbody").on("click", "#del_cart", function(e){
	$(e.target).parent().parent().remove();
	getCnt();
});

//cnt 수량 구하기
$(document).on("click", "#addCart, #plus, #minus", getCnt);
function getCnt(){
	let cnts = document.querySelectorAll("#cnt");
	let prices = document.querySelectorAll("#price");
	let cnt_val = 0;
	let price_val = 0;
	for(let i = 0; i < cnts.length; i++){
		cnt_val += parseInt(cnts[i].value);
		$("#totalCnt").val(cnt_val);
		
		price_val += parseInt(prices[i].value);
		$("#totalPrice").val(price_val);
	};
	if(cnts.length == 0){
		$("#totalCnt").val(0);
	}
	if(prices.length == 0){
		$("#totalPrice").val(0);
	}
};

//페이지로딩되면 인기카테고리에 css
$(document).ready(function(){
	$(".menu_index").first().css({
		"background-color" : "#C7221E", 
		"color" : "white"
	});
});

//클릭하지 않은 카테고리 white
$(".menu_index").on("click", function(){
	$(this).css({"background-color" : "#C7221E", "color" : "white"});
	$(".menu_index").not(this).css({"background-color" : "white", "color" : "black"});
});

$("#order_btn").on("click", function(){
	if($("#totalCnt").val() == 0){
		alert("음식이 선택되지 않았습니다. \n 선택 후 주문 버튼을 눌러주세요.");
		return false;
	}
})