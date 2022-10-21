package com.ssafy.ws.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping({"/", "/index"})
	public String Root() {
		return "index";
	}
	
	@RequestMapping("/error/404")
	public String error404() {
		return "error/404";
	}
	
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, HttpSession session, Model model ) throws SQLException {
		logger.debug("[위치:controller.doLogin()] 메서드 시작, 파라미터 확인 : {}", user);
		User userInfo = userService.login(user);
		logger.debug("[위치:controller.doLogin()]메서드 종료");
		if(userInfo != null) {
			session.setAttribute("loginUser", userInfo);
			return "redirect:/";
			} else {
				model.addAttribute("msg", "로그인 실패");
				return "index";
			}
	}
	

	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("/list")
	public String showList(Model model) throws SQLException {
		List<Book> books = bookService.search();
		model.addAttribute("books", books);
		return "list";
	}
	
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Book book) throws SQLException {
		int result = bookService.insert(book);
		return "regist_result";
	}
	
	@GetMapping("/update")
	public String showUpdate(String isbn, Model model) throws Exception{
		Book book = bookService.select(isbn);
		model.addAttribute("book", book);
		return "update";
	}
	
	@PostMapping("/update")
	public String doUpdate(Book book) throws Exception{
		bookService.update(book);
		return "redirect:/list";
	}
	
	@GetMapping("/del")
	public String doDelete(String isbn) throws Exception{
		bookService.delete(isbn);
		return "redirect:/list";
	}
	
	@RequestMapping("/error/commonerr")
	public String showError500() {
		return "error/commonerr";
	}
	
	
	
}
