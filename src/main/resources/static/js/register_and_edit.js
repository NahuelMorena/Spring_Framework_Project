
function get_data(){
    let data = {};
    data.name = document.getElementById('txtName').value;
	data.surname = document.getElementById('txtSurname').value;
	data.email = document.getElementById('txtEmail').value;
	data.phone = document.getElementById('txtPhone').value;
    data.password = document.getElementById('txtPassword').value;
    return data
}

function create_array(data){
    repeatPassword = document.getElementById('txtRepeatPassword').value;
    let array = [data.name, data.surname, data.email, data.phone, data.password, repeatPassword];
    return array;
}

function validate_form(array){
    let empty = false;
    array.forEach(element => {
        if (element.length == 0){
            empty = true;
        }
    });
	if (empty){
        alert("Complete all the fields")
        return false;
    }

	if (array[4] != array[5]){
		alert("the passwords entered are not the same");
		return false;
	}
    return true;
}

async function register_user(){
	let data = get_data();
    let array = create_array(data);
    if (!validate_form(array)){
        return;
    }

	const request = await fetch('api/user', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});
	confirm("The account was created successfully!");
    if (localStorage.token != undefined){
        window.location.href = 'index.html';
    } 
}

async function edit_user(){
    let data = get_data();
    let array = create_array(data);
    if (!validate_form(array)){
        return;
    }

	const request = await fetch('api/user/'+ localStorage.id_user, {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	});
    localStorage.removeItem('id_user');
	alert("The user was successfully updated!");
	window.location.href = 'index.html';
}