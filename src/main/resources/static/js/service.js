$(document).on('click', '#serviceFromBtn', function() {
	if (!$("#serviceFrom").valid()) {
		return;
	}
	const serviceData = {
		fName : $("#sffirstName").val(),
		lName : $("#sflastName").val(),
		emailAddress : $('#sfemail').val(),
		subject : $('#sfsubject').val(),
		selectProduct : $('#sfControlSelect1').val(),
		socialMediaId : $('#sfsocialmediaid').val(),
		whatsappNumber : $('#swhatsappnumber').val(),
		message : $('#sfmessage').val(),
	};
	console.log($('#swhatsappnumber').val());
	servicesFromSubmit(serviceData);
});

$("#serviceFrom").validate({
	rules : {
		sffirstName : {
			required : true,
			minlength : 3,
			maxlength : 20
		},
		sflastName : {
			required : true,
			minlength : 1,
			maxlength : 20
		},
		sfemail : {
			required : true,
			email : true,
			minlength : 8,
			maxlength : 75
		},
		sfsubject : {
			required : true,
			minlength : 5,
			maxlength : 100
		},
		sfControlSelect1 : 'required',
		sfsocialmediaid : 'required',
		swhatsappnumber : {
			required : true,
			minlength : 10,
			maxlength : 10,
			whatsappNumberValidation : true
		},
		sfmessage : {
			required : true,
			minlength : 10,
			maxlength : 500
		},
	},
	messages : {
		sffirstName : {
			required : "Please enter your First Name",
			minlength : "First Name must be between 3 and 20 characters",
			maxlength : "First Name must be between 3 and 20 characters"
		},
		sflastName : {
			required : "Please enter your Last Name",
			minlength : "Last Name must be between 3 and 20 characters",
			maxlength : "Last Name must be between 3 and 20 characters"
		},
		sfemail : {
			required : "Please enter your Email Address",
			email : "Please enter valid Email Address",
			minlength : "Email Address must be between 8 and 75 characters",
			maxlength : "Email Address must be between 8 and 75 characters"
		},
		sfsubject : {
			required : "Please enter your Subject",
			minlength : "Subject must be between 5 to 100 characters",
			maxlength : "Subject must be between 5 to 100 characters"
		},
		sfControlSelect1 : 'Please select the Product',
		sfsocialmediaid : 'Please enter your Skype ID / Whatsapp Number',
		swhatsappnumber : {
			required : "Please enter your Whatsapp Number",
			minlength : "Whatsapp Number must be 10 digits ",
			maxlength : "Whatsapp Number must be 10 digits",
			whatsappNumberValidation:"Whatsapp Number allows Numbers only",
		},
		sfmessage : {
			required : "Please enter your Message",
			minlength : "Message must be between 10 and 500 characters",
			maxlength : "Message must be between 10 and 500 characters"
		}
	},
});
$.validator.addMethod("whatsappNumberValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^[0-9]*$/);
});

function servicesFromSubmit(Data) {
	

	$.post(ctx + "/contactus", Data, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			$("#serviceFrom").trigger("reset");
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}

	});
}