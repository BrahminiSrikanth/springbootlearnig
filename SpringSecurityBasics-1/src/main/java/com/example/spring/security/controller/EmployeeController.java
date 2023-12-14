package com.example.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.entity.Employee;
import com.example.spring.security.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final String AUTHORITY_ROLE_HR = "ROLE_HR";
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to javatechie";
	}
	@PostMapping("/create")
	//@PreAuthorize("hasAuthority('ROLE_HR')")
	public Employee onBoardnewEmployee(@RequestBody Employee emp) {
		emp.setRoles("ROLE_EMPLOYEE");
		return service.createNewEmployee(emp);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_HR')or hasAuthority('ROLE_MANAGER')")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
	public Employee getEmpById(@PathVariable("id") Integer id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_HR')")
	public Employee updateRoleEmployee(@RequestBody Employee employee) {
		return service.changeRoleOfEmployee(employee);
	}

}
