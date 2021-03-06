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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/responsive.css">

<!-- Fav icon -->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/images/favicon.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/toastr.min.css">
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

select, .form-control {
	height: 35px !important;
	color: #828282 !important;
	font-weight: 600 !important;
	box-shadow: 0px 2px 8px 2px rgba(0, 0, 0, 0.26);
	border: 1px solid #bdbdbd;
}

table {
	font-size: 12px;
}

.contained-table {
	width: 100%;
	overflow: auto;
}

table {
	width: 100%;
}

thead {
	box-shadow: 0px 1px 8px 1px rgba(0, 0, 0, 0.15);
	color: #BDBDBD;
	border: none;
	border-radius: 5px 0px;
}

tr {
	border-bottom: 1px solid #E0E0E0;
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

.list-group a:hover {
	color: #144A90 !important;
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
	position: fixed;
	bottom: 0;
	width: 80%;
}
</style>

</head>

<body>

	<!-- Header With Nav bar -->
	<div class="fixed-top">

		<!-- Header -->
		<div class="headbg font-weight-bold">
			<div class="container-fluid">
				<div class="row mx-5 py-3">
					<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
						<a class="headmail"
							href="${pageContext.request.contextPath}/admin/coupons.jsp">
							<img
							src="${pageContext.request.contextPath}/images/logo.png"
							width="90" height="50" />
						</a>
					</div>
					<div
						class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 text-right my-auto">
						<a class="headmail font-weight-bold px-2 pointer"
							href="${pageContext.request.contextPath}/index.jsp">INSIGHT68
							Website</a> | <a class="headmail font-weight-bold px-2 pointer"
							href="${pageContext.request.contextPath}/logout">Logout</a> <img
							src="${pageContext.request.contextPath}/images/logout.svg" />
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
								<span class="pl-2 ">Users</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>

							<!-- Pricing Plans
							<a
								href="${pageContext.request.contextPath}/admin/pricingplans.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/pricing plans.svg"
								alt=""> <span class="pl-2">Pricing Plans</span> <i
								class="fal fa-angle-right text-right"></i>
							</a> -->

							<!-- Coupons 
							<a href="${pageContext.request.contextPath}/admin/coupons.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/coupons.svg"
								alt=""> <span class="pl-2 active">Coupons</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>-->

							<!-- Enquires -->
							<a href="${pageContext.request.contextPath}/admin/enquiry.jsp"
								class="text text-truncate"> <img class="mb-1"
								src="${pageContext.request.contextPath}/images/enquires.svg"
								alt=""> <span class="pl-2">Enquires</span> <i
								class="fal fa-angle-right text-right"></i>
							</a>

						</div>

					</div>

				</div>


			</div>

			<!-- Table Content -->
			<div class="col-10 h-100">

				<div class="row my-4">

					<!-- Page title -->
					<div class="col-12 col-sm-12 col-md-2 col-lg-2 col-xl-2 mt-2">
						<div class="d-flex">
							<img src="${pageContext.request.contextPath}/images/coupons.svg"
								alt="">
							<h5 class="pl-2 mt-2 font-weight-bold">Coupons</h5>
						</div>
					</div>

				</div>
				<form method="post" enctype="application/json" id="couponForm">
					<!-- Table Data -->
					<div class="contained-table table-responsive">

						<table class="table table-borderless">
							<thead>
								<tr>
									<th class="text-truncate">User</th>
									<th class="text-truncate">Plan</th>
									<th class="text-truncate">Discount</th>
									<th class="text-truncate">Coupon Code</th>
								</tr>
							</thead>
							<tbody>

								<tr class="font-weight-bold">
									<td class="text-capitalize text-truncate"><input
										type="text" class="form-control" id="userforplan"
										name="userforplan" /></td>
									<td class="colorln text-capitalize text-truncate"><select
										name="plan" id="plan" class="form-control">
											<option>Gold</option>
											<option>Platinum</option>
											<option>Standard</option>
									</select></td>
									<td class="colorln text-capitalize text-truncate"><input
										type="text" class="form-control" id="discountValue"
										name="discountValue" /></td>
									<td class="text text-capitalize text-center"><input
										type="text" class="form-control" id="couponCode" disabled /></td>
								</tr>

							</tbody>
						</table>

					</div>
					<!-- <div class="col-12 text-right">
						<button class="btn btn-navy text-uppercase font-weight-bold">Generate
							and Send Email</button>
					</div>
					<div class="col-12 text-right">
						<button class="btn btn-navy text-uppercase font-weight-bold">Generate</button>
					</div> -->

					<div class="container">
						<div class="row">
							<div class="col-10 text-right">
								<button class="btn btn-navy text-uppercase font-weight-bold"
									type="button" id="generateCouponAndSendEmail">Generate
									& Email</button>
							</div>
							<div class="col text-right">
								<button class="btn btn-navy text-uppercase font-weight-bold"
									type="button" id="generateCoupon">Generate</button>
							</div>
						</div>
					</div>
				</form>
				<!-- Footer -->
				<div class="col-12 d-flex my-3 footer">
					<div class="col-6 footer-copyrights">� Copyright 2020
						insight68.com, inc. All rights reserved.</div>
					<div class="offset-4 col-4 text-right">
						<a href="#" class="footer-text">Terms of Service</a> <span
							class="footer-text">|</span> <a href="#" class="footer-text">Privacy</a>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!--Scrol to top button -->
	<a id="scroll"></a>
	<script>
		var ctx = "${pageContext.request.contextPath}";
		
	</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/loadingoverlay.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<script src="${pageContext.request.contextPath}/js/coupons.js"></script>
</body>

</html>