//Default Gold Data Loading
$(document).ready(function() {
	var data = {
		pricingPlans : "Gold"
	};
	displayPricing(data);
});

// Display values on plan select
function displayPricing(data) {
	$.get(ctx + "/getByPricingPlan", data, function(pricingData) {
		var total = pricingData.aiModule + pricingData.inventoryModule
				+ pricingData.schedularOrderLogistics
				+ pricingData.irtClinicalStudied;
		$("#aiModuleValue").val(pricingData.aiModule);
		$("#inventoryValue").val(pricingData.inventoryModule);
		$("#schedularvalue").val(pricingData.schedularOrderLogistics);
		$("#irtClinicalValue").val(pricingData.irtClinicalStudied);
		$("#totalValueCart").val(total);
	});
}

// On change plan Code
function planChanged() {
	var conceptName = $('#plan').find(":selected").val();
	var data = {
		pricingPlans : conceptName
	};
	displayPricing(data);
}

// UpdatePlanCode
$(document).on('click', '#pricingPlanUpdate', function() {
	if (!$("#pricingPlanform").valid()) {
		return;
	}
	var initiationData = {
		aiModule : $("#aiModuleValue").val(),
		inventoryModule : $("#inventoryValue").val(),
		schedularOrderLogistics : $("#schedularvalue").val(),
		irtClinicalStudied : $("#irtClinicalValue").val(),
		pricingPlans : $('#plan').find(":selected").val()
	};
	updatePrice(initiationData);
});

function updatePrice(initiationData) {
	$.post(ctx + "/savePricingDetails", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		displayPricing(initiationData);
	});
}

$(document).on('click', '#pricingCancel', function() {
	$("#pricingPlanform").trigger("reset");
});

// Validation
$("#pricingPlanform").validate({
	rules : {
		aiModuleValue : {
			required : true,
			digits : true
		},
		inventoryValue : {
			required : true,
			digits : true
		},
		schedularvalue : {
			required : true,
			digits : true
		},
		irtClinicalValue : {
			required : true,
			digits : true
		}
	},
});
