$(document).ready(function() {
	// on ready  
});

async function login(){
	let data = {};
	
	data.email = document.getElementById('txtEmailLogin').value;
	data.password = document.getElementById('txtPasswordLogin').value;
	
	const request = await fetch('api/login', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});
	
	const response = await request.text();

	if (response != "FAIL"){
		localStorage.token = response;
		localStorage.email = data.email;
		window.location.href = 'index.html';
	} else {
		alert("Incorrect information, please try again");
	}
}

async function logout() {
    if(!confirm('Are you sure you want to logout?')){
        return;
    }
    localStorage.removeItem('email');
    localStorage.removeItem('token');
    window.location.href = 'access.html';
}