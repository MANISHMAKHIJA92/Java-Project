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

		return "Welcome to springBoot crudOperations.";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}

	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.GET, produces = "application/json")

	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json")

	public void addEmployee(@RequestBody Employee emp) {

		System.out.println("Creating employee: " + emp.getEmpNo());

		 employeeDAO.addEmployee(emp);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = "application/json")

	public void updateEmployee(@RequestBody Employee emp) {

		System.out.println(" Editing employee: " + emp.getEmpNo());

		 employeeDAO.updateEmployee(emp);
	}


	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE, produces = "application/json")

	public void deleteEmployee(@PathVariable("empNo") String empNo) {

		

		employeeDAO.deleteEmployee(empNo);
	}

}
