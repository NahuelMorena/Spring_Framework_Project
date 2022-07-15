package com.spring_project.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.proyect.dao.UserDao;
import com.spring_project.proyect.models.User;
import com.spring_project.proyect.utils.JWTUtil;

@RestController
public class AuthController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		User registeredUser = userDao.get_by_email_and_password(user);
		if (registeredUser != null) {
			String tokenJwt = jwtUtil.create(String.valueOf(registeredUser.getId()), registeredUser.getEmail());
			return tokenJwt;
		}
		return "FAIL";
	}

}
