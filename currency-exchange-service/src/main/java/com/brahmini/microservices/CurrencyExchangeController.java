package com.brahmini.microservices;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable("from") String from,@PathVariable("to") String to ) {
		/*CurrencyExchange currencyExchange = new CurrencyExchange(10000l,from,to,BigDecimal.valueOf(55.18));
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));*/
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from,to);
		return currencyExchange;
		
	}
}
