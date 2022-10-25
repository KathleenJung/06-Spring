package com.ssafy.hw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

// 컨트롤러 전역에서 발생하는 예외를 처리하는 부기가능을 가진 클래스(어드바이스)
@ControllerAdvice
public class ExceptionController {

	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	// 예외를 어떻게 처리할지 정의
	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception e) {
		logger.error("예외 발생", e.getCause());
		e.printStackTrace();

		// 파라미터 바인딩 예외 발생시
		if (e instanceof BindException) {
			model.addAttribute("message", "파라미터가 잘 등록되지 않았습니다.");
		}

		return "/error/errorpage";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		logger.error("404 발생 : {}", "404 page not found");
		model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다!!!");
		return "error/404";
	}
}
