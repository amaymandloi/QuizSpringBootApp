package com.yash.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.entities.User;

@Repository("hibernateUserDAOImpl")
public class UserDAOHIbernate implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {

		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("FindUsers");
		List<User> userList = query.list();
		return userList;
	}

	@Override
	public User getUserByUserId(int userId){

		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, userId);
		return user;
	}

	@Override
	public boolean storeUserDetails(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		transaction.commit();

		User userDB = (User) session.load(User.class, user.getUserId());
		if (user.getUserId() == userDB.getUserId()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String password, String email) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Query query = session.createNamedQuery("UpdatePassword");
		query.setParameter(1, password);
		query.setParameter(2, email);
		int rows = query.executeUpdate();
		transaction.commit();
		if (rows > 0)
			return true;
		else

			return false;
	}

	@Override
	public boolean deleteUserByUserId(int userId) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Query query = session.createNamedQuery("DeleteUser");
		int rows = query.executeUpdate();
		transaction.commit();
		if(rows>0)
			return true;
		else

			return false;
	}

	@Override
	public boolean authUser(String userName, String password) {

		boolean ifUserFound = false;

		return ifUserFound;

	}

	@Override
	public boolean updateUser(User user) {
		
		return false;
	}

	public boolean checkUserId(int userId) {
		List<User> userList = getAllUsers();
		for (User user : userList) {
			if (user.getUserId() == userId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUserByEmail(String email) {

		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, email);
		return user;
	}

}
