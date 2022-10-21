package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.controller.HomeController;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DBUtil;

@Repository
public class UserRepoImpl implements UserRepo {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	DataSource ds;
	@Autowired
	DBUtil dbUtil;
	
	
	@Override
	public User login(User user) throws SQLException {
		logger.debug("[위치:repoImpl.login()] 메서드 시작, 받은 파라미터 확인: {}", user);
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
			logger.debug("[위치:repoImpl.login()] finally! 언제나 찍어요");
		}
		logger.debug("[위치:repoImpl.login()] 리턴 나가기 전");
		return userinfo;

	}


}
