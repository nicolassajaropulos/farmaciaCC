$(document).ready(function(){
	
	$('#tbl-products').on('click', '.btn-delete', function(){
		
		var id = $(this).data('id');
		
		$.ajax({
			url: '/productos/'+id+'/eliminar',
			type: 'DELETE',
			success: function (data) {
				alert('¡Borrado éxitoso!');
				window.location.href = "/productos";
			},
			error: function (xhr, desc, err) {
				console.log(xhr);
				console.log('Error:' + err + ' Desc:' + desc);
			}
		});
		
	});
	
});