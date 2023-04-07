$("#del_btn").on("click", function(){
	let code = $("#foodCode").val();
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText;
		if(result == 1){
			alert("삭제완료");
			location.href="/admin/products/list";
		}else{
			alert("삭제실패!");
		}
	}
	xhttp.open("DELETE", "/admin/products/list/d/" + code);
	xhttp.send();
});

function setThumbnail(event) {
    let reader = new FileReader();
    reader.onload = function(event) {
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        $("#preview_img").html(img)
    };
    reader.readAsDataURL(event.target.files[0]);
}

$("#submit").on("click", function(){
	let uCode = $("#foodCode").val();
	let uName = $("#name").val();
	let uPrice = $("#price").val();
	let uCategory = $("#category").val();
	let uInventory = $("#inventory").val();
	let uSales = $("#sales").val();
	
	let obj_food = {
			foodCode : uCode,
			name : uName,
			price : uPrice,
			category : uCategory,
			inventory : uInventory,
			sales : uSales
	};

	let json_food = JSON.stringify(obj_food);
	
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText;
		alert(result);
	}
	xhttp.open("PUT", "/admin/products/list/u/" + uCode, true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(json_food);
});