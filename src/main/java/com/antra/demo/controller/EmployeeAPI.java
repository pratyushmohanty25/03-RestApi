package com.antra.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antra.demo.model.Employee;
import com.antra.demo.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class EmployeeAPI {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping(value="/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		service.saveEmployee(employee);
		log.info("Added sucessfully id{}"+employee.getEmpId());
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> lstOfEmployee=service.fetchAll();
		return ResponseEntity.ok(lstOfEmployee);
	}
	
	@GetMapping(value="/employee/get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Integer id){
		Employee employee=service.fetchById(id);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping(value="/employee/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		service.deleteById(id);
		String message="Employee Deleted SuccessFully"+id;
		return ResponseEntity.ok(message);	
	}
	
	@PutMapping(value="employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		service.updateEmployee(employee);
		log.info("Employee Updated id{}"+employee.getEmpId());
		return ResponseEntity.ok(employee);
	}
}
