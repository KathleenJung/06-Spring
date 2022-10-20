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

	DataSource ds;
	DBUtil dbUtil;
	@Autowired
	public UserRepoImpl(DataSource ds, DBUtil dbUtil) {
		super();
		this.ds = ds;
		this.dbUtil = dbUtil;
	}




	@Override
	public User login(User user) throws SQLException {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		User userinfo=null;
		try {
			conn = ds.getConnection();
			String sql = "select id, name, rec_id "
					+ "from user "
					+ "where id =? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userinfo = new User();
				userinfo.setId(rs.getString("id"));
				userinfo.setName(rs.getString("name"));
				userinfo.setRecId(rs.getString("rec_id"));
			}
		}finally {
			dbUtil.close(rs,pstmt, conn);
		}
		
		return userinfo;

	}


}
