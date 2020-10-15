$(document).on('click', '#submitContactDetails', function() {
	if (!$("#contactform").valid()) {
		return;
	}
	const initiationData = {
		fName : $("#cufirstName").val(),
		lName : $("#culastName").val(),
		emailAddress : $('#cuemail').val(),
		subject : $('#cusubject').val(),
		selectProduct : $('#exampleFormControlSelect1').val(),
		socialMediaId : $('#cusocialmediaid').val(),
		whatsappNumber :$('#cuwhatsappnumber').val(),
		message : $('#message').val(),
	};

	contactUs(initiationData);
});

$("#contactform").validate({
	rules : {
		cufirstName : {
			required : true,
			minlength : 3,
			maxlength : 20
		},
		culastName : {
			required : true,
			minlength : 1,
			maxlength : 20
		},
		cuemail : {
			required : true,
			email : true,
			minlength : 8,
			maxlength : 75
		},
		cusubject : {
			required : true,
			minlength : 5,
			maxlength : 100
		},
		exampleFormControlSelect1 : 'required',
		cusocialmediaid : 'required',
		cuwhatsappnumber : {
			required : true,
			minlength : 10,
			maxlength : 10,
			whatsappNumberValidation : true
		},
		message : {
			required : true,
			minlength : 10,
			maxlength : 500
		}
	},
	messages : {
		cufirstName : {
			required : "Please enter your First Name",
			minlength : "First Name must be between 3 and 20 characters",
			maxlength : "First Name must be between 3 and 20 characters"
		},
		culastName : {
			required : "Please enter your Last Name",
			minlength : "Last Name must be between 1 and 20 characters",
			maxlength : "Last Name must be between 1 and 20 characters"
		},
		cuemail : {
			required : "Please enter your Email Address",
			email : "Please enter valid Email Address",
			minlength : "Email Address must be between 8 and 75 characters",
			maxlength : "Email Address must be between 8 and 75 characters"
		},
		cusubject : {
			required : "Please enter your Subject",
			minlength : "Subject must be between 5 to 100 characters",
			maxlength : "Subject must be between 5 to 100 characters"
		},
		exampleFormControlSelect1 : 'Please select a Product',
		cusocialmediaid : 'Please enter your Skype ID',
		cuwhatsappnumber : {
			required : "Please enter your Whatsapp Number",
			minlength : "Whatsapp Number must be 10 digits",
			maxlength : "Whatsapp Number must be 10 digits",
			whatsappNumberValidation:"Whatsapp Number allows Numbers only",
		},
		message : {
			required : "Please enter your Message",
			minlength : "Message must be between 10 and 500 characters",
			maxlength : "Message must be between 10 and 500 characters"
		}

	},

});
$.validator.addMethod("whatsappNumberValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^[0-9]*$/);
});

function contactUs(initiationData) {
	
	$.post(ctx + "/contactus", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			$("#contactform").trigger("reset");
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		if (data.status == 'WARNING') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			$("#contactform").trigger("reset");
		}
	});
}