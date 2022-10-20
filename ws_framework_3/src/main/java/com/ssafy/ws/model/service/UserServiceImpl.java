package com.ssafy.ws.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

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
		// TODO Auto-generated method stub
		return userRepo.login(user);
	}

}
