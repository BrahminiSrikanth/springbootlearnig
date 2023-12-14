package com.brahmini.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	public static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Bill",LocalDate.now().minusYears(31)));
		users.add(new User(3,"Cherry",LocalDate.now().minusYears(32)));
		users.add(new User(4,"Daniel",LocalDate.now().minusYears(33)));
		users.add(new User(5,"Emma",LocalDate.now().minusYears(34)));
		
	}
	private static int idcount=5;
	public List<User> findAll(){
		return users;
	}
	public User findOne(int id) {
		
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	
	}
	public User save(User user) {
        user.setId(++idcount);
        users.add(user);
		return user;
	}
	public void deleteById(int id) {
		
		users.removeIf(user->user.getId().equals(id));
	}

}
