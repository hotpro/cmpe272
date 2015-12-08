$(function() {
	var $food = $('#foodlist');

	if ($('#foodlist').attr('name') == "all") {
		$.ajax({
			type : 'GET',

			url : '/CMPE272/food',

			success : function(data) {
				$.each(data, function(i, item) {
					var txt = '';
					txt += "<tr><td>" + item.ProductName + "</td><td>"
							+ item.RowID + "</td><td>" + item.ExpirationDate
							+ "</td><td>" + item.discountMsg + "</td></tr>";
					$food.append(txt);
				});
			},
			error : function() {
				alert('error load data!');
			}
		});
	}
	
	else {
		$.ajax({
			type : 'GET',

			url : '/CMPE272/food/expired/' + $('#foodlist').attr('name'),

			success : function(data) {
				$.each(data, function(i, item) {
					var txt = '';
					txt += "<tr><td>" + item.ProductName + "</td><td>"
							+ item.RowID + "</td><td>" + item.ExpirationDate
							+ "</td><td>" + item.discountMsg + "</td></tr>";
					$food.append(txt);
				});
			},
			error : function() {
				alert('error load data!');
			}
		});
	}
});