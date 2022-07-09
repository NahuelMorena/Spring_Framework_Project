package com.spring_project.proyect.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring_project.proyect.models.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> search_users() {
		String query = "FROM User";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	@Override
	public void register(User user) {
		entityManager.merge(user);
	}


}
