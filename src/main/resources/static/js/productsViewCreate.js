$(document).ready(function(){
	
	$('.btn-create').click(function(){
		
		var name = $.trim($('#product-name').val());
		var price = $.trim($('#product-price').val());
		
		if (name && price && price > 0) {
			
			let data = {
				"nombre": name,
				"precio": price,
				"estatus": 1
			}
			
			$.ajax({
				url: '/productos/crear',
				contentType: 'application/json',
				data: JSON.stringify(data),
				type: 'POST',
				success: function (data) {
					alert('¡Creación exitosa!');
					window.location.href = "/productos";
				},
				error: function (xhr, desc, err) {
					console.log(xhr);
					console.log('Error:' + err + ' Desc:' + desc);
				}
			});
			
		} else {
			
			alert('Campos nombre y precio obligatorios');
			
			if (price <= 0) {
				
				alert('Precio debe ser mayor a cero');
				
			}
			
		}
		
	});
	
});