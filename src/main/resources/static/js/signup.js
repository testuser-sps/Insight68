var ids = ['tryforfree1', 'tryforfree2', 'tryforfree3', 'tryforfree4'];

$(document).ready(function () {
    if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
        loadShowFunction();
    } else {
        loadShowFunction();
    }
    urlReading();
});

$(document).ready(function ($) {

    if (window.history && window.history.pushState) {

        $(window).on('popstate', function () {
            var hashLocation = location.hash;
            var hashSplit = hashLocation.split("#!/");
            var hashName = hashSplit[1];

            if (hashName !== '') {
                var hash = window.location.hash;
                if (hash === '') {
                    loadShowFunction();
                }
            }
        });
    }

});

function loadShowFunction() {
    const queryString = window.location.href;
    if (queryString.includes('signup.jsp')) {
        loadSignUp();
    }
}

/* try for free one validations starts */
$(document).on('change keyup', '.signupclass', function(e){
	   let Disabled = true;
	    $(".signupclass").each(function() {
	      let value = this.value
	      if ((value)&&(value.trim() !=''))
	          {
	            Disabled = false
	          }else{
	            Disabled = true
	            return false
	          }
	    });
	   
	   if(Disabled){
	        $('.toggle-disabled').prop("disabled", true);
	      }else{
	        $('.toggle-disabled').prop("disabled", false);
	      }
	 })


/* try for free one validations ends */

    $("#tryforfree1form").validate({
        rules: {
        	tryforfreefname: {
        		required: true,
        		minlength: 3,
        		maxlength:20,
        		alpha:true,
        	},
        	tryforfreelname:{
        		required: true,
        		minlength: 3,
        		maxlength: 20,
        		alpha:true,
        	},
        	tryforfreeemail: {
                required: true,
                minlength: 8,
        		maxlength: 75,
                emailValidation:true
            },
            tryforfreephone:{
            	required: true,
            	minlength: 10,
            	maxlength: 10,
            	phoneNumberValidation:true
            }
        },
        messages: {
        	tryforfreefname:{
        		required: "Please enter your First Name",
        		minlength: "First Name must be between 3 and 20 characters",
        		maxlength: "First Name must be between 3 and 20 characters",
        		alpha: "First Name allows alphabets and space",
        	},
        	tryforfreelname:{
        		required: "Please enter your Last Name",
        		minlength: "Last Name must be between 3 and 20 characters",
        		maxlength: "Last Name must be between 3 and 20 characters",
        		alpha: "Last Name allows alphabets and space"
        	},
        	
        	tryforfreeemail:{
        		required: "Please enter your Email Address ",
        		minlength: "Email Address must be between 8 and 75 characters",
        		maxlength: "Email Address must be between 8 and 75 characters",
        		emailValidation:"Please enter a Valid Email Address"
        	},
        	tryforfreephone:{
        		required: "Please enter your Phone Number",
        		minlength: "Phone Number must be 10 digits",
        		maxlength: "Phone Number must be 10 digits",
        		phoneNumberValidation:"Phone Number allows Numbers only",
        	}
        	}
    });

/* try for free two validations starts */

$("#tryforfree2form").validate({
    rules: {
    	companyDomain: {
    		companyDomainValidation: true,
    	},
    },
    messages: {
    	companyDomain:{
    		companyDomainValidation: "Company domain must be www.example.com",
    	},
    	}
});

$(document).on('click', '#submitemail', function () {
	if (!$("#tryforfree1form").valid()) {
		return;
	}
    var initiationData = {
        firstName: $("#tryforfreefname").val(),
        lastName: $("#tryforfreelname").val(),
        emailAddress: $('#tryforfreeemail').val(),
        phoneNumber: $('#tryforfreephone').val()
    };
   submitpage1(initiationData);
});

// Regex Validation starts here
$.validator.addMethod("alpha", function(value, element) {
    return this.optional(element) || value == value.match(/^[a-zA-Z\s]+$/);
});

$.validator.addMethod("emailValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z-]+)*$/);
});

$.validator.addMethod("phoneNumberValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^[0-9]*$/);
});

$.validator.addMethod("companyDomainValidation", function(value, element) {
    return this.optional(element) || value == value.match(/^(?!:\/\/)([a-zA-Z0-9-]+\.){0,5}[a-zA-Z0-9-][a-zA-Z0-9-]+\.[a-zA-Z]{2,64}?$/gi);
});

// Regex Validation ends here

function submitpage1(initiationData) {
	
    $.post(ctx+"/signup", initiationData, function (data) {
        if (data.status == 'SUCCESS') {
            var mail = $('#signupemail').val();
            localStorage.setItem('userId', data.id);
            toastr.success(data.message, '', {
                timeOut: 10000
            });
            localStorage.setItem('userDetails', JSON.stringify(initiationData));
            window.history.pushState(null, '', ctx +'/signup.jsp?id=tryforfree2');
            loadSignUp();
            $('#submittryforfree2').prop('disabled', true);
        } else {
            toastr.error(data.message, '', {
                timeOut: 10000
            })
        }
    });
}


