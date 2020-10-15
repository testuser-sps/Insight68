<!doctype html>
<html lang="en">

<head>

<jsp:include page="header.jsp"></jsp:include>
<title>INSIGHT68</title>

<style>
@media ( min-width : 320px) and (max-width: 900px) {
	.mt-5 {
		margin-top: 0rem !important;
		margin-bottom: 0rem !important;
	}
	.pt-5 {
		padding-top: 1rem !important;
		padding-bottom: 1rem !important;
	}
}
</style>

</head>
<body>

	<div class="container-fluid">

		<div class="row">

			<div
				class="col-12 col-sm-12 col-xs-12 col-md-5 col-lg-5 bg-navy text-center resdiv"
				style="height: 100vh !important;">

				<h2 class="font-weight-bold white pt-5">Start your free trial
					today.</h2>
				<h6 class="py-2" style="color: #bdbdbd;">No credit card
					required and no software to install. With your trial, you get :</h6>
				<p class="py-2 px-5" style="color: #f2f2f2">Preloaded data or
					upload your own preconfigured processes, dashboards, reports,
					online training and live onboarding webinars.</p>
				<!-- <div class="text-center">
					<a href="signup.jsp" style="box-shadow: none;"
						class="btn btn-signyellow text-capitalize font-weight-bold mr-4 mt-3">
						Start My Free Trial </a>
				</div> -->
				<div class="im-fluid pt-4">
					<a href="index.jsp"> <img src="images/sign.png"
						class="img-fluid" />
					</a>
				</div>

				<h6 class="pt-2">
					<a style="color: #e0e0e0;" href="www.Insight68.com">www.Insight68.com</a>
				</h6>
				<!--<div class="pt-1">
					<a class="pr-2 not-allow"><img src="images/sf.png" /></a> <a
						class="pr-2 not-allow"><img src="images/st.png" /></a> <a
						class="pr-2 not-allow"> <img src="images/sy.png" />
					</a>
				</div>-->
				<p class="foot-text pt-4">© Copyright 2020 insight68.com, inc.
					All rights reserved.</p>

			</div>

			<div class="col-12 col-sm-12 col-xs-12 col-md-7 col-lg-7 cpx-5 py-4"
				style="height: 100vh !important;">

				<div class="row">

					<div class="col-12 col-sm-12 col-xs-12 col-md-4 col-lg-6 mt-3">
						<img src="images/logo.png" />
					</div>

					<!-- <div
						class="col-12 col-sm-12 col-xs-12 col-md-8 col-lg-6 mt-3 pt-3 text-right">
						<p>
							Not a Customer? &nbsp;&nbsp; <a href="signup.jsp"
								class="sign-free font-weight-bold px-3 py-2">Try for Free</a>
						</p>
					</div> -->

				</div>

				<div class="row mt-5 pt-5">
					<div class="col-lg-8 offset-lg-2" id="forgotPage">
						<h4 class="font-weight-bold navy">Change Your Password</h4>
						<p></p>
						<form id="changePasswordform" method="post"
							enctype="application/json" class="pt-1">
							<div class="form-group">
								<label class="font-weight-bold" for="coldpassword">Current
									Password</label> <input class="form-control" id="coldpassword"
									name="coldpassword" type="password"
									placeholder="Current Password" autocomplete="off" />
							</div>
							<div class="form-group">
								<label class="font-weight-bold" for="cnewpassword">New
									Password</label> <input class="form-control" id="cnewpassword"
									name="cnewpassword" type="password" placeholder="New Password"
									autocomplete="off" />
							</div>
							<div class="form-group">
								<label class="font-weight-bold" for="cconfirmpassword">Confirm
									Password</label> <input class="form-control" id="cconfirmpassword"
									name="cconfirmpassword" type="password"
									placeholder="Confirm Password" autocomplete="off" />
							</div>
							<button type="button" value="Next" id="changePasswordbtn"
								class="btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2 ">Update</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Optional JavaScript -->
	<script>
		var ctx = "${pageContext.request.contextPath}";
	</script>
	<!-- For URL Tracking -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery.js"></script>
	<script src="js/popper.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/minJquery.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/toastr.min.js"></script>
	<script src="js/loadingoverlay.js" type="text/javascript"></script>
	<script src="js/cookie.js"></script>
	<script src="js/cPassword.js"></script>
	<script>
		ResponseURL = window.location.href;
		var domain = ResponseURL.split('/')[ResponseURL.split('/').length - 1];
		if (domain === 'changepassword.jsp') {
			var sToken = localStorage.getItem("secureToken");
			var logoutEmail = localStorage.getItem("uemail", $("#email").val());
			var pageName = "changepassword";
			var userPagedetails = {
				email : logoutEmail,
				token : sToken,
				pageEnteredName : pageName
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
						//window.location.href = ctx + '/logout';
					} else {
						console.log(data.status);
					}
				},
				error : function(xhr, statusText, err) {
					console.log(xhr.status);
				}
			});
		}
	</script>
	<script>
	$(document).ajaxSend(function(event, jqxhr, settings) {
		if(settings.url =='/individualPageTracing'){
			return;
		}
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
	</script>
</body>

</html>