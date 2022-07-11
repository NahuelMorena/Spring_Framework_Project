package com.spring_project.proyect.dao;

import java.util.List;

import com.spring_project.proyect.models.User;

public interface UserDao {
	
	List<User> search_users();

	void delete(Long id);

	void register(User user);

	User get_user_by_email_and_password(User user);
	
}
