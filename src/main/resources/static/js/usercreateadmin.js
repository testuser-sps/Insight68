$(document).ready(function() {
	displayLoginUsers();
	$('.js-exportable').DataTable({
		responsive : true
	});
	$("#utoken").hide();
});

$(document).on('click', '#adminuserdetailsubmit', function() {
	if (!$("#adminusercreate").valid()) {
		return;
	}
	var initiationData = {
		UserName : $('#adusername').val(),
		email : $('#ademail').val(),
		password : $('#adpassword').val(),
		role : $("#adcheckbox").is(":checked") ? 'ADMIN' : 'USER',
	};
	createuseradmin(initiationData);
});
function createuseradmin(initiationData) {
	$.post(ctx + "/createUserByAdmin", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}

		displayLoginUsers();
		$("#adminusercreate").data('validator').resetForm();
		$("#adminusercreate").trigger("reset");
	});
}

$("#adminusercreate").validate({
	rules : {
		adusername : {
			required : true,
			minlength : 3,
			maxlength : 16,
		},
		ademail : {
			required : true,
			email : true
		},
		adpassword : {
			required : true,
			minlength : 8,
			maxlength : 20
		},
		adcpassword : {
			required : true,
			minlength : 8,
			maxlength : 20,
			equalTo : "#adpassword"
		}
	},
	messages : {
		adusername : {
			required : "Please enter Name",
			minlength : "Name must be between 3 and 16 characters",
			maxlength : "Name must be between 3 and 16 characters"
		},
		ademail : {
			required : "Please enter Email Address ",
			email : "Please enter Valid Email Address "
		},
		adpassword : {
			required : "Please enter Password",
			minlength : "Password must be between 8 and 20 characters",
			maxlength : "Password must be between 8 and 20 characters"
		},
		adcpassword : {
			required : "Please enter Confirm Password",
			minlength : "Password length must be 8 characters",
			maxlength : "Password maximum length is 20 characters",
			equalTo : "Password and Confirm password must be same"
		}
	}
});

// form toggle

$("#createuserbutton").on("click", function() {
	$("#content").toggleClass("show");
});

// Loader
$(document).ajaxSend(function(event, jqxhr, settings) {
	$.LoadingOverlay("show", {
		image : "",
		fontawesome : "fa fa-spinner fa-pulse fa-3x fa-fw",
		size : 35,
		maxSize : 12,
		minSize : 4,
	});
});
$(document).ajaxComplete(function(event, jqxhr, settings) {
	$.LoadingOverlay("hide");
});

// Diplay login credential table details
function displayLoginUsers() {
	var userData = {
		zone : zone
	};
	$('#summary-table').dataTable().fnDestroy();
	$.getJSON(ctx + "/displayLoginDetailsOfUser", userData, function(clientsData) {
		var student = '';
		$('#summary-table').dataTable().fnDestroy();
		// ITERATING THROUGH OBJECTS
		var i = 1;
		$.each(clientsData, function(key, value) {

			// CONSTRUCTION OF ROWS HAVING
			// DATA FROM JSON OBJECT
			student += '<tr>';
			student += '<td>' + i + '</td>';
			student += '<td>' + value.UserName + '</td>';

			student += '<td id="activityEmail">' + value.email + '</td>';

			student += '<td>' + value.role + '</td>';

			student += '<td id="activityList"><a href="javascript:void(0);">'
					+ value.recentLoginTime + '</a></td>';
			student += '<td>' + value.recentLogoutTime + '</td>';
			student += '</tr>';
			i++;
		});
		$("#usersList").empty();
		// INSERTING ROWS INTO TABLE
		$('#usersList').append(student);
		$("#summary-table").dataTable({
			"bLengthChange" : false, // used to hide the property
			"fixedHeader" : true,
			"auto-width" : false,
			"bDestroy" : true,
			columns : [ {
				width : '5%'
			}, {
				width : '20%'
			}, {
				width : '30%'
			}, {
				width : '9%'
			}, {
				width : '18%'
			}, {
				width : '18%'
			} ]

		});
	});

}
$(document)
		.delegate(
				'#activityList',
				"click",
				function(event) {// <-- notice where the selector and event
					// is
					var currentRow = $(this).closest("tr");
					var uEmail = currentRow.find("td:eq(2)").text();
					localStorage.removeItem("uName");
					var uName = currentRow.find("td:eq(1)").text();
					$('#uname').html(uName);
					// $('#uname').val(uName);

					var email = uEmail;
					var usersData = {
						email : email,
						zone : zone
					};
					$
							.getJSON(
									ctx + "/getPageTracingDetailsByEmail",
									usersData,
									function(clientsData) {
										var student = '';
										
										$('#activity-table').dataTable()
												.fnDestroy();
										// ITERATING THROUGH OBJECTS
										var i = 1;
										$
												.each(
														clientsData,
														function(key, value) {
															// CONSTRUCTION OF
															// ROWS HAVING
															// DATA FROM JSON
															// OBJECT
															student += '<tr id="'
																	+ i + '">';
															student += '<td class="two">'
																	+ i
																	+ '</td>';
															student += '<td>'
																	+ value.userLoginedTime
																	+ '</td>';
															student += '<td>'
																	+ value.userLogoutTime
																	+ '</td>';
															student += '<td>'
																	+ value.totalTimeSpentOnWebsite
																	+ '</td>';
															student += '<td id="userActivityList" class="clickhere"><a href="javascript:void(0);">Click here</a></td>';
															student += '<td style="display:none;" id="utoken" class="usertoken">'
																	+ value.token
																	+ '</td>';
															student += '<td style="display:none;" id="uemail" class="uemail">'
																	+ value.email
																	+ '</td>';
															student += '</tr>';
															i++;
														});
										$("#activities").empty();
										// INSERTING ROWS INTO TABLE
										$('#activities').append(student);
										$.fn.DataTable.ext.pager.numbers_length = 2;
										$("#activity-table").dataTable({
											"bLengthChange" : false, // used
											// to
											// hide
											// the
											// property
											"fixedHeader" : true,
											"auto-width" : false,
											"bDestroy" : true,
											"searching" : false,
											"pagingType": 'full_numbers_no_ellipses',
											columns : [ {
												width : '14%'
											}, {
												width : '28%'
											}, {
												width : '28%'
											}, {
												width : '30%'
											}, {
												width : '30%'
											}, {
												width : '30%'
											}, {
												width : '30%'
											} ]
										});
									});
					$("#userActivities").modal();

				});
