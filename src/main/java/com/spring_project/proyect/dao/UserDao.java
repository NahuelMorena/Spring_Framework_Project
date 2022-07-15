package com.spring_project.proyect.dao;

import java.util.List;

import com.spring_project.proyect.models.User;

public interface UserDao {
	
	List<User> search_users();

	void delete(Long id);

	void save(User user);

	User get_by_email_and_password(User user);

	User get(Long id);
}
