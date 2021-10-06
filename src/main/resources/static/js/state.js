/**
 * 
 */

$('document').ready(function() {
	$('table #editButton').on('click', function (event){
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function (state, status) {
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
		})
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (state, status) {
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", ""));
		});
		$('#detailsModal').modal();
	})

	$('table #deleteButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
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