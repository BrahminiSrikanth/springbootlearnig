package com.example.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import com.example.spring.security.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Optional<Employee> findByUserName(String username);

}
