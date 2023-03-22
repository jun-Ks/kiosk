$("#card").on("click", function(){
	alert("서비스 준비 중 입니다.")
});

function countdown(){
	var countdown = 6;
	
	var countdownInterval = setInterval(function() {
		countdown--;
		$("#countdown").text(countdown);
		
		if (countdown == 0) {
			clearInterval(countdownInterval);
			location.replace("/index"); 
		}
	}, 1000);
}