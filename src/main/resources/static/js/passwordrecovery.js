$(document).on('click', '#submitemail', function() {
	var initiationData = {
		//emailbutton
	};
});

function passwordrecoverysubmit(initiationData) {
	$.post(ctx + "/passwordrecovery", initiationData, function(data) {
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