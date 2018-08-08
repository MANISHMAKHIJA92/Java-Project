package com.example.springBootDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.DAO.EmployeeDAO;
import com.example.DTO.Employee;
import com.example.controller.EmployeeController;

@RunWith(SpringRunner.class)

@WebMvcTest(value = EmployeeController.class, secure = false)
public class SpringBootCrudOperationsDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeDAO employeeDAO;

	Employee mockEmployee = new Employee("E01", "Smith", "Clerk");
			

	String employeeJson = "{\"empNo\":\"E01\",\"empName\":\"Smith\",\"position\":\"Clerk\"}";

	
	
	@Test
	public void contextLoads() throws Exception {
		
		//Employee mockemployee = new Employee("E01", "Smith", "Clerk");
		
		Mockito.when(
				employeeDAO.getEmployee(Mockito.anyString())).thenReturn(mockEmployee);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/E01").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{empNo:E01,empName:Smith,position:Clerk}";

		

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
		
	}


