<!doctype html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("cache-control", "no-cache");
	response.setHeader("cache-control", "no-store");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("expires", 0);
%>

<%
	if (null == session.getAttribute("email")) {
		response.sendRedirect("/signin.jsp");
		return;
	}
	if (("USER").equalsIgnoreCase(session.getAttribute("role").toString())) {
		response.sendRedirect("/index.jsp");
		return;
	}
%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/responsive.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/datatables.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/toastr.min.css">
<!-- Fav icon -->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/images/favicon.ico">
<!-- Font awesome -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">

<title>INSIGHT68</title>

<style>
.sidebar {
	background-color: #fafafa;
	box-shadow: 0px 1px 8px 1px rgba(0, 0, 0, 0.15);
}

.user {
	color: #333;
	font-size: 20px;
}

.logintext {
	font-weight: normal !important;
	color: #BDBDBD;
	font-size: 14px;
}

.role {
	color: #FA9917;
}

.form-group {
	margin-bottom: 4px;
}

.form-control {
	height: 35px !important;
	color: #828282 !important;
	font-weight: 600 !important;
	box-shadow: 0px 2px 8px 2px rgba(0, 0, 0, 0.26);
	border: 1px solid #bdbdbd;
}

.coloremail {
	color: #144A90;
}

.view {
	color: #0EB79F !important;
}

.inputWithIcon input[type="text"] {
	padding-left: 35px;
	font-size: 15px;
	border-radius: 5px;
	box-shadow: 0px 2px 8px 2px rgba(0, 0, 0, 0.12);
	border: 1px solid #BDBDBD;
}

.inputWithIcon {
	position: relative;
}

.inputWithIcon i {
	position: absolute;
	top: 12px;
	left: 12px;
	font-size: 15px;
	color: #bdbdbd;
}

#sidebar-wrapper {
	min-height: 100vh;
	margin-left: -20rem;
	-webkit-transition: margin .25s ease-out;
	-moz-transition: margin .25s ease-out;
	-o-transition: margin .25s ease-out;
	transition: margin .25s ease-out;
}

#sidebar-wrapper .sidebar-heading {
	padding: 0.5rem 1.25rem;
	font-size: 0.8rem;
}

#sidebar-wrapper .list-group {
	width: 13rem;
}

#sidebar-wrapper .list-group a {
	padding-bottom: 15px;
}

#page-content-wrapper {
	min-width: 100vw;
}

#wrapper.toggled #sidebar-wrapper {
	margin-left: 0;
}

@media ( min-width : 768px) {
	#sidebar-wrapper {
		margin-left: 0;
	}
	#page-content-wrapper {
		min-width: 0;
		width: 100%;
	}
	#wrapper.toggled #sidebar-wrapper {
		margin-left: -22rem;
	}
}

.active {
	color: #144A90 !important;
}

.text {
	color: #828282 !important;
	font-size: 0.875em;
	font-weight: 600;
}

.text a {
	color: #0EB79F !important;
	font-weight: 600;
	text-decoration: underline;
}

.footer-copyrights {
	color: #A6A6A6;
	font-size: 12px;
}

.footer-text {
	color: #A2B6C1;
	font-size: 12px;
}

.footer {
	/*position: fixed;*/
	bottom: 0;
	width: 80%;
}

#content {
	display: none;
}

#content.show {
	display: block;
}

.emptydiv {
	height: 46em;
}
</style>

</head>

