var ids = [ 'tryforfree1', 'tryforfree2', 'tryforfree3', 'tryforfree4' ];

$(document).ready(function() {
	alert('loadSignUp');
	loadSignUp();
});

function loadSignUp() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const id = urlParams.get('id');
	
	if(id){
		$('#'+ id).show();
		ids.forEach(val=>{
			if('#'+ val !== '#'+id){
				$('#'+val).hide();
			} else{
				$('#'+val).show();
			}
			
		});
		alert('if');
	}else{
		alert('else');
		history.pushState(null, '', '/signup.jsp?id=tryforfree1');  
		ids.forEach(val=>{
			if(val != '#tryforfree1'){
				$('#'+val).hide();
			}
		})
	}
}