package com.example.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.spring.security.entity.Employee;
import com.example.spring.security.repository.EmployeeRepository;

public class EmployeeUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> emp =empRepo.findByUserName(username);
		
	
		return emp.map(EmployeeUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException(username+" not found"));
	}
	

}
