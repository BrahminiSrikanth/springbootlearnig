package com.brahmini.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal converisonMultiple;
	private BigDecimal qunatity;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	public CurrencyConversion(Long id, String from, String to, BigDecimal converisonMultiple, BigDecimal qunatity,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.converisonMultiple = converisonMultiple;
		this.qunatity = qunatity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}
	public CurrencyConversion() {
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
	public BigDecimal getQunatity() {
		return qunatity;
	}
	public void setQunatity(BigDecimal qunatity) {
		this.qunatity = qunatity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ converisonMultiple + ", qunatity=" + qunatity + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", environment=" + environment + "]";
	}

	

}
