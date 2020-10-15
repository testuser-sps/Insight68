$(document).ready(function() {
	displayEnquiryUsers();
});

function displayEnquiryUsers() {
	$('#enquiry-table').dataTable().fnDestroy();
 $.getJSON(ctx + "/getAllEnquiryUsers", function (clientsData) {
     var contactinfo = ''; 
  $('#enquiry-table').dataTable().fnDestroy();
                        // ITERATING THROUGH OBJECTS 
						var i = 1;
                        $.each(clientsData, function (key, value) { 
  
                            //CONSTRUCTION OF ROWS HAVING 
                            // DATA FROM JSON OBJECT 
                            contactinfo += '<tr>'; 
                            contactinfo += '<td>' +  
                                value.fName + '</td>'; 
  
                            contactinfo += '<td>' +  
                                value.lName + '</td>'; 
  
                            contactinfo += '<td>' +  
                                value.emailAddress + '</td>'; 
  
                            contactinfo += '<td>' +  
                                value.subject + '</td>';
                            contactinfo += '<td>' +  
                                value.selectProduct + '</td>';
                            contactinfo += '<td>' +  
                                value.message + '</td>';								
								
                            contactinfo += '<td>' +  
                                value.socialMediaId + '</td>';
                            contactinfo += '<td>' +  
                            value.whatsappNumber + '</td>';
                            contactinfo += '</tr>'; 
							i++;
                        }); 
                          $("#contactinfoList").empty();
                        //INSERTING ROWS INTO TABLE  
                        $('#contactinfoList').append(contactinfo); 
						$("#enquiry-table" ).dataTable({                    
            "bLengthChange": false, //used to hide the property
			"fixedHeader": true,
			"auto-width": false,
			"bDestroy" : true,
			 columns: [
         { width: '10%' },
         { width: '15%' },
         { width: '15%' },
         { width: '15%' },
         { width: '15%' },
         { width: '15%' },
		 { width: '10%' },
		 { width: '10%' }
      ]
			
          });
 });
}