package com.ssafy.ws.controller;

import java.net.BindException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 전역 레벨에서 서버 오류를 처리하기 위해 @ControllerAdvice를 사용한다.
 */
@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * 모든 예외를 rough하게 처리하기 위해 Exception 클래스를 처리하도록 설계한다. 해커 공격의 빌미를 제공할 수 있음으로 서버에서
	 * 발생한 구체적인 오류를 표시하지는 않는다. 하지만 사용자에게 알려줘야할 내용이 있다면 표시해주어야 한다.
	 * 
	 * @param e
	 * @return
	 */

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Exception 발생 : {}", e.getMessage());
		model.addAttribute("errmsg", "파라미터가 잘 전달되었는지 확인하세요.");
		return "error/commonerr";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		logger.error("404 발생 : {}", "404 page not found");
		model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다!!!");
		return "error/404";
	}

}
