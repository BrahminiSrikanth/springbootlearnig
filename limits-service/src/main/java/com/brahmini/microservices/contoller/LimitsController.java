package com.brahmini.microservices.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brahmini.microservices.beans.Limits;
import com.brahmini.microservices.config.LimitServiceConfig;

@RestController
public class LimitsController {
	@Autowired
	private LimitServiceConfig serviceConfig;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(serviceConfig.getMinimum(),serviceConfig.getMaximum());
	}

}
