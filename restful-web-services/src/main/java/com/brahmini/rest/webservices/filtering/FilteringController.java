package com.brahmini.rest.webservices.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping(path="/filtering")
	public SomeBean filtering() {
		
		return new SomeBean("value1","value2","value3");		
	}
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> filteringList() {
		
		return List.of( new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"), new SomeBean("value7","value8","value9")) ;	
	}

	//DynamicFiltering
	
	@GetMapping(path="/dynamicfiltering")
	public MappingJacksonValue dynamicfiltering() {
		SomeBean someBean =  new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonvalue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mappingJacksonvalue.setFilters(filters);
		return mappingJacksonvalue;
	
		//return new SomeBean("value1","value2","value3");		
	}
	
	@GetMapping(path="/dynamicfiltering-list")
	public MappingJacksonValue dynamicfilteringList() {
		List someBeanList = List.of( new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"), new SomeBean("value7","value8","value9")) ;	
		MappingJacksonValue mappingJacksonvalue = new MappingJacksonValue(someBeanList);
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mappingJacksonvalue.setFilters(filters);
		return mappingJacksonvalue;
	}

	

}
