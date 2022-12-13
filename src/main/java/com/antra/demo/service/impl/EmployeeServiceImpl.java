package com.antra.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antra.demo.Exception.EmployeeNotFoundException;
import com.antra.demo.entity.EmployeeEntity;
import com.antra.demo.model.Employee;
import com.antra.demo.repository.EmployeeRepository;
import com.antra.demo.service.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		repository.save(entity);
		return employee;
	}

	@Override
	public Employee fetchById(Integer empId) {
		if(repository.existsById(empId)) {
			Employee employee=new Employee();
			EmployeeEntity enity=new EmployeeEntity();
			BeanUtils.copyProperties(enity, employee);
			return employee;
		}
		else {
			throw new EmployeeNotFoundException("Employee Doesn't Exist :"+empId);
		}
		
	}

	@Override
	public List<Employee> fetchAll() {
		
		List<EmployeeEntity> lstOfEntity=repository.findAll();
		
		List<Employee> lstOfModels=new ArrayList<>(); 
		
		lstOfEntity.forEach(entity->{
			Employee employee=new Employee();
			BeanUtils.copyProperties(entity, employee);
			lstOfModels.add(employee);
		});
		return lstOfModels;
	}

	@Override
	public String deleteById(Integer empId) {
		
		if(repository.existsById(empId)) {
			repository.deleteById(empId);
			return "Employee Deleted Successfully"+empId;
		}
		else {
			throw new EmployeeNotFoundException("Employee Doesn't Exist With This Id :"+empId);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(repository.existsById(employee.getEmpId())) {
			EmployeeEntity entity=new EmployeeEntity();
			BeanUtils.copyProperties(employee, entity);
			repository.save(entity);
			return employee;
		}
		else {
			throw new EmployeeNotFoundException("Employee Doesn't Exist With This Id :"+employee.getEmpId());
		}
		
	}

}
