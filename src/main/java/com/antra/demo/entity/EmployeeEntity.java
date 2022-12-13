package com.antra.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="emp")
public class EmployeeEntity {
	
	@Id
	private Integer empId;
	
	private String ename;
	
	private Double eSal;
	
	private String deptNo;
	

}
