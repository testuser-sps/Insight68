var total;
var discount;
var discountamount;
var amountSaved;
var plan;
var couponCode;
function displayPricingOnStandardPage(data) {
	plan="Standard";
	$.get(ctx + "/getByPricingPlan", data, function(pricingData) {
		total = pricingData.aiModule + pricingData.inventoryModule
				+ pricingData.schedularOrderLogistics
				+ pricingData.irtClinicalStudied;
		// To clear
		$("#saiModuletableValue").empty();
		$("#sinventoryModuletableValue").empty();
		$("#sschedulartableValue").empty();
		$("#sclinicaltableValue").empty();
		$("#stotalModuletableValue").empty();
		// To Append
		$("#saiModuletableValue").append(pricingData.aiModule);
		$("#sinventoryModuletableValue").append(pricingData.inventoryModule);
		$("#sschedulartableValue").append(pricingData.schedularOrderLogistics);
		$("#sclinicaltableValue").append(pricingData.irtClinicalStudied);
		$("#stotalModuletableValue").append(total);
	});
}

function displayPricingOnGoldPage(data) {
	plan="Gold";
	$.get(ctx + "/getByPricingPlan", data, function(pricingData) {
		total = pricingData.aiModule + pricingData.inventoryModule
				+ pricingData.schedularOrderLogistics
				+ pricingData.irtClinicalStudied;
		// To clear
		$("#gaiModuletableValue").empty();
		$("#ginventoryModuletableValue").empty();
		$("#gschedulartableValue").empty();
		$("#gclinicaltableValue").empty();
		$("#gtotalModuletableValue").empty();
		// To Append
		$("#gaiModuletableValue").append(pricingData.aiModule);
		$("#ginventoryModuletableValue").append(pricingData.inventoryModule);
		$("#gschedulartableValue").append(pricingData.schedularOrderLogistics);
		$("#gclinicaltableValue").append(pricingData.irtClinicalStudied);
		$("#gtotalModuletableValue").append(total);
	});
}

function displayPricingOnPlatinumPage(data) {
	plan="Platinum";
	$.get(ctx + "/getByPricingPlan", data, function(pricingData) {
		total = pricingData.aiModule + pricingData.inventoryModule
				+ pricingData.schedularOrderLogistics
				+ pricingData.irtClinicalStudied;
		// To clear
		$("#paiModuletableValue").empty();
		$("#pinventoryModuletableValue").empty();
		$("#pschedulartableValue").empty();
		$("#pclinicaltableValue").empty();
		$("#ptotalModuletableValue").empty();
		// To Append
		$("#paiModuletableValue").append(pricingData.aiModule);
		$("#pinventoryModuletableValue").append(pricingData.inventoryModule);
		$("#pschedulartableValue").append(pricingData.schedularOrderLogistics);
		$("#pclinicaltableValue").append(pricingData.irtClinicalStudied);
		$("#ptotalModuletableValue").append(total);
	});
}

$(document).on('click', '#standardbn-block', function() {
	var data = {
		pricingPlans : "Standard"
	};
	displayPricingOnStandardPage(data);
});

$(document).on('click', '#goldbn-block', function() {
	var data = {
		pricingPlans : "Gold"
	};
	displayPricingOnGoldPage(data);
});

$(document).on('click', '#platinumbn-block', function() {
	var data = {
		pricingPlans : "Platinum"
	};
	displayPricingOnPlatinumPage(data);
});

// Apply Promo Code for Standard
$(document).on('click', '#applyPromoCodeForStandard', function() {
	 $("#sdiscountpercent").empty();
	 $("#sbeforeDiscount").empty();
	 $("#sAfterDiscount").empty();
	if (!$("#scouponform").valid()) {
		return;
	}
	var initiationData = {
		emailAddress:sessionEmail,
		planName:plan,
		couponCode : $("#scouponsft").val(),
	};
	$.post(ctx + "/getCouponByCouponCode", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			discount = data.discount;
			var main = total;
		    var disc = discount;
		    var dec = (disc / 100).toFixed(2); // its convert 10 into 0.10
		    var mult = main * dec; // gives the value for subtract from main
									// value
		    discountamount = main - mult;
		    amountSaved=mult;
		    couponCode=$("#scouponsft").val();
		    $("#sdiscountpercent").append(discount+"%")
		    $("#sbeforeDiscount").append(mult);
		    $("#sAfterDiscount").append(discountamount);
		    
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
	});
});

