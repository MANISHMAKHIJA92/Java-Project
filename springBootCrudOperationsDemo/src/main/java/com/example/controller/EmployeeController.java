package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.EmployeeDAO;
import com.example.DTO.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/")
	
	public String welcome() {
		return "Welcome to springBoot crudOperations Example.";
	}

	
	@RequestMapping(value = "/employees", 
			method = RequestMethod.GET, 
			produces = "application/json")
	
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}

	
	@RequestMapping(value = "/employee/{empNo}", 
			method = RequestMethod.GET, //
			produces = "application/json")
	
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}



	@RequestMapping(value = "/employee", 
			method = RequestMethod.POST, 
			produces = "application/json")
	
	public Employee addEmployee(@RequestBody Employee emp) {

		System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());

		return employeeDAO.addEmployee(emp);
	}


	@RequestMapping(value = "/employee", 
			method = RequestMethod.PUT, 
			produces = "application/json")
	
	public Employee updateEmployee(@RequestBody Employee emp) {

		System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());

		return employeeDAO.updateEmployee(emp);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empNo}
	@RequestMapping(value = "/employee/{empNo}", //
			method = RequestMethod.DELETE, //
			produces = "application/json")
	
	public void deleteEmployee(@PathVariable("empNo") String empNo) {

		System.out.println("(Service Side) Deleting employee: " + empNo);

		employeeDAO.deleteEmployee(empNo);
	}

}
