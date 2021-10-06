/**
 * 
 */

$('document').ready(function() {
	$('.table .btn-primary').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(client, status){
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtIdEdit').val(client.id);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);
			$('#txtPhoneEdit').val(client.phone);
			$('#ddlStateEdit').val(client.stateid);
			$('#txtWebsiteEdit').val(client.website);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			// $('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});

	// $('.table .btn-primary').on('click',function(event){
	// 	event.preventDefault();
	// 	var href= $(this).attr('href');
	// 	$.get(href, function(client, status){
	// 		$('#idEdit').val(client.id);
	// 		$('#descriptionEdit').val(client.description);
	// 		$('#codeEdit').val(client.code);
	// 	});
	// 	$('#editModal').modal();
	// });
	//
	// $('.table #detailsButton').on('click',function(event) {
	// 	event.preventDefault();
	// 	var href= $(this).attr('href');
	// 	$.get(href, function(client, status){
	// 		$('#idDetails').val(client.id);
	// 		$('#descriptionDetails').val(client.description);
	// 		$('#codeDetails').val(client.code);
	// 		$('#lastModifiedByDetails').val(client.lastModifiedBy);
	// 		$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
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