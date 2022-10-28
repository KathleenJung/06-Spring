package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookapi")
@CrossOrigin("*")
public class BookRestController {

	private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

	@Autowired
	BookService bookService;

	@Autowired
	ResourceLoader resLoader;

	@GetMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 도서 정보를 반환한다.", response = Book.class)
	public ResponseEntity<?> select(@PathVariable String isbn) {
		Book book = bookService.select(isbn);
		if (book != null) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/book")
	@ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.", response = Book.class)
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		return null;
	}

	@PostMapping("/book")
	@ApiOperation(value = "Book 객체를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insert(@RequestBody Book book, @RequestPart(required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		if (file != null && file.getSize() > 0) {
			// 파일을 저장할 폴더 지정
			Resource res = resLoader.getResource("resources/upload");
			// 파일이 비어있다면 처리할 필요가 없다.
			// prefix를 포함한 전체 이름
			book.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			book.setOrgImg(file.getOriginalFilename());

			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + book.getImg()));
		}
		System.out.println(book.toString());
		bookService.insert(book);

		List<Book> books = bookService.selectAll();
		if (books != null && !books.isEmpty()) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/book")
	@ApiOperation(value = "Book 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody Book book, @RequestPart(required = false) MultipartFile file) {
		bookService.update(book);
		List<Book> books = bookService.selectAll();
		if (books != null && !books.isEmpty()) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/book/{isbn}")
	@ApiOperation(value = "Book 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String isbn) {
		bookService.delete(isbn);
		List<Book> books = bookService.selectAll();
		if (books != null && !books.isEmpty()) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<Book> books = bookService.selectAll();
		if (books != null && !books.isEmpty()) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return null;
	}
}
