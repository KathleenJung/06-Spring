package com.ssafy.ws.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepo bookRepo;
	
	@Autowired
	public void setBookRepo(BookRepo bookRepo) {
		this.bookRepo=bookRepo;
	}
	
	public BookRepo getBookRepo() {
		return bookRepo;
	}
	
	
	@Override
	public int insert(Book book) throws SQLException{
		// TODO Auto-generated method stub
		return bookRepo.insert(book);
	}

	@Override
	public void update(Book book) throws SQLException {
		bookRepo.update(book);
	}

	@Override
	public int delete(String isbn) throws SQLException{
		// TODO Auto-genera	ted method stub
		return bookRepo.delete(isbn);
	}

	@Override
	public Book select(String isbn) throws SQLException{
		// TODO Auto-generated method stub
		return bookRepo.select(isbn);
	}

	@Override
	public List<Book> search() throws SQLException {
		// TODO Auto-generated method stub
		return bookRepo.search();
	}

}
