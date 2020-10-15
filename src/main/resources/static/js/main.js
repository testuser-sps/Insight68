$(document).ready(function () {
	var a = window.location.href;
	var pageNavigation = (a.split('#')[1]);
	var homePageCheck = '#';
	var pageName;
	var sToken = localStorage.getItem("secureToken");
	var logoutEmail = localStorage.getItem("uemail",
			$("#email").val());
	if (a.indexOf(homePageCheck) == -1) {
		 pageName = "Home";
		 }
	else{
		 pageName = $(location.hash).find("#getpageheading")
		.html();
	}
		var userPagedetails = {
			email : logoutEmail,
			token : sToken,
			pageEnteredName : pageName
		};
		$.ajax({
			url : ctx + '/individualPageTracing',
			dataType : 'json',
			data : userPagedetails,
			method : 'POST',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("SbmsAuthorization", sToken);
			},
			success : function(data) {
				if (data.status == 'SUCCESS') {
					// window.location.href = ctx + "/logout";
					console.log(data.status);
					// window.location.href = ctx + '/logout';
				} else {
					console.log(data.status);
				}
			},
			error : function(xhr, statusText, err) {
				console.log(xhr.status);
			}
		});
});


var links = ['pro-insight',
    'pro-Overview',
    'pro-industries',
    'pro-platform',
    'pro-ADR',
    'pro-quality',
    'pro-inventory',
    'pro-casemanage',
    'pro-equipment',
    'pro-logistics',
    'pro-scheduler',
    'pro-manufacturing',
    'support',
    'service',
    'pricing',
    'legal',
    'consultingservice',
	'partner',
    'customerSuccessStories',
    'guide',
    'compliance',
    'vprotocol',
    'ccpartner',
    'ourstory',
    'about-insight',
    'contactus',
    'freetrailbn',
    'standardbn',
	'goldbn',
	'platinumbn'
];

function navigation(params) {
    links.forEach(val => {
        if (val === params) {
            $('#' + params).show();
            $('#indexmain').hide();
            timmer();
        } else {
            $('#' + val).hide();
        }
    })
}

function timmer() {
	setTimeout(() => {
        window.scrollTo(0, 0);
    }, 100);
}

var footerLinks = [
	'pro-Overview',
	'pro-industries',
	'pro-platform',
	'pro-ADR',
	'pro-quality',
	'pro-inventory',
	'pro-casemanage',
	'pro-equipment',
	'pro-logistics',
	'pro-scheduler',
	'pro-manufacturing',
	'ourstory',
	'about-insight',
	'contactus',
	'support',
	'service',
	'pricing',
	'consultingservice',
	'partner',
	'customerSuccessStories',
	'guide',
	'compliance',
	'vprotocol',
    'ccpartner',
	'pro-insight',
    'freetrailbn',
    'standardbn',
	'goldbn',
	'platinumbn'
	];

	function footerNav(params) {
	    footerLinks.forEach(val => {
	        if (val === params) {
	            $('#' + params).show();
	            $('#indexmain').hide();
	            timmer();
	        } else {
	            $('#' + val).hide();
	        }
	    })
	}
	
	
	
	

	    
	    
	var subMinhideArray = ['pro-cat','supportservice','resources','about'];
	
	// loader script
	
/*	$(document).ajaxSend(function(event, jqxhr, settings) {
	    $.LoadingOverlay("show", {
	        image: "",
	        fontawesome: "fa fa-spinner fa-pulse fa-3x fa-fw",
	        size: 35,
	        maxSize: 12,
	        minSize: 4,
	    });
	});
	$(document).ajaxComplete(function(event, jqxhr, settings) {
	    $.LoadingOverlay("hide");
	});
*/
	