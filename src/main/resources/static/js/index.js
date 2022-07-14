// Call the dataTables jQuery plugin
$(document).ready(function() {
    search_users();
    $('#users').DataTable();
    delete_Some_DataTable_Elements();
});
  
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
  
async function search_users(){
    const request = await fetch('api/users', {
        method: 'GET',
        headers: getHeaders()
    });
    const users = await request.json();
      
    let listHtml = '';
    for (let user of users){
        let deleteBotton = '<a href="#" onclick="deleteUser('+user.id+')"><i class="fas fa-trash"></i></a>';
        let editBotton = '<a href="#" onclick="editUser('+user.id+')"><i class="fa-solid fa-pen"></i></a>'
        let actions = deleteBotton +"      "+ editBotton;
        let userHtml = '<tr><td>'+ user.id +'</td><td>'+ user.name+ ' ' +user.surname+ '</td><td>'
                        + user.email+'</td><td>'+user.phone
                        + '</td><td>'+actions+'</td></tr>';
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

async function editUser(id){
    alert("usuario a editar"+ id);
}