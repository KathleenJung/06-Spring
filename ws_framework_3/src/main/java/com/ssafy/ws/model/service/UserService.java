package com.ssafy.ws.model.service;

import java.sql.SQLException;

import com.ssafy.ws.dto.User;

public interface UserService {
	User login(User user) throws SQLException;
}
