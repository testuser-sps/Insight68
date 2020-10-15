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

table {
	font-size: 12px;
}

table {
	width: 100% !important;
}

#summary-table {
	width: 100% !important;
	margin: 0 auto;
	table-layout: fixed;
	word-wrap: break-word;
}

#activity-table {
	width: 100% !important;
	margin: 0 auto;
	table-layout: fixed;
	word-wrap: break-word;
}

.thtext {
	color: black;
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

div.dataTables_wrapper div.dataTables_filter label {
	margin-left: 33.5em;
	padding-top: 9px;
	font-weight: 600;
	white-space: nowrap;
	text-align: left
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

.junk-border {
	width: 31%;
}

.junk-border input {
	background-color: #fff !important;
	font-size: 14px !important;
	color: #828282 !important;
}

.date-border {
	border: 1px solid #E0E0E0;
	box-shadow: 0px 2px 4px 0.2px rgba(0, 0, 0, 0.06);
	border-radius: 5px;
	font-size: 12px;
}

.date-range {
	padding: 10px;
	background-color: #f2f2f2;
	border-radius: 5px;
}

.date-go {
	padding: 10.9px;
	background-color: #E0E0E0;
	border-radius: 5px;
}

.pagination {
	display: inline-flex;
	border: 1px solid #E0E0E0;
	background: #F7F7F7;
}

.pagination a {
	color: #828282;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	font-size: 13px;
	border-right: 1px solid #E0E0E0;
}

.pagination a:hover {
	color: #333;
	font-weight: 600;
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

#adcheckbox {
	text-align: center;
} /* center checkbox horizontally */
#dtHorizontalExample th, td {
	white-space: nowrap;
}

table.dataTable thead .sorting:after, table.dataTable thead .sorting:before,
	table.dataTable thead .sorting_asc:after, table.dataTable thead .sorting_asc:before,
	table.dataTable thead .sorting_asc_disabled:after, table.dataTable thead .sorting_asc_disabled:before,
	table.dataTable thead .sorting_desc:after, table.dataTable thead .sorting_desc:before,
	table.dataTable thead .sorting_desc_disabled:after, table.dataTable thead .sorting_desc_disabled:before
	{
	bottom: .5em;
}

table thead th {
	color: black;
}

.modal-dialog {
	max-width: 55% !important;
}

#activity-table_info {
	padding-top: 8px;
	padding-left: 20px;
	padding-right: 17rem;
	white-space: nowrap;
	font-size: 14px;
}
#summary-table_info {
	font-size: 14px;
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
								<span class="pl-2 active">Users</span> <i
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
								alt=""> <span class="pl-2">Security</span> <i
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
							<img src="${pageContext.request.contextPath}/images/users.svg"
								alt="">
							<h5 class="pl-2 mt-2">Users List</h5>
						</div>
					</div>
				</div>

				<div class="modal fade" id="userActivities" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">

								<h4 class="modal-title">
									Activities - <span id="uname"></span>
								</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<div class="row clearfix">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="card">
											<div class="body">
												<div class="table-responsive">
													<table
														class="table table-bordered table-striped table-hover js-basic-example dataTable js-exportable"
														id="activity-table">
														<thead>
															<tr>
																<th style="white-space: nowrap;">S.No</th>
																<th style="white-space: nowrap;">Login Time</th>
																<th style="white-space: nowrap;">Logout Time</th>
																<th style="white-space: nowrap;">Time
																	Spent(on website)</th>
																<th style="white-space: nowrap;">Activity</th>
																<th style="display: none;">Token</th>
																<th style="display: none;">Email</th>
															</tr>
														</thead>
														<tbody id="activities">
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				<div class="row clearfix">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="card">
							<div class="body">
								<div class="table-responsive">
									<table
										class="table table-bordered table-striped table-hover js-basic-example dataTable"
										id="summary-table">
										<thead>
											<tr>
												<th style="white-space: nowrap;">S.No</th>
												<th style="white-space: nowrap;">Name</th>
												<th style="white-space: nowrap;">Email</th>
												<th style="white-space: nowrap;">Role</th>
												<th style="white-space: nowrap;">Last Login</th>
												<th style="white-space: nowrap;">Last Logout</th>

											</tr>
										</thead>
										<tbody id="usersList">
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div style="text-align: right; width: 100%; padding: 0;">
					<button id=createuserbutton type="button" value="Next"
						class="createuserbutton btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2">Create
						User</button>
				</div>
				<div id="content" class="createuserform">
					<form method="post" enctype="application/json" id="adminusercreate">
						<!-- Table Data -->
						<div id="userdetails" class="contained-table table-responsive">

							<table class="table table-borderless ">
								<thead>
									<tr>
										<th class="text-truncate">Name</th>
										<th class="text-truncate">Email</th>
										<th class="text-truncate">Password</th>
										<th class="text-truncate">Confirm Password</th>
										<th class="text-truncate">Admin</th>
									</tr>
								</thead>
								<tbody>

									<tr class="">
										<td class="text-capitalize text-truncate"><input
											class="form-control" type="text" id="adusername"
											name="adusername" autocomplete="off" /></td>
										<td class="text-capitalize text-truncate"><input
											class="form-control" type="text" id="ademail" name="ademail"
											autocomplete="off" /></td>
										<td class="text-capitalize text-truncate"><input
											class="form-control" type="password" id="adpassword"
											name="adpassword" autocomplete="off" /></td>
										<td class="colorln text-capitalize text-truncate"><input
											class="form-control" type="password" id="adcpassword"
											name="adcpassword" autocomplete="off" /></td>
										<td class="colorln text-capitalize text-truncate"><input
											type="checkbox" id="adcheckbox" name="adcheckbox"
											autocomplete="off" /></td>

									</tr>
								</tbody>
							</table>
						</div>

						<div class="container">
							<div class="row">
								<div class="col text-right">
									<button id="adminuserdetailsubmit" type="button" value="Next"
										class="toggle-disabled btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2">Submit</button>
								</div>
							</div>
						</div>
					</form>
				</div>

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
	<script
		src="${pageContext.request.contextPath}/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/moment-timezone-with-data-2012-2022.min.js"></script>
	<script>
		var zone = moment.tz.guess();
		var currentTime = moment();
		console.log(zone + ":"
				+ moment(currentTime).format("YYYY-MM-DD HH:mm:ss"));
	</script>

	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/loadingoverlay.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<script src="${pageContext.request.contextPath}/js/enquiry.js"></script>
	<script src="${pageContext.request.contextPath}/js/usercreateadmin.js"></script>
	<script src="${pageContext.request.contextPath}/js/logout.js"></script>
	<script src="${pageContext.request.contextPath}/js/redirecttologin.js"></script>
</body>

</html>