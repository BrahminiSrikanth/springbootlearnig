package com.javatechie.springdataredis.hash;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Customer")
public class Customer implements Serializable{
	private static final long serialVersionUID=1L;
    @Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dob;
	private String phone;
	
	
	
}
