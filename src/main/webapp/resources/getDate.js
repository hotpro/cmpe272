$(function() {
	var $food = $('#foodlist');
	$.ajax({
		type : 'GET',
		url : '/CMPE272/food',
		success : function(data) {
			$.each(data, function(i, item) {
				var txt = '';
				txt += "<tr><td>" + item.ProductName + "</td><td>" + item.RowID
						+ "</td><td>" + item.ExpirationDate + "</td><td>"
						+ item.discountMsg + "</td></tr>";
				$food.append(txt);

			});
		}
	});
});