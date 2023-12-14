package com.springdatajpacourse.repository;

import javax.management.relation.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpacourse.entity.Roles;
import com.springdatajpacourse.entity.User;

@SpringBootTest
public class ManyToManyUnidirectionalMapping {
	
	@Autowired
	private UserRepository userRespoitory;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//@Test
	void saveUser() {
		User user = new User();
		user.setFirstName("Brahmini");
		user.setLastName("Basina");
		user.setEmail("brahminisrikanth@gmail.com");
		user.setPassword("secret");
		Roles admin =new Roles();
		admin.setName("ROLE_ADMIN");
		Roles customer = new Roles();
		customer.setName("ROLE_CUSTOMER");	
		user.getRoles().add(admin);
		user.getRoles().add(customer);
		userRespoitory.save(user);
	}
	//@Test
	void updateUser() {
		User user = userRespoitory.findById(1L).get();
		user.setLastName("Annamaneni");
		Roles roleUser = new Roles();
		roleUser.setName("ROLE_USER");
		user.getRoles().add(roleUser);
		userRespoitory.save(user);
	}
	
	//@Test
	void fetchUser() {
		User user = userRespoitory.findById(1L).get();
		System.out.println(user.getEmail());
		user.getRoles().forEach(System.out::println);
	}
	
	@Test
	void deleteUser() {
		userRespoitory.deleteById(1L);
	}

}
