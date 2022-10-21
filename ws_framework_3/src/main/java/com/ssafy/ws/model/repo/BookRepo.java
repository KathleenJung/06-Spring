package com.ssafy.ws.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookRepo {
	int insert(Book book) throws SQLException;
	void update(Book book) throws SQLException;
	int delete(String isbn) throws SQLException;
	Book select(String isbn) throws SQLException;
	List<Book> search() throws SQLException;

}
