package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public User select(String id) {
		User user = userDao.select(id);
		int size = user.getPass().length();
		String pass = "";
		for (int i = 0; i < size; i++) {
			pass += "*";
		}
		user.setPass(pass);
		return user;
	}

}
