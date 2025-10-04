package com.tejas.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tejas.springmvc.model.Users;

@Component
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Users> getUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Users> users = session.createQuery("from users_table1", Users.class).list();
		
		return users;		
	}
	
	@Transactional
	public void addUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		return;
	}
	
	@Transactional
	public Users getUserById(int uid) {
		Users user = null;
		Session session = sessionFactory.getCurrentSession();
		user = session.find(Users.class, uid);
		
		return user;
	}
}
