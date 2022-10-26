package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bookDao;

	@Override
	public int insert(Book book) {
		return bookDao.insert(book);
	}

	@Override
	public int update(Book book) {
		return bookDao.update(book);
	}

	@Override
	public int delete(String isbn) {
		return bookDao.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
		return bookDao.select(isbn);
	}

	@Override
	public List<Book> selectAll() {
		return bookDao.selectAll();
	}

}
