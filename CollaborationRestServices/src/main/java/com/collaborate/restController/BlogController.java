package com.collaborate.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController 
{
	@GetMapping(value="/test")
	public ResponseEntity<String>testMethod()
	{
		System.out.println("test method");
		return new ResponseEntity<String>("Test RestController", HttpStatus.OK);
	}

}
