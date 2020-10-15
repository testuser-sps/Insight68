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
<jsp:include page="header.jsp"></jsp:include>

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
					<a href="${pageContext.request.contextPath}/index.jsp"> <img
						src="images/sign.png" class="img-fluid" />
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


				<div class="mt-5" id="customerSuccessStories" style="display: none">
					<jsp:include page="customerSuccessStories.jsp"></jsp:include>
				</div>

				<div id="tryforfree1">
					<jsp:include page="tryforfreeone.jsp"></jsp:include>
				</div>

				<div id="tryforfree2">
					<jsp:include page="tryforfreetwo.jsp"></jsp:include>
				</div>

				<div id="tryforfree3">
					<jsp:include page="tryforfreethree.jsp"></jsp:include>
				</div>

				<div id="tryforfree4">
					<jsp:include page="tryforfreefour.jsp"></jsp:include>
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
	<script src="js/loadingoverlay.js" type="text/javascript"></script>
	<script src="js/toastr.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/signup.js"></script>
	<script src="js/cookie.js"></script>
	<script src="js/custom.js"></script>

	<!-- <script src="js/signUp/repeatedFun.js"></script> -->
	<script>
		var detectBackOrForward = function(onBack, onForward) {
			hashHistory = [ window.location.hash ];
			historyLength = window.history.length;

			return function() {
				var hash = window.location.hash, length = window.history.length;
				if (hashHistory.length && historyLength == length) {
					if (hashHistory[hashHistory.length - 2] == hash) {
						hashHistory = hashHistory.slice(0, -1);
						var a = window.location.href;
						var pageNavigation = (a.split('#')[1]);
						var homePageCheck = '#';
						if (a.indexOf(homePageCheck) != -1) {
							var pageNavigation = pageNavigation.replace('.jsp',
									'');
							navigation(pageNavigation);
						} else {
							window.location.href = 'index.jsp';
						}
						onBack();
					} else {
						hashHistory.push(hash);
						onForward();
					}
				} else {
					hashHistory.push(hash);
					historyLength = length;
				}
			}
		};

		window.addEventListener("hashchange", detectBackOrForward(function() {
			console.log("back")
		}, function() {
			console.log("forward")
		}));
	</script>
</body>

</html>