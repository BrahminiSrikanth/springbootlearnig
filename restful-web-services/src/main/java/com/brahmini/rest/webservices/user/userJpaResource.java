package com.brahmini.rest.webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brahmini.rest.webservices.jpa.PostJpaRepository;
import com.brahmini.rest.webservices.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class userJpaResource {
	
	private UserDaoService service;
	private UserJpaRepository userJpaRepo;
	private PostJpaRepository postJparepo;
	
	public userJpaResource(UserDaoService service,UserJpaRepository userJpaRepo,PostJpaRepository postJparepo) {
		this.service = service;
		this.userJpaRepo = userJpaRepo;
		this.postJparepo = postJparepo;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userJpaRepo.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = userJpaRepo.findById(id) ;
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
			
		}
		EntityModel entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userJpaRepo.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		 User saveduser = userJpaRepo.save(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				       .path("/{id}")
				       .buildAndExpand(saveduser.getId())
				       .toUri();
		 return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsOfUser(@PathVariable int id){
		Optional<User> user = userJpaRepo.findById(id);
		if(user == null) {
			throw new UserNotFoundException("User not exists for id :"+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> retrievePostsOfUser(@PathVariable int id,@Valid @RequestBody Post post){
		Optional<User> user = userJpaRepo.findById(id);
		if(user == null) {
			throw new UserNotFoundException("User not exists for id :"+id);
		}
		post.setUser(user.get());
		Post savedPost = postJparepo.save(post);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			       .path("/{id}")
			       .buildAndExpand(savedPost.getId())
			       .toUri();
	 return ResponseEntity.created(location).build();
		
		
		
	}
}
