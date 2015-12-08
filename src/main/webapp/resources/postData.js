$(function() {
	var $setlist = $('#list');
	var $setstrategy = $('#select');
	var $food = $('#foodlist');

	$('#submit').on('click', function() {
		var senddata = {
				days: $setlist.val(),
				discount: $setstrategy.val(),
		}
	
		$.ajax({
			type : 'POST',
			url : '/CMPE272/food/expired' + '/' + senddata.days + '/' + senddata.discount,
			data : senddata,
			success : function(){	
				if ($('#foodlist').attr('name') == senddata.days){
				$('#foodlist tr>td').remove();	
				$.ajax({
					type : 'GET',
					url : '/CMPE272/food/expired' + '/' + senddata.days,
					success : function(data) {

						$.each(data, function(i, item) {
							var txt = '';
							txt += "<tr><td>" + item.ProductName + "</td><td>" + item.RowID
									+ "</td><td>" + item.ExpirationDate + "</td><td>"
									+ item.discountMsg + "</td></tr>";
							$food.append(txt);
						});
					},
					error: function(){
						alert('error load data!');
					}
				});
			}},
			error : function(){
				alert('error load data');
			}
		})
	})
})