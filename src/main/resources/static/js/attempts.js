$(document).ready(function() {
	displayLoginCount();
});

$(document).on('click', '#attemptssubmitbtn', function() {
	if (!$("#attemptsForm").valid()) {
		return;
	}
	var attemptsData = {
		numberOfLoginAttemptsToAllow : $('#attemptsControlSelect1').val(),
	};
	noofAttempts(attemptsData);

});

$("#attemptsForm").validate({
	rules : {
		attemptsControlSelect1 : 'required',
	},
	messages : {
		attemptsControlSelect1 : 'Please select the no of attempts',

	},

});

function displayLoginCount() {
	$.get(ctx + "/getLoginAttemptsNumber", function(clientsData) {
		$('#attemptsControlSelect1').val(clientsData);
	});
}

function noofAttempts(attemptsData) {
	$.post(ctx + "/numberOfLoginAttempts", attemptsData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			displayLoginCount();
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
			displayLoginCount();
		}

	});
}