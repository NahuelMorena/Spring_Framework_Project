package com.spring_project.proyect.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.proyect.dao.UserDao;
import com.spring_project.proyect.models.User;
import com.spring_project.proyect.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UserController{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	private boolean validate_token(String token) {
		String userId = jwtUtil.getKey(token);
		return userId != null;
	}
	
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
	public List<User> search_users(@RequestHeader(value="Authorization") String token) {
		if (!validate_token(token)) {
			return null;
		}
		return userDao.search_users();
	}
	
	@RequestMapping(value = "api/user", method = RequestMethod.POST)
	public void register_user(@RequestBody User user) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		user.setPassword(argon2.hash(1, 1024, 1, user.getPassword()));
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
	public void delete(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
		if (!validate_token(token)) {
			return;
		}
		userDao.delete(id);
	}

}
