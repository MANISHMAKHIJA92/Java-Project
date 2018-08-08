package com.example.DAO;

import java.util.List;

import com.example.DTO.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(String empNo);

	Employee addEmployee(Employee emp);

	Employee updateEmployee(Employee emp);

	void deleteEmployee(String empNo);

}
