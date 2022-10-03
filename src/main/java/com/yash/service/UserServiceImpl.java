package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.convertor.ResultViewToEntityConvertor;
import com.yash.convertor.UserViewToEntityConvertor;
import com.yash.dao.ResultDAO;
import com.yash.dao.UserDAO;
import com.yash.dao.UserDAOJdbcImplementation;
import com.yash.entities.Result;
import com.yash.entities.User;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;

@Service
public class UserServiceImpl implements UserService{

	@Autowired@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;
	
	@Autowired@Qualifier("jdbcUserDAOImplementation")
	private UserDAOJdbcImplementation jdbcuserDAO;
	
	@Autowired
	UserViewToEntityConvertor userViewToEntityConvertor;
	
//	public UserServiceImpl(UserDAO userDAO){
//		 this.userDAO = userDAO;
//	};
	
	public List<UserResponse> getUserModel() {
		List<User> listOfUsers = userDAO.getAllUsers();
		List<UserResponse> userModelList = new ArrayList<UserResponse>();

		for (User user : listOfUsers) {
			UserResponse userModel = new UserResponse();
			userModel.setUserId(user.getUserId());
			userModel.setFirstName(user.getFirstName());
			userModel.setLastName(user.getLastName());
			userModel.setEmail(user.getEmail());
			userModel.setPassword(user.getPassword());
			//userModel.setIsAdmin(user.getIsAdmin());
			userModelList.add(userModel);
		}
		return userModelList;
	}

	@Override
	public UserResponse getUserByUserId(int userId){

				User user=userDAO.getUserByUserId(userId);
				UserResponse userResponse=new UserResponse();
				userResponse.setUserId(user.getUserId());
				userResponse.setFirstName(user.getFirstName());
				userResponse.setLastName(user.getLastName());
				userResponse.setEmail(user.getEmail());
				userResponse.setPassword(user.getPassword());
			
		return userResponse;
	}
	

	public boolean storeUser(UserRequest userRequest) {
			
		boolean flag = false;
		User result = userViewToEntityConvertor.saveUserConvertor(userRequest);
		
		boolean savedUser = userDAO.storeUserDetails(result);
		
		if(savedUser)
			flag=true;
		
		return flag;
	}

    

	@Override
	public boolean storeUserModel(UserRequest userModel) {
			
				User user=new User();
				user.setUserId(userModel.getUserId());
				user.setFirstName(userModel.getFirstName());
				user.setLastName(userModel.getLastName());
				user.setEmail(userModel.getEmail());
				user.setPassword(userModel.getPassword());
				//user.setIsAdmin(userModel.getIsAdmin());
				
				boolean result= jdbcuserDAO.storeUserDetails(user);
				
				if(result)
				return true;
				else
					return false;
	}

	@Override
	public boolean updatePassword(String password, String email) {
		return userDAO.updatePassword(password, email);
	}

	@Override
	public boolean deleteUserModelById(int userId) {
		boolean result = userDAO.deleteUserByUserId(userId);
		return result;
	}

	@Override
	public boolean authUser(String email, String password) {

		boolean result = jdbcuserDAO.authUser(email, password);
		if(result)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean updateUser(UserRequest userRequest) {
        User user=new User();
        user.setPassword(userRequest.getPassword());
        user.setUserId(userRequest.getUserId());
       
		return userDAO.updateUser(user);
	}
	
	public boolean checkUserId(int userId) {
		return userDAO.checkUserId(userId);
	}
	
	public List<UserResponse> usersRetrievalServicesJSON() {
		List<User> userList=userDAO.getAllUsers();
		System.out.println(userList);
		List<UserResponse> userResponseList=new ArrayList<UserResponse>();
		for(User user:userList) {
			UserResponse userResponse=new UserResponse();
			
			userResponse.setUserId(user.getUserId());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setEmail(user.getEmail());

			userResponseList.add(userResponse);
		}
		System.out.println("userResponse Final "+userResponseList);
		return userResponseList;
	}

	public UserResponse getUserModelByEmail(String email){

		User user=jdbcuserDAO.getUserByEmail(email);
		UserResponse userResponse=new UserResponse();
		userResponse.setUserId(user.getUserId());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
	
return userResponse;
}




}
