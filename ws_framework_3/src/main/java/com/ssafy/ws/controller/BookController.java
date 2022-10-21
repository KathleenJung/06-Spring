package com.ssafy.ws.controller;

import java.util.List;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class BookController {

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String Root() {
		return "index";
	}

	@GetMapping("/list")
	public ModelAndView list() throws SQLException {
		ModelAndView mav = new ModelAndView();

		List<Book> books = bookService.search();

		mav.addObject("books", books);
		mav.setViewName("list");

		return mav;
	}

	@GetMapping("regist")
	public String regist() {
		return "regist";
	}

	@PostMapping("regist")
	public String regist(Book book, Model model) throws Exception {
		try {
		bookService.insert(book);
		} catch (Exception e) {
//			model.addAttribute("errmsg", "파라미터가 잘 전달되었는지 확인하세요.");
			throw e;
		}
		model.addAttribute("book", book);

		return "regist_result";
	}

	@GetMapping("update")
	public String update() {
		return "update";
	}

	@PostMapping("update")
	public String update(Book book) throws SQLException {
		bookService.update(book);

		// 리스트로
		return "redirect:list";
	}

	@GetMapping("del")
	public String delete(@RequestParam("isbn") String isbn) throws SQLException {
		
		bookService.delete(isbn);
		
		// 리스트로
		return "redirect:list";
	}

	@PostMapping("/login")
	public String login(User loginUser, HttpSession session) throws SQLException {

		User user = userService.login(loginUser);

		if (user != null) {
			session.setAttribute("loginUser", user);
		}

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}
}
