package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.User;
@Repository("hibernateUserDAOImpl")
public interface UserDAO{
	
	public List<User> getAllUsers();
	public User getUserByUserId(int userId);
	public boolean storeUserDetails(User user);
	public boolean updatePassword(String password, String email);
	public boolean deleteUserByUserId(int userId);
	public boolean authUser(String userName,String password);
	public boolean updateUser(User user);
	public boolean checkUserId(int userId);
	public User getUserByEmail(String email);

}