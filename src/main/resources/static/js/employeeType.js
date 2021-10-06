/**
 * 
 */

$('document').ready(function() {
	$('table #editButton').on('click', function (event){
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function (employeeType, status) {
			$('#idEdit').val(employeeType.id);
			$('#descriptionEdit').val(employeeType.description);
			$('#detailsEdit').val(employeeType.details);
		})
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (employeeType, status) {
			$('#idDetails').val(employeeType.id);
			$('#descriptionDetails').val(employeeType.description);
			$('#detailsDetails').val(employeeType.details);
			$('#lastModifiedByDetails').val(employeeType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employeeType.lastModifiedDate.substr(0,19).replace("T", ""));
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