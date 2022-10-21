package com.ssafy.ws.model.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.controller.HomeController;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserRepo userRepo;
	
	

	public UserRepo getUserRepo() {
		return userRepo;
	}
//	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Autowired
	public UserServiceImpl(UserRepo repo) {
		this.userRepo = repo;
	}

	@Override
	public User login(User user) throws SQLException {
		logger.debug("[위치:service.login()] 메서드 시작, 받은 파라미터 확인: {}", user);
		User user2 = userRepo.login(user);
		logger.debug("[위치:service.login()] 리턴 나기 전");
		return user2;
	}

}
