<!doctype html>
<html lang="en">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="header.jsp"></jsp:include>
<!-- Bootstrap CSS -->
<!-- Fav icon -->
<link rel="icon" type="image/x-icon" href="images/favicon.ico">
<title>INSIGHT68</title>
<style>

#passwordvalmessage {
	display: none;
	background: #f1f1f1;
	color: #000;
	position: relative;
	padding: 20px;
	margin-top: 10px;
}

#passwordvalmessage p {
	padding: 10px 35px;
	font-size: 18px;
}

.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
	content: "";
}

.invalid {
	color: black
}

.invalid:before {
	position: relative;
	left: -35px;
	content: "";
}
</style>
</head>

<body>

	<div class="container-fluid">

		<div class="row">

			<div
				class="col-12 col-sm-12 col-xs-12 col-md-5 col-lg-5 bg-navy text-center resdiv"
				style="height: 100vh !important;">

				<h2 class="font-weight-bold white pt-5 mt-5">Start your free
					trial today.</h2>
				<h6 class="py-2" style="color: #bdbdbd;">No credit card
					required and no software to install. With your trial, you get :</h6>
				<p class="py-2 px-5" style="color: #f2f2f2">Preloaded data or
					upload your own preconfigured processes, dashboards, reports,
					online training and live onboarding webinars.</p>
				<div class="im-fluid pt-4">
					<img src="images/sign.png" />
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

					<div class="col-4">
						<a href="index.jsp"> <img src="images/logo.png" />
						</a>
					</div>

				</div>

				<div class="row mt-5">

					<div class="col-lg-9 offset-lg-2" id="passwordresethide">

						<h4 class="navy mb-0 font-weight-bold">Please create your
							password.</h4>
						<p class="mt-0">Enter your Password below</p>
						<form id="passwordresetform" class="pt-4" method="post" enctype="application/json">
							<div class="form-group">
								<label class="font-weight-bold" for="newpassword">New
									Password</label> <input class="form-control" type="password"
									id="newpassword" name="newpassword" minlength="8"
									maxlength="24" placeholder="Password" />
							</div>
							 <span id="passwordval" style="color: Red; display: none">Password must be (8-24) Characters, contain one upper case letter, one lower case letter, numeric (0-9) and a special character (like!@#%^)</span>

							<ul class="pl-3 my-4">
								<li id="length" class="invalid">At least 8 characters long</li>
								<li id="letter" class="invalid">One lowercase character</li>
								<li id="capital" class="invalid">One Uppercase character</li>
								<li id="number" class="invalid">One number, symbol, or
									whitespace character</li>
							</ul>

							<div>
								<input
									class="btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2"
									id="submitRecoveredpassword" type="button" value="Submit" />
							</div>
						</form>

					</div>
								<div class="col-lg-9 offset-lg-2 text-center" id="emailPage"
						style="display: none">

						<p class="navy step2-title">
							Hi, <strong id="UserName"></strong> your Password is updated.
						</p>



						<p class="mt-2">
							 Click here to return to the login page<strong> Insight68.</strong>
						</p>

						<a id="dymtext"
							href="signin.jsp"
							class="btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2">Sign In
						</a>
						

					

						<p class="mt-4">
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
	<script src="js/forgetpassword.js"></script>
	<script src="js/signup.js"></script>
	<script>
		var myInput = document.getElementById("newpassword");
		var letter = document.getElementById("letter");
		var capital = document.getElementById("capital");
		var number = document.getElementById("number");
		var length = document.getElementById("length");

		// When the user clicks on the password field, show the message box
		myInput.onfocus = function() {
			document.getElementById("passwordvalmessage").style.display = "block";
		}

		// When the user clicks outside of the password field, hide the message box
		myInput.onblur = function() {
			document.getElementById("passwordvalmessage").style.display = "none";
		}

		// When the user starts to type something inside the password field
		myInput.onkeyup = function() {

			var lowerCaseLetters = /[a-z]/g;
			if (myInput.value.match(lowerCaseLetters)) {
				letter.classList.remove("invalid");
				letter.classList.add("valid");
			} else {
				letter.classList.remove("valid");
				letter.classList.add("invalid");
			}

			var upperCaseLetters = /[A-Z]/g;
			if (myInput.value.match(upperCaseLetters)) {
				capital.classList.remove("invalid");
				capital.classList.add("valid");
			} else {
				capital.classList.remove("valid");
				capital.classList.add("invalid");
			}

			var numbers = /^(?=.*[0-9])(?=.*[@!#%^]).*$/g;
			if (myInput.value.match(numbers)) {
				number.classList.remove("invalid");
				number.classList.add("valid");
			} else {
				number.classList.remove("valid");
				number.classList.add("invalid");
			}

			if (myInput.value.length >= 8) {
				length.classList.remove("invalid");
				length.classList.add("valid");
			} else {
				length.classList.remove("valid");
				length.classList.add("invalid");
			}
		}
	</script>
	
</body>

</html>