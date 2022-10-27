package com.ssafy.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.Member;

@RestController
@RequestMapping("/rest4")
public class TestController4 {
	
	@GetMapping("/test1/{id}")
	public String test1(@PathVariable("id") String id) {
		return id;
	}
	
	@PostMapping("/test2")
	public Member test2(@RequestBody Member m) {
		return m;
	}
	
	// ResponseEntity : 응답하려는 데이터 + 응답코드 + 응답헤더 조작 가능
	// ResponseEntity<T> : T <- Body 에 들어갈 데이터의 타입
	@PostMapping("/test3")
	public ResponseEntity<Member> test3(@RequestBody Member m) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "12341234");
		return new ResponseEntity<Member>(m, headers, HttpStatus.OK);
	}
}