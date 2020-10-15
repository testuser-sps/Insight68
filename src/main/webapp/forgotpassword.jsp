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
						<a href="index.jsp"> <img src="images/logo.png" />
						</a>
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
						<h4 class="font-weight-bold navy">Forgot Your Password?</h4>
						<p>Enter the email address you use for Insight68, and we'll
							help you create a new password.</p>
						<form id="forgotpasswordform" method="post" enctype="application/json"
							class="pt-1">
							<div class="form-group">
							<label class="font-weight-bold" for="fpemail">Email
							Address</label>
								<input class="form-control" id="fpemail" name="fpemail"
									type="text" placeholder="username@domain.com" minlength="6"
								maxlength="75" autocomplete="off" />
							</div>
							<button type="button" value="Next" id="submitpasswordrecovery"
								class="btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2 ">Next</button>
						</form>
					</div>
					<div class="col-lg-9 offset-lg-2 text-center" id="emailPage"
						style="display: none">

						<p class="navy step2-title">
							Hi, <strong id="UserName"></strong> Please confirm your mail.
						</p>

						<p>
							<img src="images/gmail.png" alt="">
						</p>

						<p>
							We've sent an email to <strong id="userRegisterMail">
								alentdesosa12@gmail.com.</strong>
						</p>

						<p class="mt-2">
							Click the link in the email to confirm your email address and
							start growing with <strong> Insight68</strong> today.
						</p>

						<a id="dymtext"
							href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
							class="btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2" target="_blank">
							<img src="images/mail.svg" class="mb-1" alt=""> Go To Email
						</a>

						<p class="mt-4">Can not see the email? (or) Check your spam
							folder</p>

						<p>
							Your information is safe and secure with <strong>
								Insight68.</strong>
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Optional JavaScript -->
	<script>
		var ctx = "${pageContext.request.contextPath}";
		
	</script>
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
	<script src="js/signup.js"></script>	
	<script src="js/forgetpassword.js"></script>
</body>

</html>