package com.javatechie.springdataredis.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatechie.springdataredis.hash.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
