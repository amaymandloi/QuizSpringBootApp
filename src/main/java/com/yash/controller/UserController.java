package com.yash.controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.UserError;
import com.yash.model.UserRequest;
import com.yash.model.UserResponse;
import com.yash.notifications.Email;
import com.yash.service.UserServiceImpl;

@RestController
@RequestMapping("userapi")
@CrossOrigin(origins = "*")

public class UserController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserServiceImpl userService;

	@Autowired
	private Email email;
	
	@Autowired
	@Qualifier("userCustomValidator")
	private Validator uservalidator;

	@Autowired
	@Qualifier("userIdCustomValidator")
	private Validator userIdvalidator;

	@GetMapping("users")
	public ResponseEntity<List<UserResponse>> handleGetAllUserJSON() {

		List<UserResponse> UserResponseList = userService.getUserModel();
		ResponseEntity<List<UserResponse>> response = null;
		if (!UserResponseList.isEmpty()) {
			response = new ResponseEntity<List<UserResponse>>(UserResponseList, HttpStatus.OK);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<List<UserResponse>>(UserResponseList, HttpStatus.EXPECTATION_FAILED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}

	@GetMapping("userById/{userId}")
	public ResponseEntity<UserResponse> handleGetUserByIdJSON(@PathVariable("userId") int userId) {
	ResponseEntity<UserResponse> response = null;
	UserRequest userRequest = new UserRequest();
	userRequest.setUserId(userId);
	
	Errors errors = new BeanPropertyBindingResult(userRequest, "userRequest");
	userRequest.setUserId(userId);
	ValidationUtils.invokeValidator(userIdvalidator, userRequest, errors);
	if (errors.hasErrors()) {
	UserError userError = new UserError();
	userError.setErrorCode(108);
	List<ObjectError> listOfErrors = errors.getAllErrors();
	for (ObjectError objectError : listOfErrors) {
	userError.setErrorMessage(objectError.getDefaultMessage());



	}
	UserResponse userResponse = new UserResponse();
	userResponse.setUserError(userError);
	response = new ResponseEntity<UserResponse>(userResponse, HttpStatus.BAD_REQUEST);
	LOGGER.error("Failed Due to : "+response);
	} else {
	UserResponse userResponse = userService.getUserByUserId(userId);



	if (userResponse.getUserId() != 0) {
	response = new ResponseEntity<UserResponse>(userResponse, HttpStatus.FOUND);
	LOGGER.info("Successful : "+response);
	} else {
	response = new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_FOUND);
	LOGGER.error("Failed Due to : "+response);
	}
	}
	return response;
	}

	@PostMapping("postUser")
	public ResponseEntity<UserResponse> storeUserModel(@Valid @RequestBody UserRequest userRequest, Errors errors) {
		ResponseEntity<UserResponse> response = null;

		ValidationUtils.invokeValidator(uservalidator, userRequest, errors);
		if (errors.hasErrors()) {
			UserError userError = new UserError();
			userError.setErrorCode(101);
			List<ObjectError> listOfErrors = errors.getAllErrors();
			for (ObjectError objectError : listOfErrors) {
				userError.setErrorMessage(objectError.getDefaultMessage());

			}
			UserResponse userResponse = new UserResponse();
			userResponse.setUserError(userError);
			response = new ResponseEntity<UserResponse>(userResponse, HttpStatus.BAD_REQUEST);
			LOGGER.error("Failed Due to : "+response);

		} else {
			// boolean result = userService.persistUser(userRequest);
		    boolean result = userService.storeUserModel(userRequest);
			//boolean result = userService.storeUser(userRequest);
			if (result) {
				UserResponse userResponse = new UserResponse();
				userResponse.setUserId(userRequest.getUserId());
				userResponse.setFirstName(userRequest.getFirstName());
				userResponse.setLastName(userRequest.getLastName());
				userResponse.setEmail(userRequest.getEmail());
				userResponse.setPassword(userRequest.getPassword());
				email.email(userResponse.getEmail());
			} else {
				response = new ResponseEntity<UserResponse>(HttpStatus.CREATED);
				LOGGER.info("Successful : "+response);
			}
			return response;
		}
		return response;

	}

	@PatchMapping("userpass")
	public ResponseEntity<Void> updateUserPassword(@RequestBody UserRequest userRequest) {

		boolean result = userService.updatePassword(userRequest.getPassword(), userRequest.getEmail());
		ResponseEntity<Void> response = null;
		if (result) {
			response = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}

	@PutMapping("user")
	public ResponseEntity<String> updateuserpassword(@RequestBody UserRequest userRequest) {
		System.out.println(userRequest);
		boolean result = userService.updateUser(userRequest);

		ResponseEntity<String> response = null;
		if (result) {
			response = new ResponseEntity<String>("User password updated.", HttpStatus.ACCEPTED);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<String>("User password update failed", HttpStatus.NOT_MODIFIED);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;
	}

	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
		boolean result = userService.deleteUserModelById(userId);
		ResponseEntity<Void> response = null;
		if (result) {
			response = new ResponseEntity<Void>(HttpStatus.OK);
			LOGGER.info("Successful : "+response);
		} else {
			System.out.println("inside");
			response = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;

	}

	@PostMapping("authuser")
	public ResponseEntity<String> authUser(@RequestBody UserRequest userRequest) {
		boolean result = userService.authUser(userRequest.getEmail(), userRequest.getPassword());
		ResponseEntity<String> response = null;
		if (result) {
			response = new ResponseEntity<String>("loggedIn", HttpStatus.OK);
			LOGGER.info("Successful : "+response);
		} else {
			response = new ResponseEntity<String>("Login failed", HttpStatus.NOT_FOUND);
			LOGGER.error("Failed Due to : "+response);
		}
		return response;

	}
	@GetMapping("userByEmail")
	public ResponseEntity<UserResponse> handleGetUserByEmailJSON(@RequestBody UserRequest userRequest) {
		ResponseEntity<UserResponse> response = null;
		

		UserResponse userResponse=userService.getUserModelByEmail(userRequest.getEmail());
				response = new ResponseEntity<UserResponse>(userResponse, HttpStatus.FOUND);
				LOGGER.info("Successful : "+response);
		return response;
	}

}
