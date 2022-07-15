// Call the dataTables jQuery plugin
$(document).ready(function() {
    search_users();
    $('#users').DataTable();
    delete_Some_DataTable_Elements();
});

//Complement functions 

function delete_Some_DataTable_Elements(){
    document.querySelector('#users_length').outerHTML = ""; 
    document.querySelector('#users_filter').outerHTML = "";
    document.querySelector('#users_info').outerHTML = "";
    document.querySelector('#users_paginate').outerHTML = "";
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

//async functions

async function search_users(){
    const request = await fetch('api/users', {
        method: 'GET',
        headers: getHeaders()
    });
    const users = await request.json();
      
    let listHtml = '';
    for (let user of users){
        let deleteBotton = '<a href="#" onclick="deleteUser('+user.id+')"><i class="fas fa-trash"></i></a>';
        let editBotton = '<a href="#" onclick="edit_botton('+user.id+')"><i class="fa-solid fa-pen"></i></a>'
        let actions = deleteBotton +"      "+ editBotton;
        let userHtml = '<tr><td data-label="Id:">'+ user.id +'</td><td data-label="Full name:">'+ user.name+ ' ' 
                        + user.surname+ '</td><td data-label="Email:">'
                        + user.email+'</td><td data-label="Phone:">'+user.phone
                        + '</td><td data-label="Actions: ">'+actions+'</td></tr>';
        listHtml += userHtml;
    }
    console.log(users);
      
    document.querySelector('#users tbody').outerHTML = listHtml;
}
  
async function deleteUser(id){
    if(!confirm('Are you sure you want to delete this user?')){
        return;
    }
      
    const request = await fetch('api/user/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
      
    location.reload();
}

async function edit_botton(id){
    localStorage.id_user = id;

    const request = await fetch('api/user/' + id, {
        method: 'GET',
        headers: getHeaders()
    });
    const user = await request.json();

    document.getElementById('txtName').value = user.name;
    document.getElementById('txtSurname').value = user.surname;
    document.getElementById('txtEmail').value = user.email;
    document.getElementById('txtPhone').value = user.phone;

    document.querySelector('#form-title').outerHTML = "<h1 id='form-title'>Update user</h1>"; 
    document.querySelector('#form-botton').outerHTML = "<button id='form-botton' onclick='edit_user()' type='submit'>Update user</button>"
}