$(document).on('click', '#submittryforfree2', function () {
	if (!$("#tryforfree2form").valid()) {
		return;
	}
    var initiationDataTwo = {
    	companyDomain: $("#companyDomain").val(),
    	companyName: $("#companyName").val(),
    	id:  localStorage.getItem('userId')
    };
    validationCheckTwo(initiationDataTwo);
});

function validationCheckTwo(initiationDataTwo) {
	
	
   /*
	 * $("form[id='tryforfree2form']").validate({ rules: { companyDomain:
	 * 'required', companyName: 'required', }, messages: { companyDomain:
	 * 'Please enter the domain name', companyName: 'Please enter the company
	 * name' }, submitHandler: function (form) { alert("We’ve sent an email to
	 * your mail "); submitpage1(initiationDataTwo); } });
	 */
	 
	submitpage2(initiationDataTwo);
}

function submitpage2(initiationDataTwo) {
    $.post(ctx +"/updateSignupDeatails", initiationDataTwo, function (data) {
        if (data.status == 'SUCCESS') {
           
            toastr.success(data.message, '', {
                timeOut: 10000
            });            
            skipPage();
        } else {
            toastr.error(data.message, '', {
                timeOut: 10000
            })
        }
    });
}

$(document).on('change keyup', '.acountsetupclass', function(e){
	   let Disabled = true;
	    $(".acountsetupclass").each(function() {
	      let value = this.value
	      if ((value)&&(value.trim() !=''))
	          {
	            Disabled = false
	          }else{
	            Disabled = true
	            return false
	          }
	    });
	   
	   if(Disabled){
	        $('.toggle-disabled').prop("disabled", true);
	      }else{
	        $('.toggle-disabled').prop("disabled", false);
	      }
	 })
	 
	 

// duplicate function for sign up two form


function skipPage() {
    history.pushState(null, '',ctx + '/signup.jsp?id=tryforfree3');
    loadSignUp();
}

/* try for free two validations ends */

// Sign up Second Page
$(document).on('click', '#submitpassword', function () {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const product = urlParams.get('id');
    var initiationData = {
        id: product,
        password: $("#cppassword").val(),
    };
    submitpage3(initiationData, product);
});

function submitpage3(initiationData, product) {
    $.post(ctx +"/updatePasswordDeatails", initiationData, function (data) {
        if (data.status == 'SUCCESS') {
            setCookie('id', product, '1');
            toastr.success(data.message, '', {
                timeOut: 10000
            });
            window.location.replace("/accountsetup.jsp?id=" + product);
        } else {
            toastr.error(data.message, '', {
                timeOut: 10000
            })
        }
    });
}


// companyDetails

$(document).on('click', '#submitcompanyDetails', function () {
    const product = localStorage.getItem('userId');
    var initiationData = {
        id: product,
        companyDomain: $("#companyDomain").val(),
        companyName: $("#companyName").val(),
    };
    var url = "signup.jsp?id=" + product;
    submitpage4(initiationData, product, url);
});

/* Terms and conditions */
$('#exampleCheck1').click(function () {
    if ($(this).is(':checked')) {
        
        $('#btnfinish').removeAttr('disabled');
        
    } else {
        $('#btnfinish').attr('disabled', true); 
    }
});


function submitpage4(initiationData, id, url) {
    
    $.post(ctx +"/updateSignupDeatails", initiationData, function (data) {
        if (data.status == 'SUCCESS') {
            toastr.success(data.message, '', {
                timeOut: 10000
            });
            window.history.pushState(null, '',ctx + '/signup.jsp?id=tryforfree4');
            loadSignUp();
        } else {
            toastr.error(data.message, '', {
                timeOut: 10000
            })
        }
    });
}


function loadSignUp() {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
   
    if (id) {
        if (id == null) {
            return;
        }
        ids.forEach(val => {
            if ('#' + val !== '#' + id) {
                $('#' + val).hide();
            } else {
                $('#' + val).show();
               
            }
        });
    } else {
      
        history.pushState(null, '',ctx + '/signup.jsp?id=tryforfree1');
        ids.forEach(val => {
            if (val != '#tryforfree1') {
                $('#' + val).hide();
            }
        });
        loadSignUp();
    }
}



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

function urlReading(){
    ResponseURL = window.location.href;
    var domain = ResponseURL.split('=');
	var sToken = localStorage.getItem("secureToken");
	var logoutEmail = localStorage.getItem("uemail",
			$("#email").val());
	
	var pageId = domain[domain.length - 1];
	var userPagedetails = {
		email : logoutEmail,
		token : sToken,
		pageEnteredName : pageId
	};
	
	$.ajax({
		url : ctx + '/individualPageTracing',
		dataType : 'json',
		data : userPagedetails,
		method : 'POST',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("SbmsAuthorization", sToken);
		},
		success : function(data) {
			if (data.status == 'SUCCESS') {
				// window.location.href = ctx + "/logout";
				console.log(data.status);
				// window.location.href = ctx + '/logout';
			} else {
				console.log(data.status);
			}
		},
		error : function(xhr, statusText, err) {
			console.log(xhr.status);
		}
	});
}