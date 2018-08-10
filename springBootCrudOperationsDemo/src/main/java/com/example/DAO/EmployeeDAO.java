package com.example.DAO;

import java.util.List;

import com.example.DTO.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(String empNo);

	int addEmployee(Employee emp);

	int updateEmployee(Employee emp);

	void deleteEmployee(String empNo);

}
