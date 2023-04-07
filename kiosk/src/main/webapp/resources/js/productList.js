$(document).ready(getList);
function getList() {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		let result = this.responseText;
		let foods = JSON.parse(result);
		
		for(let i = 0; i < foods.length; i++){
			$("tbody").append(
				"<tr>"+
					"<td>"+
						foods[i].foodCode+
					"</td>"+
					"<td>"+
						foods[i].category+
					"</td>"+
					"<td>"+
						"<img src='/resources/productImg/"+foods[i].img+"' id='productImg'>"+
					"</td>"+
					"<td id='foodName'>"+
						"<a href='/admin/products/list/"+foods[i].foodCode+"'>"+
						foods[i].name+
						"</a>"+
					"</td>"+
					"<td>"+
						foods[i].price+
					"</td>"+
					"<td>"+
						foods[i].inventory+
					"</td>"+
					"<td>"+
						foods[i].sales+
					"</td>"
			);
		}
	}
			
	xhttp.open("GET", "/admin/products/list/all", true); 
		
	xhttp.send();
}


