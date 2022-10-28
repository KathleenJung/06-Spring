package com.ssafy.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	// resource 경로를 가져오기 위해 ResourceLoader를 주입 받는다.
	@Autowired
	ResourceLoader resLoader;
	
	@GetMapping("/mypage")
	public String mypage(@PathVariable("id") String userId) {
		return "user/mypage";
	}
}
