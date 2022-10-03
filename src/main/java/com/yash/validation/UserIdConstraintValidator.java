package com.yash.validation;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.service.UserService;

@Component
public class UserIdConstraintValidator implements ConstraintValidator<UserIdConstraint,Integer> {

	@Autowired
	private UserService userService;
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean result=userService.checkUserId(value);
		if(result)
			return false;
			else
		return true;
	}

}
