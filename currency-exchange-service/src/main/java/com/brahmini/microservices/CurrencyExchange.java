package com.brahmini.microservices;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {
	@Id
	private Long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	private BigDecimal converisonMultiple;
	private String environment;
	public CurrencyExchange(Long id, String from, String to, BigDecimal converisonMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.converisonMultiple = converisonMultiple;
	}
	public CurrencyExchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConverisonMultiple() {
		return converisonMultiple;
	}
	public void setConverisonMultiple(BigDecimal converisonMultiple) {
		this.converisonMultiple = converisonMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	
	

}