// Validation
$("#scouponform").validate({
	rules : {
		scouponsft : {
			required : true,
		},
	}
});

// Apply Promo Code for Gold
$(document).on('click', '#applyPromoCodeForGold', function() {
	 $("#gdiscountpercent").empty();
	 $("#gbeforeDiscount").empty();
	 $("#gAfterDiscount").empty();
	if (!$("#gcouponform").valid()) {
		return;
	}
	var initiationData = {
		emailAddress:sessionEmail,
		planName:plan,
		couponCode : $("#gcouponsft").val(),
	};
	$.post(ctx + "/getCouponByCouponCode", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			discount = data.discount;
			var main = total;
		    var disc = discount;
		    var dec = (disc / 100).toFixed(2); // its convert 10 into 0.10
		    var mult = main * dec; // gives the value for subtract from main
									// value
		    discountamount = main - mult;
		    amountSaved=mult;
		    couponCode=$("#gcouponsft").val();
		    $("#gdiscountpercent").append(discount+"%")
		    $("#gbeforeDiscount").append(mult);
		    $("#gAfterDiscount").append(discountamount);
		    
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
	});
});

// Validation
$("#gcouponform").validate({
	rules : {
		scouponsft : {
			required : true,
		},
	}
});

// Apply Promo Code for Platinum
$(document).on('click', '#applyPromoCodeForplatinum', function() {
	 $("#pdiscountpercent").empty();
	 $("#pbeforeDiscount").empty();
	 $("#pAfterDiscount").empty();
	if (!$("#pcouponform").valid()) {
		return;
	}
	var initiationData = {
		emailAddress:sessionEmail,
		planName:plan,
		couponCode : $("#pcouponsft").val(),
	};
	$.post(ctx + "/getCouponByCouponCode", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			discount = data.discount;
			var main = total;
		    var disc = discount;
		    var dec = (disc / 100).toFixed(2); // its convert 10 into 0.10
		    var mult = main * dec; // gives the value for subtract from main
									// value
		    discountamount = main - mult;
		    amountSaved=mult;
		    couponCode=$("#pcouponsft").val();
		    $("#pdiscountpercent").append(discount+"%")
		    $("#pbeforeDiscount").append(mult);
		    $("#pAfterDiscount").append(discountamount);
		    
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
	});
});

// Validation
$("#pcouponform").validate({
	rules : {
		scouponsft : {
			required : true,
		},
	}
});

// Send Invoice for Standard
$(document).on('click', '#sendInvoiceforStandard', function() {
	var initiationData = {
			planName:plan,
			total:total,
			discount:discount,
			discountInAmount:discountamount,
			amountSaved:amountSaved,
			coupounCode:couponCode
		};
	$.post(ctx + "/SendInvoice", initiationData, function(data) {
		 if (data.status == 'SUCCESS') {
	            toastr.success(data.message, '', {
	                timeOut: 10000
	            });
	        } else {
	            toastr.error(data.message, '', {
	                timeOut: 10000
	            })
	        }
		
	});
});
//Send Invoice for Gold
$(document).on('click', '#sendInvoiceforgold', function() {
	var initiationData = {
			planName:plan,
			total:total,
			discount:discount,
			discountInAmount:discountamount,
			amountSaved:amountSaved,
			coupounCode:couponCode
		};
	$.post(ctx + "/SendInvoice", initiationData, function(data) {
		 if (data.status == 'SUCCESS') {
	            toastr.success(data.message, '', {
	                timeOut: 10000
	            });
	        } else {
	            toastr.error(data.message, '', {
	                timeOut: 10000
	            })
	        }
		
	});
});

//Send Invoice for Platinum
$(document).on('click', '#sendInvoiceforplatinum', function() {
	var initiationData = {
			planName:plan,
			total:total,
			discount:discount,
			discountInAmount:discountamount,
			amountSaved:amountSaved,
			coupounCode:couponCode
		};
	$.post(ctx + "/SendInvoice", initiationData, function(data) {
		 if (data.status == 'SUCCESS') {
	            toastr.success(data.message, '', {
	                timeOut: 10000
	            });
	        } else {
	            toastr.error(data.message, '', {
	                timeOut: 10000
	            })
	        }
		
	});
});

