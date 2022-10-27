package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest3")
public class TestController3 {
	
	@GetMapping("/test")
	public String get() {
		System.out.println("GET 요청 들어옴");
		return "GET";
	}
	
	@PostMapping("/test")
	public String post() {
		System.out.println("POST 요청 들어옴");
		return "POST";
	}
	
	@PutMapping("/test")
	public String put() {
		System.out.println("PUT 요청 들어옴");
		return "PUT";
	}
	
	@DeleteMapping("/test")
	public String delete() {
		System.out.println("DELETE 요청 들어옴");
		return "DELETE";
	}
}







