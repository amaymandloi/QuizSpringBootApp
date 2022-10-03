package com.yash.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yash.model.UserRequest;
import com.yash.service.UserService;

@Component("userIdCustomValidator")
public class UserIdCustomValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
     UserRequest userRequest=(UserRequest)target;
     int userId=userRequest.getUserId();
     boolean result=userService.checkUserId(userId);
     if(!result) {
    	 errors.rejectValue("userId", "No error code","User Id does not exists");
     }
     	}
}
