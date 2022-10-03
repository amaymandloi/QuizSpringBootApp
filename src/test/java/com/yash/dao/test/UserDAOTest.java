package com.yash.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yash.dao.UserDAOHIbernate;
import com.yash.entities.Result;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
@ExtendWith(SpringExtension.class)
class UserDAOTest {

	@Mock
	private UserDAOHIbernate userDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
	}

	@Test
	void getUserByIDTestPositive() {

		User user = userDAO.getUserByUserId(1);
		System.out.println("User : "+user);

		verify(userDAO).getUserByUserId(1);
	}
	
	@Test
	void getAllResultTestPositive() {

		List<User> user = userDAO.getAllUsers();

		System.out.println("User" +user );

		verify(userDAO).getAllUsers();
	}
	
	@Test
	void StoreUserTestPositive() {

		User user = new User(101, "89640@Himanshu","Himanshu", "Kulshrestha", "himKul@gmail.com");
		userDAO.storeUserDetails(user);

		System.out.println("User" + user);

		verify(userDAO).storeUserDetails(user);
	}
}
