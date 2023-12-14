package com.brahmini.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVerioningCntroller {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	

	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="/person",headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonrequestHeader() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path="/person",headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonrequestHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="/person/accept",produces ="application/vnd.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path="/person/accept",produces ="application/vnd.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAceptHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

	
}
