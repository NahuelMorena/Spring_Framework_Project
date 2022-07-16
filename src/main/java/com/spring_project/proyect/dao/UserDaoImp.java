package com.spring_project.proyect.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring_project.proyect.models.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public User get(Long id) {
		return entityManager.find(User.class, id);
	}

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
	public void save(User user) {
		entityManager.merge(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User get_by_email_and_password(User user) {
		String query = "FROM User WHERE email = :email";
		List<User> list =  entityManager.createQuery(query)
				.setParameter("email", user.getEmail())
				.getResultList();
		
		if (list.isEmpty()) {
			return null;
		}
		
		String passwordHashed = list.get(0).getPassword();
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		if (argon2.verify(passwordHashed, user.getPassword())) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User get_by_email(String email) {
		String query = "FROM User WHERE email = :email";
		List<User> list =  entityManager.createQuery(query)
				.setParameter("email", email)
				.getResultList();
		
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
