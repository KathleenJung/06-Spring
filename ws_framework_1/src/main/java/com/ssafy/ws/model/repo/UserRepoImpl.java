package com.ssafy.ws.model.repo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.User;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	DataSource ds;
	
	@Override
	public User select(String id) throws SQLException {
		User u = new User();
		String sql = "SELECT id, name, pass, rec_id FROM user where id = ? ";
		ds.getConnection();
		return null;
	}

}
