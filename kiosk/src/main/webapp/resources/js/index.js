$("#a_togo, #a_forhere").on("mouseover", function(e){
	$(this).css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
	$(this).children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});

});
$("#a_togo, #a_forhere").on("mouseleave", function(e){
	$(this).css("background-color", "white");
	$(this).children().css({"background-color" : "#F8D7DA", "color" : "black"});
});

$("#togoimg").on("mouseover", function(e){
	$("#a_togo").css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
	$("#a_togo").children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});
});
$("#togoimg").on("mouseleave", function(e){
	$("#a_togo").css("background-color", "white");
	$("#a_togo").children().css({"background-color" : "#F8D7DA", "color" : "black"});
});

$("#forhereimg").on("mouseover", function(e){
	$("#a_forhere").css({"background-color" : "#EA868F", "transition" : "0.5s ease-in"});
	$("#a_forhere").children().css({"background-color" : "#EA868F", "transition" : "0.5s ease-in", "color" : "white"});
});
$("#forhereimg").on("mouseleave", function(e){
	$("#a_forhere").css("background-color", "white");
	$("#a_forhere").children().css({"background-color" : "#F8D7DA", "color" : "black"});
});

$(".adminLogin").on("click", function(){
	$(".modal_outer").show()
});

$("#close_btn").on("click", function(){
	$(".modal_outer").hide()
});

$("#login").on("click", function(){
	let a_id = $("#id").val();
	let a_pw = $("#pw").val();
	let admin = { id : a_id, pw : a_pw};
	
	let json_admin = JSON.stringify(admin);
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText; 
		if(result == 1){
			location.href = "/admin/products"
		}else{
			alert("로그인 실패.. \n 아이디, 비밀번호를 다시 확인해주세요!")
		}
	}
	xhttp.open("POST", "/admin/login", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(json_admin);
});