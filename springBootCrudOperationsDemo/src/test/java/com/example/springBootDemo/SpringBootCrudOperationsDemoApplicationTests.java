package com.example.springBootDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)

@WebMvcTest(value = EmployeeController.class, secure = false)
public class SpringBootCrudOperationsDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeDAO employeeDAO;

	

	@Test
	public void getEmployeeTest() throws Exception {
		
		//Employee mockemployee = new Employee("E01", "Smith", "Clerk");
		
		
		Employee employee = new Employee();
		employee.setEmpNo("256488");
		employee.setEmpName("Ankur");
		
		employee.setPosition("system Engineer");
		
		Mockito.when(
				employeeDAO.getEmployee(Mockito.anyString())).thenReturn(employee);

		
	/*	Mockito.when(
				employeeDAO.getEmployee(Mockito.anyString())).thenReturn(mockEmployee);
*/
		
		String url ="/employee/844195";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				url).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson =this.mapToJson(employee);
		String outputJson= result.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(expectedJson);
		
		/*JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);*/
	}
	
	
	
	@Test
	public void getAllEmployeesTest() throws Exception {
		
		
		
		
		Employee employee1 = new Employee();
		employee1.setEmpNo("844195");
		employee1.setEmpName("Manish");
		
		employee1.setPosition("system Engineer");
		
		Employee employee2 = new Employee();
		employee2.setEmpNo("844195");
		employee2.setEmpName("Manish");
		
		employee2.setPosition("system Engineer");
		
		List<Employee> employeeList= new ArrayList<Employee>();
		
		
		Mockito.when(
				employeeDAO.getAllEmployees()).thenReturn(employeeList);

		
	/*	Mockito.when(
				employeeDAO.getEmployee(Mockito.anyString())).thenReturn(mockEmployee);
*/
		
		String url ="/employees";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				url).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson =this.mapToJson(employeeList);
		String outputJson= result.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(expectedJson);
		
	
	}
	
	
		
	private String mapToJson(Object object) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.writeValueAsString(object);
		
	}
	
	}


