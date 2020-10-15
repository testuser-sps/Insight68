
// chatbox related
function openForm() {
	document.getElementById("chatform").style.display = "block";
	document.getElementById("chatInit").style.display = "none";
}

// chatbox related
function closeForm() {
	document.getElementById("chatform").style.display = "none";
	document.getElementById("chatInit").style.display = "block";
}

// Scroll to top
$(document).ready(function() {
	var btn = $('#scroll');
	$(window).scroll(function() {
		if ($(window).scrollTop() > 500) {
			btn.addClass('show');
		} else {
			btn.removeClass('show');
		}
	});
	btn.on('click', function(e) {
		e.preventDefault();
		$('html, body').animate({
			scrollTop : 0
		}, '500');
	});

});


$(document).ready(function() {

	// Toggle Button clicked
	$("#toggle").click(function() {
		$(".fixed-top").toggleClass('bar-bottom');
	});

});

// step 5 of 5 sign up process script starts
let predefinedQues = [ 'How many people work at your company?',
		'What field do you work in?',
		'Which of the following best describes your role?',
		'Which of these sounds most like you?' ];

let predefinedAns = [];

function selectQuestion(ans, ansDiv, quesText) {
	const selectedQuesText = document.getElementById(quesText);
	const selectedAnsDiv = document.getElementById(ansDiv);
	const selectedAns = document.getElementById(ans);

	if (ans == 'ans-1' || ans == 'ans-2' || ans == 'ans-3' || ans == 'ans-4') {
		selectedQuesText.innerHTML = `<img src="images/tickfinishbtn.svg" class="pr-3 mb-2" alt=""><span class="text-truncate">`
				+ selectedAns.innerHTML
				+ ' people work at your company?'
				+ `</span>`;
		question('ques2Text', 'ques2');
		predefinedAns[0] = selectedAns.innerHTML;
		selectedAnsDiv.classList.add('hide');
	} else if (ans == 'ans-5' || ans == 'ans-6' || ans == 'ans-7'
			|| ans == 'ans-8' || ans == 'ans-9') {
		selectedQuesText.innerHTML = `<img src="images/tickfinishbtn.svg" class="pr-3 mb-2" alt=""><span class="text-truncate">`
				+ selectedAns.innerHTML + `</span`;
		question2('ques3Text', 'ques3');
		selectedAnsDiv.classList.add('hide');
		predefinedAns[1] = selectedAns.innerHTML;
	} else if (ans == 'ans-10' || ans == 'ans-11' || ans == 'ans-12'
			|| ans == 'ans-13' || ans == 'ans-14') {
		selectedQuesText.innerHTML = `<img src="images/tickfinishbtn.svg" class="pr-3 mb-2" alt=""><span class="text-truncate">`
				+ selectedAns.innerHTML + `</span`;
		question3('ques4Text', 'ques4');
		selectedAnsDiv.classList.add('hide');
		predefinedAns[2] = selectedAns.innerHTML;
	} else {
		selectedQuesText.innerHTML = `<img src="images/tickfinishbtn.svg" class="pr-3 mb-2" alt=""><span class="text-truncate">`
				+ selectedAns.innerHTML + `</span`;
		btncondition('btnfinish')
		selectedAnsDiv.classList.add('hide');
		predefinedAns[3] = selectedAns.innerHTML;
	}
}

function toggleQuestion(quesText) {
	if (quesText === 'ques1Text') {
		newFunction('ques1Text', 'ques1', 0);
	} else if (quesText === 'ques2Text') {
		newFunction('ques2Text', 'ques2', 1);
	} else if (quesText === 'ques3Text') {
		newFunction('ques3Text', 'ques3', 2);
	} else if (quesText === 'ques4Text') {
		newFunction('ques4Text', 'ques4', 3);
	}
}

function newFunction(quesText, quesNo, index) {
	const selectedAnsDiv = document.getElementById(quesNo);
	const selectedQuesText = document.getElementById(quesText);
	selectedQuesText.innerHTML = `<img src="images/tickbtn.svg" class="pr-3 mb-2" alt="">`
			+ predefinedQues[index];
	selectedAnsDiv.classList.remove('hide');
}

