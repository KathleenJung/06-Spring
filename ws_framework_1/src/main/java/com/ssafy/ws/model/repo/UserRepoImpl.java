package com.ssafy.ws.model.repo;

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
		User u = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			ds.getConnection();

			String sql = "SELECT id, name, pass, rec_id FROM user where id = ? ";
			pstmt = ds.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			while (rs.next()) {
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("pass"));
				u.setRecId(rs.getString("rec_id"));
			}
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt);
		}
		return u;
	}

}
