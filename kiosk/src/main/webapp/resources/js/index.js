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