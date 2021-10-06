/**
 * 
 */

$('document').ready(function() {
	$('table #editButton').on('click', function (event){
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function (location, status) {
			$('#idEdit').val(location.id);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
		})
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (location, status) {
			$('#idDetails').val(location.id);
			$('#cityDetails').val(location.city);
			$('#addressDetails').val(location.address);
			$('#ddlCountryDetails').val(location.countryid);
			$('#ddlStateDetails').val(location.stateid);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", ""));
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