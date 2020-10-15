<!doctype html>
<html lang="en">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/toastr.min.css"> -->
<!-- Fav icon -->
<link rel="icon" type="image/x-icon" href="images/favicon.ico">
<title>INSIGHT68</title>

</head>

<body>

	<div class="container-fluid">

		<div class="row">

			<div
				class="col-12 col-sm-12 col-xs-12 col-md-5 col-lg-5 bg-navy text-center resdiv"
				style="height: 100vh !important;">

				<h2 class="font-weight-bold white pt-5 mt-5">Start your free
					trial today.</h2>
					<h6 class="py-2" style="color: #bdbdbd;">No credit card required and no software to install. With your
						trial, you get :</h6>
						<p class="py-2 px-5" style="color:#f2f2f2">Preloaded data or upload your own
							preconfigured processes, dashboards, reports, online training and live onboarding webinars.</p>
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
				<p class="foot-text pt-4">� Copyright 2020 insight68.com, inc.
					All rights reserved.</p>

			</div>

			<div class="col-12 col-sm-12 col-xs-12 col-md-7 col-lg-7 cpx-5 py-4"
				style="height: 100vh !important;">

				<div class="row">

					<div class="col-6 col-sm-6 col-md-4 col-g-4 col-xl-4">
						<a href="index.jsp"> <img src="images/logo.png" />
						</a>
					</div>



					<!-- <a href="signin.jsp"
						class="col-12 col-sm-12 col-md-4 col-g-4 col-xl-4 mt-4 sign-up-nav pointer">
						<img src="images/arrow-left.svg" alt=""> <strong>Go
							back to existing user</strong>
					</a> -->

				</div>

				<div class="row mt-5">
					<div class="col-lg-9 offset-lg-2">
						<h4 class="font-weight-bold navy mb-1">Sign up now to start
							your free trial.</h4>
						<small>Enter your details below</small>
						<form class="pt-4" id="signupform" action="index.jsp">
							<div class="row">
								<div class="col-12 col-sm-12 col-xs-12 col-md-12 col-lg-12">
									<div class="form-group">
										<label class="font-weight-bold" for="tryforfreefname">First
											Name</label> <input class="form-control" type="text" id="tryforfreefname"
											name="tryforfreefname" minlength="3" maxlength="20"
											placeholder="Enter First Name" />
									</div>
								</div>
								<div class="col-12 col-sm-12 col-xs-12 col-md-12 col-lg-12">
									<div class="form-group">
										<label class="font-weight-bold" for="tryforfreelname">Last
											Name</label> <input class="form-control" type="text" id="tryforfreelname"
											name="tryforfreelname" minlength="3" maxlength="20"
											placeholder="Enter Last Name" />
									</div>
								</div>
								<div class="col-12 col-sm-12 col-xs-12 col-md-12 col-lg-12">
									<div class="form-group">
										<label class="font-weight-bold" for="tryforfreeemail">Email
											Address</label> <input class="form-control" type="text"
											id="tryforfreeemail" name="tryforfreeemail" minlength="6"
											maxlength="75" placeholder="Enter Email Address" />
									</div>
								</div>
							</div>
							<button id="tryforfreeemailbutton" type="submit" value="Submit"
								class=" btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2 ">Submit</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery.js"></script>
	<script src="js/popper.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/signup.js"></script>
	<script src="js/minJquery.js"></script>
	<script src="js/cookie.js"></script>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	<script src="js/toastr.min.js"></script>
	<script src="js/tryforfree.js"></script>

	<script>
		$(document).ready(function() {
			$('form[id="signupform"]').validate({
				rules : {
					signupfname : 'required',
					signuplname : 'required',
					signupemail : {
						required : true,
						email : true,
					}
				},
				messages : {
					signupfname : 'Please enter the firstname',
					signuplname : 'Please enter the lastname',
					signupemail : 'Please enter a valid email'
				},
				submitHandler : function(form) {
					form.submit();
				}

			});
		});
	</script>
</body>

</html>