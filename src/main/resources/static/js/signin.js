$(document).on('click', '#signinformsubmit', function() {
	if (!$("#signinform").valid()) {
		return;
	}
	var initiationDataTwo = {
		email : $("#email").val(),
		password : $("#password").val(),
	};
	login(initiationDataTwo);
});

function login(initiationDataTwo) {
	$.post(ctx + "/login", initiationDataTwo, function(data) {
		if (data.status == 'SUCCESS') {
			localStorage.setItem("uemail", $("#email").val());
			localStorage.setItem("secureToken", data.token);
			localStorage.setItem("firstLoginStatus", data.firstLoginStatus);
			indexPage(data.token);
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			});
			$('#signinform').trigger("reset");
		}
	});
}
function indexPage(token) {
	$.ajax({
		url : ctx + '/home',
		headers : {
			'SbmsAuthorization' : token
		},
		method : 'POST',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("SbmsAuthorization", token);
		},
		success : function(data) {
			if (data.status == 'SUCCESS') {
				if (localStorage.getItem("firstLoginStatus") == 'true') {
					window.location.href = ctx + "/changepassword.jsp";
				} else {
					window.location.href = ctx + "/index.jsp";
				}
			} else {
				toastr.error(data.message, '', {
					timeOut : 10000
				});
			}
		},
		error : function(xhr, statusText, err) {
			toastr.error(xhr.status, '', {
				timeOut : 10000
			});
		}
	});
}
$("#signinform").validate({
	rules : {
		email : {
			required : true,
			email : true,
		},
		password : {
			required : true,
		},
	},
	messages : {
		email : {
			required : 'Please enter the Email Address',
			email : 'Please enter valid Email Address'
		},
		password : {
			required : 'Please enter your Password',
		},
	},
});
$(document).ajaxSend(function(event, jqxhr, settings) {
    $.LoadingOverlay("show", {
        image: "",
        fontawesome: "fa fa-spinner fa-pulse fa-3x fa-fw",
        size: 35,
        maxSize: 12,
        minSize: 4,
    });
});
$(document).ajaxComplete(function(event, jqxhr, settings) {
    $.LoadingOverlay("hide");
});