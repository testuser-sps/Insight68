$(document).on('click', '#submitdetail1', function() {
	var initiationData = {
		companyDomain : $("#companyDomain").val(),
		companyName : $("#companyName").val(),
	};
});

function submitpage4(initiationData) {
	$.post(ctx + "/accountsetup", initiationData, function(data) {
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
