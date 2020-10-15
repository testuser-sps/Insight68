$(document).on('click', '#submitRecoveredpassword', function() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const product = urlParams.get('id');
	var initiationData = {
		id : product,
		password : $('#newpassword').val()
	};
	passwordresetsubmit(initiationData, id)
});

function passwordresetsubmit(initiationData, id) {
	$.post(ctx + "/passwordreset", initiationData, function(data) {
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			window.history.pushState(null, '', ctx + '/signin');
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
			window.history.pushState(null, '', ctx + '/passwordreset.jsp?id='
					+ id);
		}
	});
}