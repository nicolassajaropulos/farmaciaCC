$(document).ready(function(){
	
	$('#tbl-inventario').on('click', '.btn-edit', function(){
		
		var id_inventario = $(this).data('id');
		var cantidad = $(this).closest('tr').find('input').val();
		
		let data = {
			"cantidad": cantidad
		}
		
		if (cantidad >= 0) {
			
			$.ajax({
				url: '/inventario/'+id_inventario+'/actualizar',
				data: JSON.stringify(data),
				contentType: 'application/json',
				type: 'PUT',
				success: function (data) {
					alert('¡Actualización exitosa!');
					window.location.href = "/inventario";
				},
				error: function (xhr, desc, err) {
					console.log(xhr);
					console.log('Error:' + err + ' Desc:' + desc);
				}
			});
			
		} else {
			alert('Cantidad no puede ser menor a cero');
		}
		
	});
	
});