$(document).on('click', '#tryforfreeemailbutton', function() {
	var initiationData = {
		firstName : $("#tryforfreefname").val(),
		lastName : $("#tryforfreelname").val(),
		emailAddress : $('#tryforfreeemail').val(),
	};
	submitpageTryforFree(initiationData);
});
function submitpageTryforFree(initiationData) {
	$.post("/tryforfree", initiationData, function(data) {
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