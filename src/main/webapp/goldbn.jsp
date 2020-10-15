    <!-- Banner Section-->
    <div class="innerbanner">
        <div class="container-fluid">
            <div class="row mx-5 py-4">
                <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <h2 id="getpageheading">Gold Pricing Plan</h2>
                </div>     
                 <div
				class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 text-right my-auto">
				<small>Pricing Plan - <span class="yellow">Gold
						</span></small>
			</div>            
            </div>
        </div>
    </div>


  
 <div class="px-2 py-5" style="padding-top:8.5rem;">
    <div class="container">
    <h5 class="pricingplanheading">Gold Pricing Plan</h5>
     <div class="row">
    <div class="col-8">
   <table id="mytable3" class="table table-bordered freetrialtable tablecss">
     <thead>
     </thead>
     <tbody>
      <tr>
      <td>AI Module</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="gaiModuletableValue"></span></b></td>
    </tr>
    <tr> 
      <td>Inventory Module</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="ginventoryModuletableValue"></span></b></td>
    </tr>
    <tr>
      <td>Scheduler, Order and Logistics</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="gschedulartableValue"></span></b></td>
    </tr>
    <tr>
      <td>IRT,clinical studies</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="gclinicaltableValue"></span></b></td>
    </tr>
    <tr class="totalhightlight"> 
      <td>Total All Modules</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="gtotalModuletableValue"></span></b></td>
    </tr>
     </tbody>
  </table>
  <h5 class="pricingplanheading">Billing Info</h5>
  <table id="mytable3" class="table table-bordered freetrialtable  tablecss">
     <thead>
     </thead>
     <tbody>
    <tr class="discounthightlight"> 
      <td>Discount</td>
      <td class="pricingtextalign"><b>$<span class="pricefont" id="gbeforeDiscount"></span></b></td>
    </tr>
    <tr class="afterdiscount">
      <td>Price after Discount</td>
      <td class="pricingtextalign"><span>Price per month<br></span><b>$<span class="pricefont" id="gAfterDiscount"></span></b></td>
    </tr>
     </tbody>
  </table>
  </div>
   <div class="col-4">
					<div class="discounthighlight px-2 ">
						<div class="d-flex  py-3">
							<div class="pl-3">
								 <span style="vertical-align: middle; display: table-cell;">
									<p style="white-space: normal;font-weight: bold; font-size: 16px;">
										Co-Development Partner Discount Gold
									</p>
								</span>
								<span style="position: relative; vertical-align: middle; display: table-cell; font-weight: bold; font-size: 28px;" id="gdiscountpercent"></span>
							</div>
						</div>
					</div>
					<br><br>
	<div class="promocode">	
	<form method="post" enctype="application/json" id="gcouponform">						
   <div class="form-group">
	 <label class="promocodelabel font-weight-bold" for="gcouponsft">Promo Code</label>
		<input class="form-control" type="text" name="gcouponsft" id="gcouponsft" placeholder="Enter Promo Code" />
   </div>
   	<div>
			<input class="btn btn btn-warning font-weight-bold text-uppercase cpx-5" type="button" id="applyPromoCodeForGold" value="Apply" />
		</div>
		</form>
   </div>
   </div>
</div>
<div class="invoicebutton">
 <input class="btn btn-signnavy font-weight-bold text-uppercase cpx-5" type="button" id ="sendInvoiceforgold" value="Send Invoice" />
 </div>
</div>
</div>