function question(quesDiv, ansDiv) {
	const quesTextDiv = document.getElementById(quesDiv).getElementsByTagName(
			"span")[0];
	const quesText = quesTextDiv.innerHTML;
	
	
	if (quesText == predefinedQues[1]) {
		const nextAnsDiv = document.getElementById(ansDiv);
		nextAnsDiv.classList.remove('hide');
	} else {
		return;
	}
}

function question2(quesDiv, ansDiv) {
	const quesTextDiv1 = document.getElementById(quesDiv).getElementsByTagName(
			"span")[0];
	const quesText1 = quesTextDiv1.innerHTML;
	
	
	if (quesText1 == predefinedQues[2]) {
		const nextAnsDiv1 = document.getElementById(ansDiv);
		nextAnsDiv1.classList.remove('hide');
	} else {
		return;
	}
}

function question3(quesDiv, ansDiv) {
	const quesTextDiv2 = document.getElementById(quesDiv).getElementsByTagName(
			"span")[0];
	const quesText2 = quesTextDiv2.innerHTML;
	
	
	if (quesText2 == predefinedQues[3]) {
		const nextAnsDiv2 = document.getElementById(ansDiv);
		nextAnsDiv2.classList.remove('hide');
	} else {
		return;
	}
}

function btncondition(id) {
	const btn = document.getElementById(id);
	btn.classList.remove('disabled');
}

// Signup final screen data submit
$(document).on('click', '#btnfinish', function() {
	const product = localStorage.getItem('userId');
	var result = {
		id : product,
		Howmanypeopleworkatyourcompany : predefinedAns[0],
		Whatfielddoyouworkin : predefinedAns[1],
		Whichofthefollowingbestdescribesyourrole : predefinedAns[2],
		Whichofthesesoundsmostlikeyou : predefinedAns[3],
	};
	submitpage5(result); // Final Result array
});

function submitpage5(result) {
	
	
	
	$.post(ctx +"/updateSignupDetailsAndSendMail", result, function(data) {
		
		if (data.status == 'SUCCESS') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			history.pushState(null, '',ctx+ '/signup.jsp?id=tryforfree4');  
			loadSignUp();
			loadDataInTryForFree4();
		} else {
			toastr.error(data.message, '', {
				timeOut : 10000
			})
		}
		if (data.status == 'WARNING') {
			toastr.success(data.message, '', {
				timeOut : 10000
			});
			history.pushState(null, '', ctx+'/signup.jsp?id=tryforfree4');  
			loadSignUp();
			loadDataInTryForFree4();
		}
	});
}

// try for free 4
function loadDataInTryForFree4() {
	var userDetails = JSON.parse(localStorage.getItem('userDetails'));
	
	document.getElementById('userRegisterMail').innerHTML = userDetails.emailAddress;
	document.getElementById('UserName').innerHTML = userDetails.firstName + ' ' + userDetails.lastName
	
	// Email manipulation
	/* const userDetails = JSON.parse(localStorage.setItem('userDetails')); */
	const email = userDetails.emailAddress;
	const indexAt = email.lastIndexOf("@");
	
	email.charAt(indexAt);
	const gmail = email.slice(indexAt + 1);
	var patt = /gmail.com/i;
	
	if(!patt.test(gmail)){
		$('#dymtext').hide();
	}		
	  
	// Email manipulation End
	  
}


// 
function loadSignUp() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const id = urlParams.get('id');
	if(id){
		if(id == null){			
			return;
		}
		ids.forEach(val=>{
			if('#'+ val !== '#'+id){
				$('#'+val).hide();
			} else{
				$('#'+val).show();
			}
		});
	}else{
		history.pushState(null, '', ctx+'/signup.jsp?id=tryforfree1');  
		ids.forEach(val=>{
			if(val != '#tryforfree1'){
				$('#'+val).hide();
			}
		});
		loadSignUp();
	}
}