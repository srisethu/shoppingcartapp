function addToCart(obj, productId) {
	if (!$(obj).parent("td").find('input[type="number"]')[0].reportValidity()) {
		return false;
	}
	var formData = JSON.stringify({
		product : {
			productId : productId,
		},
		quantity : $(obj).parent("td").find('input[type="number"]').val()
	});
	$.ajax({
		url : "/addtoCart",
		type : "post",
		data : formData,
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		success : function(d) {
			if (d.status == "success") {
				alert("Item successfully added to cart");
			} else {
				alert("Error while adding Item to cart");
			}
		}
	});
}

$(document).ready(function() {
	calculateTotalAmount();
});

function calculateTotalAmount() {
	var totalAmount = 0.0;
	$("#bookTable td[id*=TotalPrice]").each(function() {
		totalAmount = totalAmount + parseFloat($(this).text());
	});
	$("#apparelTable td[id*=TotalPrice]").each(function() {
		totalAmount = totalAmount + parseFloat($(this).text());
	});
	$("#totalAmount").empty().text(totalAmount);
	if (totalAmount == 0) {
		$("#emptyCart").show();
	}
}

function addUpdateCart(obj, productId, index) {
	if (!$(obj).parent("td").find('input[type="number"]')[0].reportValidity()) {
		return false;
	}
	var formData = JSON.stringify({
		product : {
			productId : productId,
		},
		quantity : $(obj).parent("td").find('input[type="number"]').val()
	});
	$.ajax({
		url : "/updateCart",
		type : "post",
		data : formData,
		dataType : 'json',
		contentType : "application/json; charset=utf-8",
		success : function(d) {
			if (d.status == "success") {
				if (parseInt($(obj).parents("td").find("input[type=number]")
						.val()) == 0) {
					$(obj).parents("tr").remove();
				} else {
					var productName = $(obj).parents("td").find(
							"input[type=number]").attr("id").replace(
							"Quantity" + index, "");
					var newAmount = parseFloat($(
							"#" + productName + "Price" + index).text().trim())
							* parseFloat($(obj).parents("td").find(
									"input[type=number]").val());
					$("#" + productName + "TotalPrice" + index).empty().text(
							newAmount);
				}
				if ($("#bookTable tr").length == 2) {
					$("#bookTable").remove();
				}
				if ($("#apparelTable tr").length == 2) {
					$("#apparelTable").remove();
				}
				calculateTotalAmount();
				alert("Item successfully updated in cart");
			} else {
				alert("Error while updating Item in cart");
			}
		}
	});
}

function removeCartItem(obj, productId, index){
	$(obj).parent("td").find('input[type="number"]').val(0);
	addUpdateCart(obj, productId, index);
}