$(document).on('click', '#submitpasswordrecovery', function() {
	if (!$("#forgotpasswordform").valid()) {
		return;
	}
	var initiationData = {
		email : $('#fpemail').val()
	};
	forgotpasswordmess(initiationData);

});

function forgotpasswordmess(initiationData) {
	$.post(ctx + "/recoverPasswordDeatails", initiationData, function(data) {

		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {

				timeOut : 10000
			});

			$("#forgotpasswordform").trigger("reset");

			loadDataInForgotPassword(initiationData.email);
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
			$("#forgotpasswordform").trigger("reset");
		}
	});
}

$("#forgotpasswordform").validate({
	rules : {
		fpemail : {
			required : true,
			email : true,
		},
	},
	messages : {
		fpemail : {
			required : "Please enter your Email Address",
			email : "Please enter valid Email Address"
		}
	},

});

// ResetPassword

$(document).on('click', '#submitRecoveredpassword', function() {
	if (!$("#passwordresetform").valid()) {
		return;
	}
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const product = urlParams.get('id');
	var initiationData = {
		id : product,
		password : $('#newpassword').val()
	};
	passwordresetsubmitform(initiationData, product);

});

function passwordresetsubmitform(initiationData, id) {
	$.post(ctx + "/passwordreset", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			$("#passwordresetform").trigger("reset");
			loadDataInPasswordUpdate(initiationData);
			
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			});
		}
	});
	$(document).ready(function() {
		var uri = window.location.toString();
		if (uri.indexOf("?") > 0) {
			var clean_uri = uri.substring(0, uri.indexOf("?"));
			window.history.replaceState({}, document.title, clean_uri);
		}
	});
}

$("#passwordresetform")
		.validate(
				{
					rules : {
						newpassword : {
							required : true,
							minlength : 8,
							passwordRegex : true,
						}
					},
					messages : {
						newpassword : {
							required : "Please enter the new password",
							minlength : "Password length must be 8 characters",
							passwordRegex : "Password must be (8-24) Characters, contain one upper case letter, one lower case letter, numeric (0-9) and a special character (like!@#%^)"

						}
					},

				});

$.validator
		.addMethod(
				"passwordRegex",
				function(value, element) {
					return this.optional(element)
							|| value == value
									.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#%^])[0-9a-zA-Z@!#%^]{8,24}$/);
				});

function loadDataInForgotPassword(mail) {
	
	document.getElementById('userRegisterMail').innerHTML = mail;

	// Email manipulation
	/* const userDetails = JSON.parse(localStorage.setItem('userDetails')); */
	const email = mail;
	const indexAt = email.lastIndexOf("@");
	
	email.charAt(indexAt);
	const gmail = email.slice(indexAt + 1);
	var patt = /gmail.com/i;

	if (!patt.test(gmail)) {
		$('#dymtext').hide();
	}

	// Email manipulation End
	$("#emailPage").show();
	$("#forgotPage").hide();

}
function loadDataInPasswordUpdate() {
	// Email manipulation End
	$("#emailPage").show();
	$("#passwordresethide").hide();

}

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