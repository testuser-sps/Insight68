$(document).ready(function() {
	displayUsers();
});

function displayUsers() {
	$('#tryforfree-table').dataTable().fnDestroy();
	$.getJSON(ctx + "/getAllInsightUsers", function(clientsData) {
		var tryforfreeinfo = '';
		$('#tryforfree-table').dataTable().fnDestroy();
		// ITERATING THROUGH OBJECTS 
		var i = 1;
		$.each(clientsData, function(key, value) {

			//CONSTRUCTION OF ROWS HAVING 
			// DATA FROM JSON OBJECT 
			tryforfreeinfo += '<tr>';
			tryforfreeinfo += '<td>' + value.firstName + '</td>';

			tryforfreeinfo += '<td>' + value.lastName + '</td>';

			tryforfreeinfo += '<td>' + value.emailAddress + '</td>';

			tryforfreeinfo += '<td>' + value.phoneNumber + '</td>';

			tryforfreeinfo += '<td>' + value.Whatfielddoyouworkin + '</td>';

			tryforfreeinfo += '<td>' + value.Whichofthefollowingbestdescribesyourrole + '</td>';

			tryforfreeinfo += '<td>' + value.companyDomain + '</td>';

			tryforfreeinfo += '<td>' + value.Howmanypeopleworkatyourcompany + '</td>';

			tryforfreeinfo += '</tr>';
			
			i++;
		});
		$("#tryforfreeList").empty();
		//INSERTING ROWS INTO TABLE  
		$('#tryforfreeList').append(tryforfreeinfo);
		$("#tryforfree-table").dataTable({
			"bLengthChange" : false, //used to hide the property
			"fixedHeader" : true,
			"auto-width" : false,
			"bDestroy" : true,
			columns : [ {
				width : '15%'
			}, {
				width : '15%'
			}, {
				width : '25%'
			}, {
				width : '10%'
			}, {
				width : '15%'
			}, {
				width : '10%'
			}, {
				width : '10%'
			}, {
				width : '10%'
			},

			]

		});
	});
}