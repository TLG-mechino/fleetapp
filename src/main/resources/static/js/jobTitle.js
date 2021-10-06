/**
 * 
 */

$('document').ready(function() {
	$('table #editButton').on('click', function (event){
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function (jobTitle, status) {
			$('#idEdit').val(jobTitle.id);
			$('#descriptionEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);
		})
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (jobTitle, status) {
			$('#idDetails').val(jobTitle.id);
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
			$('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", ""));
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