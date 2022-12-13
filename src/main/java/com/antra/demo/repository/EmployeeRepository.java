package com.antra.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antra.demo.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
