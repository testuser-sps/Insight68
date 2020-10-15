<!doctype html>
<html lang="en">
<%
	response.setHeader("cache-control", "no-cache");
	response.setHeader("cache-control", "no-store");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("expires", 0);
%>
<%
	if (!(null == session.getAttribute("email"))) {
		response.sendRedirect("/index.jsp");
		return;
	}
%>

<head>
<!-- social media links forgot password -->
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/toastr.min.css">

<!-- Fav icon -->
<link rel="icon" type="image/x-icon" href="images/favicon.ico">
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
				<div class="text-center"></div>
				<div class="im-fluid pt-4">
					<img src="images/sign.png" class="img-fluid" /> </a>
				</div>

				<h6 class="pt-2">
					<a style="color: #e0e0e0;" href="www.Insight68.com">www.Insight68.com</a>
				</h6>
				<!-- <div class="pt-1">
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

					<div class="col-3 col-sm-3 col-xs-12 col-md-4 col-lg-6 mt-3">
						<img src="images/logo.png" /> </a>
					</div>



				</div>

				<div class="row mt-5 pt-5">
					<div class="col-lg-8 offset-lg-2">
						<h4 class="font-weight-bold navy mb-1">Sign in to INSIGHT68</h4>
						<small>Enter your details below</small>
						<form id="signinform" class="pt-4" method="post"
							enctype="application/json">
							<div class="form-group">
								<label class="font-weight-bold" for="email">User Name /
									Email Address</label> <input class="form-control" type="text"
									id="email" name="email" placeholder="username@domain.com" />
							</div>
							<div class="form-group">
								<label class="font-weight-bold" for="signinpassword">Password</label>
								<input class="form-control" type="password"
									placeholder="Password" id="password" name="password" /> <label
									class="font-weight-bold float-right pointer"
									for="signinforgotpassword" style="margin-top: 1%;"> <a
									href="${pageContext.request.contextPath}/forgotpassword.jsp"
									style="color: rgb(95 130 190/ 1);"> Forgot your password?</a>
								</label>
							</div>

							<div>
								<button
									class="btn btn-signnavy font-weight-bold text-uppercase cpx-5"
									type="button" value="Sign in" id="signinformsubmit">Sign
									in</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script>
		var ctx = "${pageContext.request.contextPath}";
	</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery.js"></script>
	<script src="js/popper.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/minJquery.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/loadingoverlay.js" type="text/javascript"></script>
	<script src="js/toastr.min.js"></script>
	<script src="js/cookie.js"></script>
	<script src="js/signin.js"></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-178238759-1"></script>
	<script>
		var ctx = "${pageContext.request.contextPath}";
	</script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-178238759-1');
	</script>

</body>

</html>