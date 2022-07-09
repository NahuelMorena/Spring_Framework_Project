package com.spring_project.proyect.dao;

import java.util.List;

import com.spring_project.proyect.models.User;

public interface UserDao {
	
	List<User> search_users();

	void delete(Long id);

	void register(User user);
	
}
