package com.brahmini.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy curexProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCureencyConversion(@PathVariable("from") String from,@PathVariable("to") String to,@PathVariable BigDecimal quantity) {
		HashMap<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from",from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> currencyConversion = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class, uriVariables);
		CurrencyConversion currconv  = currencyConversion.getBody();
		
		System.out.println("Recived currconv object is"+currconv.toString());
		//return new CurrencyConversion(currconv.getId(),from,to,currconv.getConversionMultiple(),quantity,quantity.multiply(currconv.getConversionMultiple()),currconv.getEnvironment());
		return new CurrencyConversion(currconv.getId(),from,to,currconv.getConverisonMultiple(),quantity,quantity.multiply(currconv.getConverisonMultiple()),currconv.getEnvironment());
		
		//return new CurrencyConversion(1002l,from,to,BigDecimal.valueOf(55.5),quantity,quantity.multiply(BigDecimal.valueOf(55.5)), "");
	}

	@GetMapping("/currency-conversionfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCureencyConversionFeign(@PathVariable("from") String from,@PathVariable("to") String to,@PathVariable BigDecimal quantity) {
	
		
		CurrencyConversion currconv  = curexProxy.retrieveExchange(from, to);
		
		System.out.println("Recived currconv object is"+currconv.toString());
		//return new CurrencyConversion(currconv.getId(),from,to,currconv.getConversionMultiple(),quantity,quantity.multiply(currconv.getConversionMultiple()),currconv.getEnvironment());
		return new CurrencyConversion(currconv.getId(),from,to,currconv.getConverisonMultiple(),quantity,quantity.multiply(currconv.getConverisonMultiple()),currconv.getEnvironment());
		
		//return new CurrencyConversion(1002l,from,to,BigDecimal.valueOf(55.5),quantity,quantity.multiply(BigDecimal.valueOf(55.5)), "");
	}
	
}
