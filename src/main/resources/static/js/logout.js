var sToken = localStorage.getItem("secureToken");
var logoutEmail = localStorage.getItem("uemail",$("#email").val());
$(document).on('click', '#logout', function() {
	var userEmail = {
		email : logoutEmail,
		token : sToken

	};
	$.ajax({
		url : ctx + '/updateLoginLogout',
		dataType : 'json',
		data : userEmail,
		method : 'POST',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("SbmsAuthorization", sToken);
		},
		success : function(data) {
			if (data.status == 'SUCCESS') {
				// window.location.href = ctx + "/logout";
				console.log(data.status);
				window.location.href = ctx + '/logout';
			} else {
				/* toastr.error(data.message, '', {
					timeOut : 10000
				}); */
				window.location.href = ctx + '/logout';
			}
		},
		error : function(xhr, statusText, err) {
			/* toastr.error(xhr.status, '', {
				timeOut : 10000
			}); */
			window.location.href = ctx + '/logout';
		}
	});
});
