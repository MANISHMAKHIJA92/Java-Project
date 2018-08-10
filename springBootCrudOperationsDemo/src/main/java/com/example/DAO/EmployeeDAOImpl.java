package com.example.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.DTO.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

	/*
	 static { initEmps(); }
	  
	  private static void initEmps() { Employee emp1 = new Employee("E01", "Smith",
	  "Clerk"); Employee emp2 = new Employee("E02", "Allen", "Salesman"); Employee
	  emp3 = new Employee("E03", "Jones", "Manager");
	  
	  empMap.put(emp1.getEmpNo(), emp1); empMap.put(emp2.getEmpNo(), emp2);
	 empMap.put(emp3.getEmpNo(), emp3); }
	 
	  
	  public Employee getEmployee(String empNo) { return empMap.get(empNo); }
	  
	  
	  public Employee addEmployee(Employee emp) { empMap.put(emp.getEmpNo(), emp);
	  return emp; }
	  
	  
	  public Employee updateEmployee(Employee emp) { empMap.put(emp.getEmpNo(),
	  emp); return emp; }
	  
	  
	  public void deleteEmployee(String empNo) { empMap.remove(empNo); }
	  
	  public List<Employee> getAllEmployees() { Collection<Employee> c =
	  empMap.values(); List<Employee> list = new ArrayList<Employee>();
	  list.addAll(c); return list; }
	 */

	
	
	public Employee getEmployee(String empNo) {
		return jdbcTemplate.queryForObject("select * from employee t where t.empNo=?", new Object[] { empNo },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public int addEmployee(Employee emp) {
		return jdbcTemplate.update("insert into employee (empNo, empName, position) " + "values(?,  ?, ?)",
				new Object[] { emp.getEmpNo(), emp.getEmpName(), emp.getPosition() });
	}

	public int updateEmployee(Employee emp) {
		return jdbcTemplate.update("update employee " + "  empName = ? " + " position = ?" + " where id = ?",
				new Object[] { emp.getEmpName(), emp.getPosition(), emp.getEmpNo() });
	}

	public void deleteEmployee(String empNo) {
		jdbcTemplate.update("delete from employee t where t.empNo =?", new Object[] { empNo });
	}

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
