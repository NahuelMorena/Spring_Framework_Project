package com.spring_project.proyect.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.proyect.dao.UserDao;
import com.spring_project.proyect.models.User;

@RestController
public class UserController{

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "api/user/{id}")
	public User get(@PathVariable Long id) {
		User user = new User();
		user.setId(id);
		user.setName("Pedro");
		user.setSurname("Hernandez");
		user.setEmail("pedrito@gmail.com");
		user.setPhone("1234234565");
		user.setPassword("pedro123");
		return user;
	}
	
	@RequestMapping(value = "api/users")
	public List<User> search_users() {
		return userDao.search_users();
	}
	
	@RequestMapping(value = "api/users", method = RequestMethod.POST)
	public void register_user(@RequestBody User user) {
		userDao.register(user);
	}
	
	public User edit() {
		User user = new User();
		user.setName("Pedro");
		user.setSurname("Hernandez");
		user.setEmail("pedrito@gmail.com");
		user.setPhone("1234234565");
		user.setPassword("pedro123");
		return user;
	}
	
	@RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		userDao.delete(id);
	}

}
