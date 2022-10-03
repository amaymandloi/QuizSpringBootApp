package com.yash.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.yash.dao.UserDAO;
import com.yash.dao.UserDAO;
import com.yash.entities.User;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
import com.yash.model.UserRequest;
import com.yash.model.UserRequest;

@Component
public class UserViewToEntityConvertor {

	@Autowired
	@Qualifier("hibernateUserDAOImpl")
	private UserDAO userDAO;

	public User saveUserConvertor(UserRequest userRequest) {

		User destinationUser = new User();

		destinationUser.setUserId(userRequest.getUserId());
		destinationUser.setFirstName(userRequest.getFirstName());
		destinationUser.setLastName(userRequest.getLastName());
		destinationUser.setEmail(userRequest.getEmail());
		destinationUser.setPassword(userRequest.getPassword());

		return destinationUser;

	}

}
