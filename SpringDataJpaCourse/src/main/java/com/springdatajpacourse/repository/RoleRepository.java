package com.springdatajpacourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpacourse.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles,Long> {

}
