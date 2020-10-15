$(document).on('click', '#changePasswordbtn', function() {
	if (!$("#changePasswordform").valid()) {
		return;
	}
	var initiationData = {
		email : localStorage.getItem("uemail"),
		coldpassword : $('#coldpassword').val(),
		cnewpassword : $('#cnewpassword').val(),
		cconfirmpassword : $('#cconfirmpassword').val(),
	};
	createpassword(initiationData);
});
function createpassword(initiationData) {
	$.post(ctx + "/checkUserPassword", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			window.location.href = ctx + '/logout';
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		$("#changePasswordform").data('validator').resetForm();
		$("#changePasswordform").trigger("reset");
	});
}
$("#changePasswordform")
		.validate(
				{
					rules : {
						coldpassword : {
							required : true,
							minlength : 8,
							maxlength : 24,
						},
						cnewpassword : {
							required : true,
							passwordRegex : true,
							minlength : 8,
							maxlength : 24,
							notEqualTo : true
						},
						cconfirmpassword : {
							required : true,
							minlength : 8,
							maxlength : 24,
							equalTo : "#cnewpassword"
						}
					},
					messages : {
						coldpassword : {
							required : "Please enter Current Password",
							minlength : "Current Password must be between 8 and 24 characters",
							maxlength : "Current Password must be between 8 and 24 characters"
						},
						cnewpassword : {
							required : "Please enter New Password",
							notEqualTo : "Current Password and New password should not be same",
							passwordRegex : "New Password must be (8-24) Characters, contain one upper case letter, one lower case letter, numeric (0-9) and a special character (like!@#%^)",
							minlength : "New Password must be between 8 and 24 characters",
							maxlength : "New Password must be between 8 and 24 characters",

						},
						cconfirmpassword : {
							required : "Please enter Confirm Password",
							minlength : "Confirm Password must be between 8 and 24 characters",
							maxlength : "Confirm Password must be between 8 and 24 characters",
							equalTo : "New Password and Confirm password should be same"
						}
					}
				});

$.validator
		.addMethod(
				"passwordRegex",
				function(value, element) {
					return this.optional(element)
							|| value == value
									.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#%^])[0-9a-zA-Z@!#%^]{8,24}$/);
				});

jQuery.validator.addMethod("notEqualTo", function(value, element, param) {
	return this.optional(element) || value != $('#coldpassword').val();
}, "Current Password and New password should not be same");

// Loader
/*$(document).ajaxSend(function(event, jqxhr, settings) {
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
*/