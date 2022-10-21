package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DBUtil;

@Repository

public class BookRepoImpl implements BookRepo {
	@Autowired
	DataSource ds;
	@Autowired
	DBUtil dbUtil;

	@Override
	public int insert(Book book) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		List<Book> books = new ArrayList<Book>();
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into book (isbn, title, author, price, content,img) "
					+ "values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getContent());
			pstmt.setString(6, book.getImg());
			result = pstmt.executeUpdate();
			conn.commit();
		}catch (Exception e){
			conn.rollback();
			throw e;

		}finally {
			dbUtil.close(pstmt, conn);
		}
		
		return result;

	}
	

	@Override
	public void update(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String sql = "update book "
					+ "set title=?, author =?, content=? "
					+ "where isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getContent());
			pstmt.setString(4, book.getIsbn());

			pstmt.executeUpdate();
			conn.commit();
		}catch (Exception e){
			conn.rollback();
			throw e;

		}finally {
			dbUtil.close(pstmt, conn);
		}

		
	}

	@Override
	public int delete(String isbn) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String sql = "delete from book "
					+ "where isbn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			result = pstmt.executeUpdate();
			conn.commit();
		}catch (Exception e){
			conn.rollback();
			throw e;

		}finally {
			dbUtil.close(pstmt, conn);
		}
		
		return result;
	}

	@Override
	public Book select(String isbn) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Book book = new Book();
		try {
			conn = ds.getConnection();
			String sql = "select isbn, title, author, price, content,img "
					+ "from book "
					+ " where isbn =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setContent(rs.getString("content"));
				book.setImg(rs.getString("img"));
			}
		}finally {
			dbUtil.close(rs,pstmt, conn);
		}
		
		return book;
	}

	@Override
	public List<Book> search() throws SQLException {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Book> books = new ArrayList<Book>();
		try {
			conn = ds.getConnection();
			String sql = "select isbn, title, author, price, content,img "
					+ "from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setContent(rs.getString("content"));
				book.setImg(rs.getString("img"));
				books.add(book);
			}
		}finally {
			dbUtil.close(rs,pstmt, conn);
		}
		
		return books;

	}
	

}
