package com.brahmini.rest.webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brahmini.rest.webservices.user.Post;

public interface PostJpaRepository extends JpaRepository<Post,Integer> {

}
