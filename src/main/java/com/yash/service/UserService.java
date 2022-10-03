package com.yash.service;


import java.util.List;

import com.yash.entities.User;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;


public interface UserService {
	
	public List<UserResponse> getUserModel();
	public UserResponse getUserByUserId(int userId);
	public boolean storeUserModel(UserRequest user);
	public boolean updatePassword(String password, String email);
	public boolean deleteUserModelById(int userId);
	public boolean authUser(String userName, String password);
	public boolean updateUser(UserRequest userRequest);
	public boolean checkUserId(int userId);
	public List<UserResponse> usersRetrievalServicesJSON();
	public UserResponse getUserModelByEmail(String email);

}
