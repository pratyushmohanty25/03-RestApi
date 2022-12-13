package com.antra.demo.service;

import java.util.List;


import com.antra.demo.model.Employee;


public interface IEmployeeService {

	
	Employee saveEmployee(Employee employee);
	
	Employee fetchById(Integer id);
	
	List<Employee> fetchAll();
	
	String deleteById(Integer id);
	
	Employee updateEmployee(Employee employee);
	
}
