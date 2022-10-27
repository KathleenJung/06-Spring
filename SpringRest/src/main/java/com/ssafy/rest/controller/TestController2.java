package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.Member;

@RestController
@RequestMapping("/rest2")
public class TestController2 {

	@GetMapping("/test1")
	public String test1() {
		return "hi rest";
	}

	@GetMapping("/test2")
	public Member test2() {
		Member m = new Member();
		m.setId("sbc");
		m.setName("손병찬");
		m.setEmail("sbc2@navar.com");
		return m;
	}
	
	@GetMapping("/test3")
	public List<Member> test3() {
		List<Member> list = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Member m = new Member();
			m.setId("sbc" + i);
			m.setName("손병찬" + i);
			m.setEmail("sbc2@navar.com" + i);
			list.add(m);
		}
		return list;
	}
}
