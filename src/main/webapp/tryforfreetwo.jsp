
<div class="row">

	<div class="col-6 col-sm-6 col-md-4 col-g-4 col-xl-4 mt-4">
		<a href="${pageContext.request.contextPath}/index.jsp"> <img
			src="images/logo.png" />
		</a>
	</div>

	<div class="col-6 col-sm-6 col-md-4 col-g-4 col-xl-4 mt-4 mt-4">
		<span class="step">Step 2 of 4</span>
	</div>

	<!-- <a href="signin.jsp" class="col-12 col-sm-12 col-md-4 col-g-4 col-xl-4 mt-4 sign-up-nav pointer">
                        <img src="images/arrow-left.svg" alt="">
                        <strong>Go back to existing user</strong>
                    </a> -->

</div>

<div class="row mt-5">

	<div class="col-lg-9 offset-lg-2">

		<h4 class="navy mb-4 font-weight-bold">Let's get your new account
			set up</h4>
		<form class="pt-4" id="tryforfree2form">
			<div class="form-group">
				<label class="font-weight-bold" for="companyDomain">Company
					domain</label> <input class="form-control acountsetupclass" type="text"
					id="companyDomain" name="companyDomain"
					placeholder="Ex: www.domainname.com" autocomplete="off" /><br /> <small>This
					is between us. We won't use it to reach out anyone else in your
					company.</small>
			</div>



			<div class="form-group">
				<label class="font-weight-bold" for="companyName">Company
					name</label> <input class="form-control acountsetupclass" type="text"
					id="companyName" name="companyName" autocomplete="off"
					placeholder="Please enter your company name" />
			</div>

			<div class="row">
				<div class="col-6">
					<button value="Next" type="button" id="submittryforfree2"
						class="toggle-disabled btn btn-signnavy font-weight-bold text-uppercase cpx-5 mt-2"
						disabled>Next</button>
				</div>
				<div class="col-6">
					<a href="javascript:void(0)"
						class="text-uppercase my-3 float-right"
						style="color: #4f4f4f; font-size: 14px; font-weight: 500;"
						onclick="skipPage()"> Skip <img src="images/arrow-right.svg"
						class="my-auto" alt="">
					</a>
				</div>
			</div>
		</form>
	</div>
</div>