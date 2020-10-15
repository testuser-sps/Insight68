$(document).on('click', '#supportFromBtn', function() {
	if (!$("#supportFrom").valid()) {
		return;
	}
	var supportData = {
		fName : $("#supfirstName").val(),
		lName : $("#suplastName").val(),
		emailAddress : $('#supemail').val(),
		subject : $('#supsubject').val(),
		selectProduct : $('#supControlSelect1').val(),
		socialMediaId : $('#supsocialmediaid').val(),
		whatsappNumber : $('#suwhatsappnumber').val(),
		message : $('#supmessage').val(),
	};
	supportUs(supportData);

});

$("#supportFrom").validate({
	rules : {
		supfirstName : {
			required : true,
			minlength : 3,
			maxlength : 20
		},
		suplastName : {
			required : true,
			minlength : 1,
			maxlength : 20
		},
		supemail : {
			required : true,
			email : true,
			minlength : 8,
			maxlength : 75,
		},
		supsubject : {
			required : true,
			minlength : 5,
			maxlength : 100
		},
		supControlSelect1 : 'required',
		supsocialmediaid : 'required',
		suwhatsappnumber : {
			required : true,
			minlength : 10,
			maxlength : 10,
			whatsappNumberValidation : true
		},
		supmessage : {
			required : true,
			minlength : 10,
			maxlength : 500
		}
	},
	messages : {
		supfirstName : {
			required : "Please enter your First Name",
			minlength : "First Name must be between 3 and 20 characters",
			maxlength : "First Name must be between 3 and 20 characters"
		},
		suplastName : {
			required : "Please enter your Last Name",
			minlength : "Last Name must be between 3 and 20 characters",
			maxlength : "Last Name must be between 3 and 20 characters"
		},
		supemail : {
			required : "Please enter your Email Address",
			email : "Please enter valid Email Address",
			minlength : "Email Address must be between 8 and 75 characters",
			maxlength : "Email Address must be between 8 and 75 characters"
		},
		supsubject : {
			required : "Please enter your Subject",
			minlength : "Subject must be between 5 to 100 characters",
			maxlength : "Subject must be between 5 to 100 characters"
		},
		supControlSelect1 : 'Please select the Product',
		supsocialmediaid : 'Please enter your Skype ID',
		suwhatsappnumber : {
			required : "Please enter your Whatsapp Number",
			minlength : "Whatsapp Number must be 10 digits",
			maxlength : "Whatsapp Number must be 10 digits",
			whatsappNumberValidation:"Whatsapp Number allows Numbers only",
		},
		supmessage : {
			required : "Please enter your Message",
			minlength : "Message must be between 10 and 500 characters",
			maxlength : "Message must be between 10 and 500 characters"
		}

	},

});
$.validator.addMethod("whatsappNumberValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^[0-9]*$/);
});

function supportUs(supportData) {
	
	$.post(ctx + "/contactus", supportData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			$("#supportFrom").trigger("reset");
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}

	});
}