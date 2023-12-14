package com.example.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring.security.entity.Employee;
import com.example.spring.security.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final String DEFAULT_ROLE="ROLE_EMPLOYEE";
	
	public Employee createNewEmployee(Employee emp) {
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));
		emp.setRoles(DEFAULT_ROLE);
		return employeeRepo.save(emp);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found With Id"+id));
	}
	
	public Employee changeRoleOfEmployee(Employee employee) {
		Employee existingemp=getEmployeeById(employee.getId());
		existingemp.setRoles(employee.getRoles());
		return employeeRepo.save(existingemp);
	}

}