$.fn.DataTable.ext.pager.full_numbers_no_ellipses = function(page, pages){
	   var numbers = [];
	   var buttons = $.fn.DataTable.ext.pager.numbers_length;
	   var half = Math.floor( buttons / 2 );

	   var _range = function ( len, start ){
	      var end;
	   
	      if ( typeof start === "undefined" ){ 
	         start = 0;
	         end = len;

	      } else {
	         end = start;
	         start = len;
	      }

	      var out = []; 
	      for ( var i = start ; i < end; i++ ){ out.push(i); }
	   
	      return out;
	   };
	    

	   if ( pages <= buttons ) {
	      numbers = _range( 0, pages );

	   } else if ( page <= half ) {
	      numbers = _range( 0, buttons);

	   } else if ( page >= pages - 1 - half ) {
	      numbers = _range( pages - buttons, pages );

	   } else {
	      numbers = _range( page - half, page + half + 1);
	   }

	   numbers.DT_el = 'span';

	   return [ 'first', 'previous', numbers, 'next', 'last' ];
	};
	
$(document)
		.delegate(
				'#userActivityList',
				"click",
				function(event) {
					
					$("#childUtTable").remove();
					var rowId = $(this).closest('tr').children('td.two').text();
					var tdDisable = $(this).closest('tr').children(
							'td.clickhere');
					var userSessionToken = $(this).closest('tr').children(
							'td.usertoken').text(); // From table
					var userSessionEmail = $(this).closest('tr').children(
							'td.uemail').text(); // From Table
					var usersData = {
						email : userSessionEmail,
						token : userSessionToken,
						zone : zone
					};
					var row = $(this).closest("tr");
					$
							.getJSON(
									ctx + "/getPagesDetailsByEmailAndToken",
									usersData,
									function(clientsData) {
										var student = '';
										var j = 1;
										student += '<table id="childUtTable" class="table">';
										student += '<thead>';
										student += '<th>Page Name</th>';
										student += '<th>Entry Time</th>';
										student += '<th>Exit Time</th>';
										student += '<th>Time Spent(on page)</th>';
										student += '</thead>';
										if ( clientsData.length == 0 ) {
											student += '<tr><td style="text-align: center;" colspan="4">No Data Available</td></tr>';
									    }else{
										$
												.each(
														clientsData,
														function(key, value) {
															// CONSTRUCTION OF
															// ROWS HAVING
															// DATA FROM JSON
															// OBJECT
															student += '<tr>';
															student += '<td style="white-space: normal;"><a href="javascript:void(0);">'
																	+ value.pageEnteredName
																	+ '</a></td>';
															student += '<td>'
																	+ value.pageEnteredTime
																	+ '</td>';
															student += '<td>'
																	+ value.pageExitedTime
																	+ '</td>';
															student += '<td><a href="javascript:void(0);">'
																	+ value.totalTimeSpentOnPage
																	+ '</td>';
															student += '<td style="display:none;" id="utoken" class="usertoken">'
																	+ value.token
																	+ '</td>';
															student += '<td style="display:none;" id="uemail" class="uemail">'
																	+ value.email
																	+ '</td>';
															student += '</tr>';
															j++;
														});
									    }
										student += '</tbody>';
										student += '</table>';
										$("#childUtTable").remove();
										var insertAfter = $(this).parent();
										$(student).insertAfter(row);
									});
				});