<body>

	<!-- Header With Nav bar -->
	<div class="fixed-top">

		<!-- Header -->
		<div class="headbgadmin font-weight-bold">
			<div class="container-fluid">
				<div class="row mx-5 py-3">
					<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
						<a class="headmail"
							href="${pageContext.request.contextPath}/admin/adminusercreate.jsp">
							<img src="${pageContext.request.contextPath}/images/logo.png"
							width="90" height="50" />
						</a>
					</div>
					<div
						class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 text-right my-auto">
						<a class="headmailadmin font-weight-bold px-2 pointer"
							href="${pageContext.request.contextPath}/index.jsp">INSIGHT68
							Website</a> | <a class="headmailadmin font-weight-bold px-2 pointer"
							href="javascript:void(0)" id="logout">Logout</a> <img
							src="${pageContext.request.contextPath}/images/adminlogout.svg" />
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Page Body -->
	<div class="container-fluid mt-5 pt-4">
		<div class="row h-100">
			<!-- Side bar -->
			<div class="col-2 h-100 sidebar p-3">

				<div id="wrapper">

					<div class="bg-light border-bottom-0 pt-4" id="sidebar-wrapper">

						<!-- Image And User anem section -->
						<div class="sidebar-heading text-center">
							<div class="my-auto">
								<!--<strong class="user">Albert Joseph</strong>-->
								<p class="logintext">
									Logged as a <br> <strong class="role">Administrator</strong>
								</p>
							</div>
						</div>

						<hr class="w-75 my-4">

						<!-- Navigations -->
						<div class="list-group px-4 mx-3">

							<!-- Users 
							<a href="${pageContext.request.contextPath}/admin/users.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/users.svg" alt="">
								<span class="pl-2">Users</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>-->


							<!-- Users Creation -->
							<a
								href="${pageContext.request.contextPath}/admin/adminusercreate.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/users.svg" alt="">
								<span class="pl-2">Users</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>
							<!-- Pricing Plans 
							<a
								href="${pageContext.request.contextPath}/admin/pricingplans.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/pricing plans.svg"
								alt=""> <span class="pl-2">Pricing Plans</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>-->

							<!-- Coupons
							<a href="${pageContext.request.contextPath}/admin/coupons.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/coupons.svg"
								alt=""> <span class="pl-2">Coupons</span> <i
								class="fal fa-angle-right text-right"></i>
							</a> -->

							<!-- Enquires -->
							<a href="${pageContext.request.contextPath}/admin/enquiry.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/enquires.svg"
								alt=""> <span class="pl-2 ">Enquires</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>

							<!--Security( No of Attempts)  -->
							<a href="${pageContext.request.contextPath}/admin/attempts.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/user security.svg"
								alt=""> <span class="pl-2 active">Security</span> <i
								class="fal fa-angle-right text-right"></i>
								
							</a>
							<a href="${pageContext.request.contextPath}/admin/admintryforfree.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/try@2x.svg"
								alt=""> <span class="pl-2">Tryforfree</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>

						</div>

					</div>

				</div>


			</div>

			<!-- Table Content -->
			<div class="container-fluid col-10 h-100">
				<div class="row my-4">
					<!-- Page title -->
					<div
						class="admindetailsection col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 mt-2">
						<div class="d-flex">
							<img
								src="${pageContext.request.contextPath}/images/user security.svg"
								alt="">
							<h5 class="pl-2 mt-2">Security</h5>
						</div>
					</div>
				</div>
				<form id="attemptsForm">
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label class="font-weight-bold" for="attemptsControlSelect1">Number
									of failed attempts to block the user :</label>
							</div>
						</div>
						<div class="col-2">
							<div class="form-group" id="custom-select">
								<select class="form-control" id="attemptsControlSelect1"
									name="attemptsControlSelect1">
									<option></option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
								</select>
							</div>
						</div>
						<div class="col-4">
							<button type="button" id="attemptssubmitbtn"
								class="btn btn-signnavy font-weight-bold text-uppercase">Submit</button>
						</div>
						<div class="col-2"></div>
					</div>
				</form>
				<div class="emptydiv"></div>

				<!-- Footer -->
				<div class="col-12 d-flex my-3 footer">
					<div class="col-6 footer-copyrights">© Copyright 2020
						insight68.com, inc. All rights reserved.</div>
					<div class="offset-4 col-4 text-right">
						<a href="#" class="footer-text not-allow">Terms of Service</a> <span
							class="footer-text">|</span> <a href="#"
							class="footer-text not-allow">Privacy</a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!--Scrol to top button -->
	<a id="scroll"></a>

	<!-- Optional JavaScript -->
	<script>
		var ctx = "${pageContext.request.contextPath}";
		var sessionEmail = '${email}';
	</script>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/jquery.dataTables.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/loadingoverlay.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<script src="${pageContext.request.contextPath}/js/enquiry.js"></script>
	<script src="${pageContext.request.contextPath}/js/attempts.js"></script>
	<script src="${pageContext.request.contextPath}/js/logout.js"></script>
	<script src="${pageContext.request.contextPath}/js/redirecttologin.js"></script>
</body>

</html>