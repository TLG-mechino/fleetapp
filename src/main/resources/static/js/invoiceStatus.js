/**
 * 
 */

$('document').ready(function() {
	$('table #editButton').on('click', function (event){
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function (invoiceStatus, status) {
			$('#idEdit').val(invoiceStatus.id);
			$('#descriptionEdit').val(invoiceStatus.description);
			$('#detailsEdit').val(invoiceStatus.details);
		})
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (invoiceStatus, status) {
			$('#idDetails').val(invoiceStatus.id);
			$('#descriptionDetails').val(invoiceStatus.description);
			$('#detailsDetails').val(invoiceStatus.details);
			$('#lastModifiedByDetails').val(invoiceStatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoiceStatus.lastModifiedDate.substr(0,19).replace("T", ""));
		});
		$('#detailsModal').modal();
	})

	$('table #deleteButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
	
	// $('.table .btn-primary').on('click',function(event){
	// 	event.preventDefault();
	// 	var href= $(this).attr('href');
	// 	$.get(href, function(country, status){
	// 		$('#idEdit').val(country.id);
	// 		$('#descriptionEdit').val(country.description);
	// 		$('#codeEdit').val(country.code);
	// 	});
	// 	$('#editModal').modal();
	// });
	//
	// $('.table #detailsButton').on('click',function(event) {
	// 	event.preventDefault();
	// 	var href= $(this).attr('href');
	// 	$.get(href, function(country, status){
	// 		$('#idDetails').val(country.id);
	// 		$('#descriptionDetails').val(country.description);
	// 		$('#codeDetails').val(country.code);
	// 		$('#lastModifiedByDetails').val(country.lastModifiedBy);
	// 		$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
	// 	});
	// 	$('#detailsModal').modal();
	// });
	//
	// $('.table #deleteButton').on('click',function(event) {
	// 	event.preventDefault();
	// 	var href = $(this).attr('href');
	// 	$('#deleteModal #delRef').attr('href', href);
	// 	$('#deleteModal').modal();
	// });
});