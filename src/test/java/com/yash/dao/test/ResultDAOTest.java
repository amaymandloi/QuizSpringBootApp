package com.yash.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.yash.dao.ResultDAO;
import com.yash.dao.ResultDAOImpl;
import com.yash.dao.UserDAO;
import com.yash.entities.Result;
import com.yash.entities.User;
import com.yash.helper.DateHelper;
import com.yash.model.ResultResponse;
import com.yash.service.ResultService;
import com.yash.service.ResultServiceImpl;

@ExtendWith(SpringExtension.class)
class ResultDAOTest {

	@Mock
	private ResultDAOImpl resultDAO;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	public void tearDown() {

	}

	@Test
	public void myTest() throws Exception {

	}

	@Test
	void getResultByIDTestPositive() {

		Result result = resultDAO.getResultByResultId(1);

		System.out.println("REsult" + result);

		verify(resultDAO).getResultByResultId(1);
	}
	
	@Test
	void getAllResultTestPositive() {

		List<Result> result = resultDAO.getAllResults();

		System.out.println("REsult" + result);

		verify(resultDAO).getAllResults();
	}
	
	@Test
	void StoreTestPositive() {

		Result result = new Result(101, 1, 90, 90, 0, null, 0, DateHelper.getCurrentDate(), DateHelper.getCurrentDate());
		resultDAO.storeResultDetails(result);

		System.out.println("REsult" + result);

		verify(resultDAO).storeResultDetails(result);
	}
}
