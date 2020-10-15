$(document).ready(function() {
	displayEmailId();
});

// CouponCode
function makeid(lengthSpecified) {
	var result = '';
	var userEmail = $('#userforplan').val();
	var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	var finalChar = characters + userEmail;
	var charactersLength = finalChar.length;
	for (var i = 0; i < lengthSpecified; i++) {
		result += finalChar
				.charAt(Math.floor(Math.random() * charactersLength));
	}

	$('#couponCode').val(result);
}
// displayEmailId
function displayEmailId() {
	$.get(ctx + "/displayEmailid", function(data) {
		var markup = "<option value=''>-- Select Email--</option>";
		$(data).each(
				function(index, element) {
					markup += '<option value="' + element + '">' + element
							+ '</option>';
				});
		$("#userforplan").html(markup);
	});
}

$(document).on('click', '#generateCoupon', function() {
	makeid(5);
	if (!$("#couponForm").valid()) {
		return;
	}
	var initiationData = {
		emailAddress : $('#userforplan').val(),
		planName : $('#plan').find(":selected").val(),
		discount : $('#discountValue').val(),
		couponCode : $('#couponCode').val()
	};
	saveCoupons(initiationData);
});

function saveCoupons(initiationData) {
	$.post(ctx + "/saveCouponDetails", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		$("#couponForm").trigger("reset");
	});
}

$(document).on('click', '#generateCouponAndSendEmail', function() {
	makeid(5);
	if (!$("#couponForm").valid()) {
		return;
	}
	var initiationData = {
		emailAddress : $('#userforplan').val(),
		planName : $('#plan').find(":selected").val(),
		discount : $('#discountValue').val(),
		couponCode : $('#couponCode').val()
	};
	saveCouponsAndSendEmail(initiationData);
});

function saveCouponsAndSendEmail(initiationData) {
	$.post(ctx + "/saveCouponDetailsandSendEmail", initiationData, function(
			data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		if (data.status == 'WARNING') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		}
		$("#couponForm").trigger("reset");
	});
}

$("#couponForm").validate({
	rules : {
		userforplan : {
			required : true,
			email : true
		},
		discountValue : {
			required : true,
			digits : true,
			range : [ 0, 60 ]
		},
	},
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