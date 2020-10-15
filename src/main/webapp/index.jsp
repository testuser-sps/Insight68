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
		response.sendRedirect("signin.jsp");
		return;
	}
%>
<%-- <%@ include file="header.jsp"%> --%>
<jsp:include page="header.jsp"></jsp:include>

<body>

	<!-- Header With Nav bar -->
	<div class="fixed-top">

		<!-- Primary header -->
		<div class="headbg font-weight-bold">
			<div class="container-fluid">
				<div class="row mx-5 py-3">
					<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
						<a class="headmail font-weight-bold"
							href="mailto:sales@insight68.com"> <img class="mb-1"
							src="images/mail.svg" /> sales@insight68.com
						</a>
					</div>
					<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 text-right">
						<%-- <strong class="headmail pr-2">Welcome <%=%>
							<strong style="color: #F8B62B;"> </strong></strong>  --%>

						<%
							if (("ADMIN").equalsIgnoreCase(session.getAttribute("role").toString())) {
						%>
						<a class="headmail font-weight-bold px-2 pointer"
							href="${pageContext.request.contextPath}/admin/adminusercreate.jsp">Insight68
							Admin</a>|<%
							}
						%>

						<a class="headmail font-weight-bold px-2 pointer"
							href="${pageContext.request.contextPath}/changepassword.jsp">Change
							Password</a> | &nbsp;<a class="headmail font-weight-bold pointer"
							href="javascript:void(0)" id="logout">Logout&nbsp;&nbsp;<img
							src="images/logout.svg" /></a>
					</div>
				</div>
			</div>
		</div>

		<!-- After Login Header -->
		<!--   <div class="headbg font-weight-bold">
      <div class="container-fluid">
        <div class="row mx-5 py-3">
          <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
            <a class="headmail font-weight-bold" href="mailto:sales@insight68.com">
              <img class="mb-1" src="images/mail.svg" />
              sales@insight68.com
            </a>
          </div>
          <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 text-right">
            <strong class="headmail pr-2">Welcome <strong style="color: #F8B62B;">Mohamad</strong></strong>
            <a class="headmail font-weight-bold pointer" href="/index.jsp">Logout</a>
            <img src="/images/logout.svg" />
          </div>
        </div>
      </div>
    </div> -->


		<!-- Secondary Header -->
		<div class="bg-light">
			<div class="container-fluid">
				<nav class="navbar navbar-expand-lg navbar-light mx-5 py-3">
					<a class="navbar-brand" href="index.jsp"><img
						src="images/logo.png" /></a>
					<button class="navbar-toggler" type="button" id="toggle"
						data-toggle="collapse" data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">

						<ul class="navbar-nav mr-auto nav-pad">

							<!-- Products -->
							<li class="nav-item  dropdown indexlist"><a
								class="nav-link dropdown-toggle font-weight-bold" href="#"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">Products <span
									class="sr-only">(current)</span></a>
								<div class="dropdown-menu dropdownmenu1" id="pro-cat"
									aria-labelledby="navbarDropdown">
									<span class="dropdownarrow"></span>
									<div class="row m-0">
										<div
											class="col-12 col-sm-12 col-xs-12 col-md-4 col-lg-4 col-xl-4 p-1"
											style="background-color: #fff;">
											<strong style="color: #333;">Overview</strong>
											<!--JSP links Overview -->
											<a id="pro-insight-block" href="#pro-insight"
												onClick="navigation('pro-insight')"
												class="dropdown-item  mt-3">
												<div style="width: 100%; display: table; overflow: scroll;">
													<span> <img src="images/what.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>What is Insight68?</h6>
														<p style="white-space: normal;">
															<small>Insight68 has over 25 years of experience
																delivering solutions for manufacturers<br> <br>
															<br>
															<br>
															</small>
														</p>
													</span>
												</div>
											</a><a class="dropdown-item" id="pro-overview-block"
												href="#pro-Overview" onClick="navigation('pro-Overview')">
												<div style="width: 100%; display: table; overflow: scroll;">
													<span> <img src="images/ovr.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Digital Transformation with Insight68</h6>
														<p style="white-space: normal;">
															<small>AI-Driven platform driving digital
																transformation with industry solutions in Gene Therapy
																and Auto Tier-n Suppliers</small>
														</p>
													</span>
												</div>
											</a> <a id="pro-platform-block" href="#pro-platform"
												class="dropdown-item" onClick="navigation('pro-platform')">
												<div style="width: 100%; display: table; overflow: scroll;">
													<span> <img src="images/Group.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Platform</h6>
														<p style="white-space: normal;">
															<small>An artificial intelligence enabled and
																scalable cloud platform for manufacturing that is
																designed with leading edge technologies <br> <br>
																<br>
															</small>
														</p>
													</span>
												</div>
											</a>
											<!--  	<a id="pro-industries-block" href="#pro-industries"
												class="dropdown-item" onClick="navigation('pro-industries')">
												<div style="width: 100%; display: table; overflow: scroll;">
													<span> <img src="images/compliances.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Industries</h6>
														<p style="white-space: normal;">
															<small>Life Science, Medical, Automotive,
																Manufacturing, Mining, Food and Beverage<br>
															
															</small>
														</p>
													</span>
												</div>
											</a>-->
										</div>

										<div
											class="col-12 col-sm-12 col-xs-12 col-md-8 col-lg-8 col-xl-8 p-1"
											style="background-color: #fff;">
											<strong style="color: #333;">Insight68 Products</strong>

											<div class="row mt-3">
												<div
													class="col-12 col-sm-12 col-xs-12 col-md-8 col-md-6 col-lg-6">
													<div>

														<!--JSP links Our Insight68 Industry
												Products -->

														<a id="pro-ADR-block" href="#pro-ADR"
															class="dropdown-item" onClick="navigation('pro-ADR')">
															<div
																style="width: 100%; display: table; overflow: scroll;">
																<span> <img src="images/Group.png"
																	style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
																</span> <span
																	style="vertical-align: middle; display: table-cell;">
																	<h6>Analytics Intelligence</h6>
																	<p style="white-space: normal;">
																		<small>Access data in the factory instantly,
																			eliminate data silos and gain actionable insights.
																			NLP driven dashboard for self-service analysis<br>
																		<br>
																		<br>
																		</small>
																	</p>
																</span>
															</div>
														</a> <a class="dropdown-item" id="pro-quality-block"
															href="#pro-quality" onClick="navigation('pro-quality')">
															<div
																style="width: 100%; display: table; overflow: scroll;">
																<span> <img src="images/qty.png"
																	style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
																</span> <span
																	style="vertical-align: middle; display: table-cell;">
																	<h6 style="white-space: normal;">Quality Control
																		Management</h6>
																	<p style="white-space: normal;">
																		<small>A quality control module with LIMS and
																			Quality Management capabilities<br> <br> <br>
																		</small>
																	</p>
																</span>
															</div>
														</a> <a id="pro-inventory-block" href="#pro-inventory"
															class="dropdown-item"
															onClick="navigation('pro-inventory')">
															<div
																style="width: 100%; display: table; overflow: scroll;">
																<span> <img src="images/ivntr.png"
																	style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
																</span> <span
																	style="vertical-align: middle; display: table-cell;">
																	<h6>Inventory Management</h6>
																	<p style="white-space: normal;">
																		<small> Inventory management of materials,
																			AI-Driven replenishment of materials, pick and put
																			plans, storage location management with temperature
																			control and shelf life<br> <br>
																		</small>
																	</p>
																</span>
															</div>
														</a> <a id="pro-equipment-block" href="#pro-equipment"
															class="dropdown-item"
															onClick="navigation('pro-equipment')">
															<div
																style="width: 100%; display: table; overflow: scroll;">
																<span> <img src="images/eqip.png"
																	style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
																</span> <span
																	style="vertical-align: middle; display: table-cell;">
																	<h6>Equipment Management</h6>
																	<p style="white-space: normal;">
																		<small>Asset Management and Maintenance.
																			Remote monitoring, analytics, and configurable
																			workflows</small>
																	</p>
																</span>
															</div>
														</a>
														<!--  -->

													</div>
												</div>
												<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-6">

													<a id="pro-casemanage-block" href="#pro-casemanage"
														class="dropdown-item"
														onClick="navigation('pro-casemanage')">
														<div style="display: table; overflow: scroll;">
															<span> <img src="images/casemanage.png"
																style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
															</span> <span
																style="vertical-align: middle; display: table-cell;">
																<h6>Study Management - IRT</h6>
																<p style="white-space: normal;">
																	<small>Management of all clinical trial phases
																		with advanced analytics. Significantly improve the
																		success of clinical trials through commercialization.
																		Ensure patient safety and security </small>
																</p>
															</span>
														</div>
													</a> <a id="pro-logistics-block" href="#pro-logistics"
														class="dropdown-item"
														onClick="navigation('pro-logistics')">
														<div
															style="width: 100%; display: table; overflow: scroll;">
															<span> <img src="images/logis.png"
																style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
															</span> <span
																style="vertical-align: middle; display: table-cell;">
																<h6>Logistics</h6>
																<p style="white-space: normal;">
																	<small>Logistics Planning, Scheduling for
																		Pickup, and Delivery and Supply Chain Collaboration<br>
																		<br> <br>
																	</small>
																</p>
															</span>
														</div>
													</a> <a id="pro-scheduler-block" href="#pro-scheduler"
														class="dropdown-item"
														onClick="navigation('pro-scheduler')">
														<div
															style="width: 100%; display: table; overflow: scroll;">
															<span> <img src="images/scdh.png"
																style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
															</span> <span
																style="vertical-align: middle; display: table-cell;">
																<h6 style="white-space: normal;">Scheduling and
																	Production Planning</h6>
																<p style="white-space: normal;">
																	<small>Plan and schedule production for
																		manufacturing based on constraints such as inventory,
																		labor, equipment, and demand. JIS scheduling for
																		inventory, manufacturing, and shipping</small>
																</p>
															</span>
														</div>
													</a> <a id="pro-manufacturing-block" href="#pro-manufacturing"
														class="dropdown-item"
														onClick="navigation('pro-manufacturing')">
														<div
															style="width: 100%; display: table; overflow: scroll;">
															<span> <img src="images/manf.png"
																style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
															</span> <span
																style="vertical-align: middle; display: table-cell;">
																<h6>Manufacturing</h6>
																<p style="white-space: normal;">
																	<small>Manage, monitor, and synchronize the
																		execution of real-time physical processes and finished
																		goods </small>
																</p>
															</span>
														</div>
													</a>
												</div>
											</div>
										</div>

									</div>

								</div></li>
							<!-- INDUSTRIES TAB -->
							<li class="nav-item dropdown indexlist"><a
								class="nav-link font-weight-bold dropdown-toggle" href="#"
								id="dropdownSupport" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Industries </a>
								<div id="supportservice"
									class="dropdown-menu dropdownmenuindurstries"
									aria-labelledby="dropdownSupport">
									<span class="dropdownarrowindur"></span>

									<div class="row m-3" style="background-color: #fff !important;">
										<div
											class="col-12 col-sm-12 col-xs-12 col-md-8 col-md-6 col-lg-6">
											<a style="pointer-events: none; display: inline-block;"
												support-block" href="#support" class="dropdown-item"
												onclick="navigation('support')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/industry1.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Personalized Cell Gene Therapy</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a>
											 <a style="pointer-events: none; display: inline-block;"
												legal-block" href="#legal" class="dropdown-item"
												onClick="navigation('legal')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/industryhome4.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Life Science</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a> 
											 <a style="pointer-events: none; display: inline-block;"
												service-block" href="#service" class="dropdown-item"
												onClick="navigation('service')">
												<div style="display: table; overflow: scroll;">
													<span><img src="images/industryhome2.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span><span style="vertical-align: middle; display: table-cell;">
														<h6>Medical Devices</h6>

														<p style="white-space: normal;">
															<small></small>

														</p>
													</span>
												</div>
											</a>
											<a
												style="pointer-events: none; display: inline-block;"
												service-block" href="#service" class="dropdown-item"
												onClick="navigation('service')">
												<div style="display: table; overflow: scroll;">
													<span><img src="images/contr-manuhome.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span><span style="vertical-align: middle; display: table-cell;">
														<h6>Contract Manufacturing for Clinical and Commercial Life Science Companies</h6>

														<p style="white-space: normal;">
															<small></small>

														</p>
													</span>
												</div>
											</a>
											<a style="pointer-events: none; display: inline-block;"
												consultingservice-block" href="#consultingservice"
												class="dropdown-item"
												onClick="navigation('consultingservice')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/industryhome5.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Automotive Tier Suppliers</h6>
														<p style="white-space: normal;">
															<small> </small>
														</p>
													</span>
												</div>
											</a>
											 
										</div>
										<div
											class="col-12 col-sm-12 col-xs-12 col-md-8 col-md-6 col-lg-6">
											<a style="pointer-events: none; display: inline-block;"
												pricing-block" href="#pricing" class="dropdown-item"
												onClick="navigation('pricing')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/porcess-induhome.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Process Industries</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a>
											<br>
											 <a style="pointer-events: none; display: inline-block;"
												pricing-block" href="#pricing" class="dropdown-item"
												onClick="navigation('pricing')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/industryhome3.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Discrete Manufacturers</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a> 
											<a style="pointer-events: none; display: inline-block;"
												support-block" href="#support" class="dropdown-item"
												onclick="navigation('support')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/industryhome6.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Make to Order Manufacturers</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a> 
											 <a style="pointer-events: none; display: inline-block;"
												legal-block" href="#legal" class="dropdown-item"
												onClick="navigation('legal')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/foodbravhome.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Food and Beverage</h6>
														<p style="white-space: normal;">
															<small></small>
														</p>
													</span>
												</div>
											</a>

										</div>
									</div>
								</div></li>
							<!-- Support and Services -->
							<li class="nav-item dropdown indexlist"><a
								class="nav-link font-weight-bold dropdown-toggle" href="#"
								id="dropdownSupport" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Support and
									Services </a>
								<div id="supportservice" class="dropdown-menu dropdownmenu2"
									aria-labelledby="dropdownSupport">
									<span class="dropdownarrow1"></span>

									<div class="row m-0" style="background-color: #fff !important;">
										<div class="col-12 p-1">
											<a id="support-block" href="#support" class="dropdown-item"
												onclick="navigation('support')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/supp.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Support</h6>
														<p style="white-space: normal;">
															<small>360 degree product support (Email, Live
																Chat, and Book a meeting)</small>
														</p>
													</span>
												</div>
											</a> <a id="service-block" href="#service" class="dropdown-item"
												onClick="navigation('service')">
												<div style="display: table; overflow: scroll;">
													<span><img src="images/ovr.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span><span style="vertical-align: middle; display: table-cell;">
														<h6>Services</h6>

														<p style="white-space: normal;">
															<small>Product based services with technical
																support</small>

														</p>
													</span>
												</div>
											</a> <a id="pricing-block" href="#pricing" class="dropdown-item"
												onClick="navigation('pricing')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/pricingplans.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Pricing Plans</h6>
														<p style="white-space: normal;">
															<small>Latest products and services with pricing
																plans (Free Trial, Standard, Gold, and Platinum)</small>
														</p>
													</span>
												</div>
											</a> <a id="legal-block" href="#legal" class="dropdown-item"
												onClick="navigation('legal')">
												<div style="display: table; overflow: scroll;">
													<span> <img
														src="images/Stamp-Contract-Certification-Document-Business.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Legal Documents</h6>
														<p style="white-space: normal;">
															<small>Terms and Conditions for Customer and
																Master Policies</small>
														</p>
													</span>
												</div>
											</a> <a id="consultingservice-block" href="#consultingservice"
												class="dropdown-item"
												onClick="navigation('consultingservice')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/Consulting.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Consulting Services</h6>
														<p style="white-space: normal;">
															<small>Insight68 Consultant and Service
																Advantages </small>
														</p>
													</span>
												</div>
											</a>

										</div>
									</div>
								</div></li>

							<!-- Resources -->
							<li class="nav-item dropdown indexlist"><a
								class="nav-link font-weight-bold dropdown-toggle" href="#"
								id="dropdownresource" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Resources </a>
								<div class="dropdown-menu dropdownmenu3" id="resources"
									aria-labelledby="dropdownresource">
									<span class="dropdownarrow2"></span>

									<div class="row m-3" style="background-color: #fff !important;">
										<div
											class="col-12 col-sm-12 col-xs-12 col-md-8 col-md-6 col-lg-6">
											<a id="customerSuccessStories-block"
												href="#customerSuccessStories" class="dropdown-item"
												onClick="navigation('customerSuccessStories')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/CSS.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Customer Success Stories</h6>
														<p style="white-space: normal;">
															<small>Our clients are happy because we deliver
																best in class software products</small>
														</p>
													</span>
												</div>
											</a> <a id="guide-block" href="#guide" class="dropdown-item"
												onClick="navigation('guide')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/Guides.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Guides and Videos</h6>
														<p style="white-space: normal;">
															<small>Product Documentation and Self-Help Videos<br>
																<br> <br></small>
														</p>
													</span>
												</div>
											</a> <a id="compliance-block" href="#compliance"
												class="dropdown-item" onClick="navigation('compliance')">
												<div style="display: table; overflow: scroll;">

													<span> <img src="images/compliances.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Compliance and Security</h6>
														<p style="white-space: normal;">
															<small>Company and Product Compliance, Security,
																and Privacy</small>
														</p>
													</span>
												</div>
											</a>
										</div>
										<div
											class="col-12 col-sm-12 col-xs-12 col-md-8 col-md-6 col-lg-6">
											<a id="vprotocol-block" href="#vprotocol"
												class="dropdown-item" onClick="navigation('vprotocol')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/validP.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Validation Protocol</h6>
														<p style="white-space: normal;">
															<small>Validation Protocol process for upgrades
																and new releases</small>
														</p>
													</span>
												</div>
											</a> <a id="partner-block" href="#partner" class="dropdown-item"
												onClick="navigation('partner')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/partners.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Partner Programs</h6>
														<p style="white-space: normal;">
															<small>Latest Partner packages and services with
																price (Solutions Provider Package and Solutions Partner
																Package)</small>
														</p>
													</span>
												</div>
											</a> <a id="ccpartner-block" href="#ccpartner"
												class="dropdown-item" onClick="navigation('ccpartner')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/partnerscustomer.svg"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6 style="white-space: normal;">Co-Innovation
															Customer Partner Program</h6>
														<p style="white-space: normal;">
															<small>Innovation Program for driving product
																roadmaps</small>
														</p>
													</span>
												</div>
											</a>
										</div>
									</div>
								</div></li>

							<!-- About Us -->
							<li class="nav-item dropdown indexlist"><a
								class="nav-link font-weight-bold dropdown-toggle" href="#"
								id="dropdownabout" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">About Us</a>
								<div class="dropdown-menu dropdownmenu4"
									aria-labelledby="dropdownabout" id="about">
									<span class="dropdownarrow3"></span>
									<div class="row m-0" style="background-color: #fff !important;">
										<div class="col-12 p-3">
											<a id="ourstory-block" href="#ourstory" class="dropdown-item"
												onClick="navigation('ourstory')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/our story.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Our Story</h6>
														<p style="white-space: normal;">
															<small>We will lead the 4th Revolution by
																simplifying Digital Transformation</small>
														</p>
													</span>
												</div>
											</a> <a id="about-insight-block" href="#about-insight"
												class="dropdown-item" onClick="navigation('about-insight')">
												<div style="display: table; overflow: scroll;">
													<span> <img src="images/what.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>What is Insight68?</h6>
														<p style="white-space: normal;">
															<small>Insight68 has over 25 years of experience
																delivering solutions for manufacturers</small>
														</p>
													</span>
												</div>
											</a> <a id="contactus-block" href="#contactus"
												class="dropdown-item" onClick="navigation('contactus')">
												<div style="display: table; overflow: scroll;">

													<span> <img src="images/supp.png"
														style="position: relative; vertical-align: middle; display: table-cell; margin-right: 15px;">
													</span> <span style="vertical-align: middle; display: table-cell;">
														<h6>Contact Us</h6>
														<p style="white-space: normal;">
															<small style="white-space: normal;">Contact
																Information&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
														</p>
													</span>
												</div>
											</a>
										</div>
									</div>
								</div></li>

						</ul>

						<form class="form-inline my-2 my-lg-0">
							<!-- <a class="pr-4 not-allow"><img src="images/search.svg" /></a> -->
							<a href="signup.jsp"
								class="btn btn-navy text-uppercase font-weight-bold">try for
								free</a>
						</form>

					</div>
				</nav>
			</div>
		</div>

	</div>
	<!-- Banner Section-->
	<div id="indexmain">

		<div class="banner">
			<div class="container-fluid">
				<div class="row mx-5">
					<div
						class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-6 col-xl-6 my-5">
						<img class="img-fluid banner-img" src="images/chart.png" />
					</div>
					<div
						class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-6 col-xl-6 my-5 ">
						<div class="bannertext">
							<span class="font-weight-bold">AI-Driven platform and
								suite of applications driving digital transformation </span> <span
								class="font-weight-lighter">for manufacturers.</span>
						</div>
						<button
							class="btn btn-yellow text-uppercase font-weight-bold mr-4 mt-3 not-allow">see
							how it works</button>
						<a href="signup.jsp"
							class="btn btn-navy text-uppercase font-weight-bold mt-3">try
							for free</a>
					</div>
				</div>

			</div>
		</div>

		<!-- About Our Products  -->
		<div class="text-center pt-5 pb-4 px-3 about">
			<h3 class="text-uppercase font-weight-bold">about our products</h3>
		</div>

		<!-- About Our Products Description -->
		<div class="bgyellow">
			<div class="container">
				<div class="row py-3">

					<div
						class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-6 col-xl-6 mt-3">
						<div class="row pl-5 pt-3">
							<div
								class="col-3 col-sm-3 col-xl-3 col-md-3 col-lg-3 col-xl-3 my-auto">
								<img class="img-fluid" src="images/service.svg" />
							</div>
							<div class="col-9 col-sm-9 col-xs-9 col-md-9 col-lg-9 col-xl-9">
								<p class="product-text font-weight-light my-auto">Scalable
									Cloud platform that delivers a fully configurable suite of
									applications that can be deployed independently or in
									collaboration.</p>
							</div>
						</div>
					</div>
					<div
						class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-6 col-xl-6 mt-3">
						<div class="row pl-5 pt-3">
							<div
								class="col-3 col-sm-3 col-xl-3 col-md-3 col-lg-3 col-xl-3 my-auto">
								<img class="img-fluid" src="images/product.svg" />
							</div>
							<div class="col-9 col-sm-9 col-xs-9 col-md-9 col-lg-9 col-xl-9">
								<p class="product-text font-weight-light my-auto">Manage all
									aspects of your factory or specific functional areas. The
									offering is designed to integrate into your current software
									environment.</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<!-- Card Section Services -->
		<div class="container-fluid">
			<div class="row mx-5 pb-4">
				<!-- Analytics Intelligence Code Start-->
				<div
					class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 col-xl-4 mt-5">
					<div class="service-bod h-100 w-100">
						<a href="#pro-ADR" onClick="navigation('pro-ADR')"> <img src="images/service1.jpg"
							class="w-100"  />
							<div class="about service-textbottom">
								<h6 class="text-uppercase font-weight-bold">Analytics
									Intelligence</h6>
								<p class="my-2">Access data in the factory instantly,
									eliminate data silos and gain actionable insights. NLP driven
									dashboard for self-service analysis</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Analytics Intelligence Code End-->
				<!-- Quality Control Management Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-quality"  onClick="navigation('pro-quality')"> <img src="images/service2.jpg"
							class="w-100" />
							<div class="about service-textbottom">
								<h6 class="text-uppercase font-weight-bold">Quality Control
									Management</h6>
								<p class="my-2">A quality control module with LIMS and
									Quality Management capabilities.</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Quality Control Management Code End-->
				<!-- Inventory Management Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-inventory" onClick="navigation('pro-inventory')"> <img src="images/service3.jpg"
							class="w-100"/>
							<div class="about service-textbottom">
								<h6 class="text-uppercase font-weight-bold">Inventory
									Management</h6>
								<p class="my-2">Inventory management of materials, AI-Driven
									replenishment of materials, pick and put plans, storage
									location management with temperature control and shelf life</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Inventory Management Code End-->
				<!-- Equipment Management Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-equipment"  onClick="navigation('pro-equipment')"> <img src="images/service4.jpg"
							class="w-100" />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Equipment
									Management</h6>
								<p class="my-2">Asset Management and Maintenance. Remote
									monitoring, analytics, and configurable workflows</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Equipment Management Code End-->
				<!-- Study Management - IRT Management Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-casemanage"  onClick="navigation('pro-casemanage')"> <img src="images/service5.jpg"
							class="w-100" />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Study
									Management - IRT</h6>
								<p class="my-2">Management of all clinical trial phases with
									advanced analytics. Significantly improve the success of
									clinical trials through commercialization. Ensure patient
									safety and security</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Study Management - IRT Code End-->
				<!-- Logistics Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-logistics-block" onClick="navigation('pro-logistics')" > <img
							src="images/homelogic.png" class="w-100" />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Logistics</h6>
								<p class="my-2">Logistics Planning, Scheduling for Pickup,
									and Delivery and Supply Chain Collaboration</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Logistics Code End-->
				<!-- Scheduling and Production Planning Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-scheduler" onClick="navigation('pro-scheduler')" > <img src="images/service6.jpg"
							class="w-100" />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Scheduling and
									Production Planning</h6>
								<p class="my-2">Plan and schedule production for
									manufacturing based on constraints such as inventory, labor,
									equipment, and demand. JIS scheduling for inventory,
									manufacturing, and shipping</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Scheduling and Production Planning Code End -->
				<!-- Manufacturing Code Start-->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-manufacturing-block" onClick="navigation('pro-manufacturing')"> <img
							src="images/homemanufacture.jpg" class="w-100"
							 />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Manufacturing</h6>
								<p class="my-2">Manage, monitor, and synchronize the
									execution of real-time physical processes and finished goods</p>
							</div>
						</a>
					</div>
				</div>
				<!-- Manufacturing Code End -->
				<div class="col-12 col-sm-12 col-xs-12 col-md-6 col-lg-4 mt-5">
					<div class="service-bod h-100">
						<a href="#pro-platform" onClick="navigation('pro-platform')"> <img
							src="images/platformhome.jpg" class="w-100"
							 />
							<div class="about service-textbottom h-50">
								<h6 class="text-uppercase font-weight-bold">Platform</h6>
								<p class="my-2">An artificial intelligence enabled and
									scalable cloud platform for manufacturing that is designed with
									leading edge technologies</p>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Divider -->
		<div class="hrpad">
			<hr>
		</div>

		<!-- Platform & Industries -->
		<!--  <div class="container-fluid">
			<div class="row mx-5 px-5 pb-5">

			 Platforms 
				<div
					class="col-12 col-sm-12 col-xs-12 col-md-12 col-lg-6 col-xl-6 mt-4">
					<h3>
						<a href="#pro-platform" onclick="navigation('pro-platform')">
							Platform</a>
					</h3>
					<div class="sectionpoints pl-3">
						<div>
							<img src="images/li.png" /> <span class="pl-2">Process
								and Discrete manufacturing</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Regulatory
								compliant: FDA 21 CFR Part 11 compliant, GDPR, HIPPA</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">AI driven,
								embedded intelligent configurable workflows to drive predictions
								and actions</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Big data
								technology to support analysis and actionable insights</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Native
								intuitive android application with offline sync mode</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">NLP
								technology for data analysis, no SQL</span>
						</div>

					</div>

				</div>

				
				<div
					class="col-12 col-sm-12 col-xs-12 col-md-12 col-lg-6 col-xl-6 mt-4">
					<h3>
						<a href="#pro-industries" onclick="navigation('pro-industries')">Industries</a>
					</h3>
					<div class="sectionpoints pl-3">
						<div>
							<img src="images/li.png" /> <span class="pl-2">Personalized
								Gene and Cell Therapy</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Contract
								Manufacturing for Clinical and Commercial Life Science companies</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Life
								Science</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Medical
								Device</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Discrete
								Manufacturers</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Automotive
								Tier Suppliers</span>
						</div>
						<div>
							<img src="images/li.png" /> <span class="pl-2">Make to
								Order Manufacturers</span>
						</div>
					</div>
				</div>

			</div>
		</div>  -->

	</div>

	<!-- First List JSP -->
	<div class="mt-5" id="pro-insight" style="display: none">
		<jsp:include page="pro-insight.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-Overview" style="display: none">
		<jsp:include page="pro-overview.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-industries" style="display: none">
		<jsp:include page="pro-industries.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-platform" style="display: none">
		<jsp:include page="pro-platform.jsp"></jsp:include>
	</div>
	<!--Second List JSP -->
	<div class="mt-5" id="pro-ADR" style="display: none">
		<jsp:include page="pro-ADR.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-quality" style="display: none">
		<jsp:include page="pro-quality.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-inventory" style="display: none">
		<jsp:include page="pro-inventory.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-casemanage" style="display: none">
		<jsp:include page="pro-casemanage.jsp"></jsp:include>
	</div>

	<!--Third List JSP -->
	<div class="mt-5" id="pro-equipment" style="display: none">
		<jsp:include page="pro-equipment.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-logistics" style="display: none">
		<jsp:include page="pro-logistics.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-scheduler" style="display: none">
		<jsp:include page="pro-scheduler.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pro-manufacturing" style="display: none">
		<jsp:include page="pro-manufacturing.jsp"></jsp:include>
	</div>

	<!--  Support and Services  -->

	<div class="mt-5" id="support" style="display: none">
		<jsp:include page="support.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="service" style="display: none">
		<jsp:include page="service.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="pricing" style="display: none">
		<jsp:include page="pricing.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="freetrailbn" style="display: none">
		<jsp:include page="freetrailbn.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="standardbn" style="display: none">
		<jsp:include page="standardbn.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="goldbn" style="display: none">
		<jsp:include page="goldbn.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="platinumbn" style="display: none">
		<jsp:include page="platinumbn.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="legal" style="display: none">
		<jsp:include page="legal.jsp"></jsp:include>
	</div>

	<div class="mt-5" id="consultingservice" style="display: none">
		<jsp:include page="consultingservice.jsp"></jsp:include>
	</div>

	<!-- Resources -->

	<div class="mt-5" id="customerSuccessStories" style="display: none">
		<jsp:include page="customerSuccessStories.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="guide" style="display: none">
		<jsp:include page="guide.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="compliance" style="display: none">
		<jsp:include page="compliance.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="vprotocol" style="display: none">
		<jsp:include page="vprotocol.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="partner" style="display: none">
		<jsp:include page="partners.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="ccpartner" style="display: none">
		<jsp:include page="ccpartners.jsp"></jsp:include>
	</div>

	<!-- About As -->

	<div class="mt-5" id="ourstory" style="display: none">
		<jsp:include page="ourstory.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="about-insight" style="display: none">
		<jsp:include page="about-insight.jsp"></jsp:include>
	</div>
	<div class="mt-5" id="contactus" style="display: none">
		<jsp:include page="contactus.jsp"></jsp:include>
	</div>

	<!-- Footer Page Include -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>