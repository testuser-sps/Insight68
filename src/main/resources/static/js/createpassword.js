$(document).on('click', '#submitaccountsetup', function() {
	var initiationData = {
		cppassword : $("#cppassword").val()
	};
});

function submitpage3(initiationData) {
	$.post(ctx + "/createpassword", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
	});
}