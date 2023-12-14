package com.brahmini.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.brahmini.microservices.CurrencyExchange;

//@FeignClient(name="currency-exchange",url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchange(@PathVariable("from") String from,@PathVariable("to") String to);
}
