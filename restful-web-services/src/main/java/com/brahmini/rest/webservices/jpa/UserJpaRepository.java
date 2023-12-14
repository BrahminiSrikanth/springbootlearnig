package com.brahmini.rest.webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brahmini.rest.webservices.user.User;

public interface UserJpaRepository extends JpaRepository<User,Integer> {

}
