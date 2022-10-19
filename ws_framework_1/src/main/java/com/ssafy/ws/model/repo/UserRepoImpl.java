package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DBUtil;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	DataSource ds;
	private DBUtil dbUtil;

	@Override
	public User select(String id) throws SQLException {
		User user = new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();

			String sql = "SELECT id, name, pass, rec_id FROM user where id = ? ";
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setRecId(rs.getString("rec_id"));
			}
		} finally {
			dbUtil.close(pstmt);
		}
		return user;
	}

}
