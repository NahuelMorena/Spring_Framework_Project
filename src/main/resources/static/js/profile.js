$(document).ready(function() { 
    get_user_info();
});

async function get_user_info(){

    const request = await fetch('api/user/profile/' + localStorage.email, {
        method: 'GET',
        headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		}
    });
    const user = await request.json();

    console.log(user);
    document.getElementById('h1-name').innerHTML = user.name;
    document.getElementById('h4-name').innerHTML = "Name: "+ user.name;
    document.getElementById('h4-surname').innerHTML = "Surname: " + user.surname;
    document.getElementById('h4-email').innerHTML = "Email: " + user.email;
    document.getElementById('h4-phone').innerHTML = "Phone: " + user.phone;
}