package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	/**
	 * 글 작성 페이지로 이동합니다.
	 * @return
	 */
	@GetMapping("/write")
	public String write() {
		logger.debug("write call");
		return " ";
	}
	
	/**
	 * 작성한 글을 등록 처리한 후 리스트 페이지로 이동합니다.
	 * @param boardDto
	 * @param session
	 * @param redirectAttributes
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/write")
//	public String write() throws Exception {
////		logger.debug("write boardDto : {}", boardDto);

//	
//		return "";
//	}
	
	
	/**
	 * 게시판 리스트 페이지로 이동 처리 합니다.
	 * @param map
	 * @return ModelAndView
	 * @throws Exception
	 */
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
//		logger.debug("list parameter pgno : {}", map.get("pgno"));

			
			return null;

	}
	
	
	
	/**
	 * 요청한 articleNo 정보로 글의 상세 정보를 보여줍니다.
	 * @param articleNo
	 * @param map
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/view")
	public String view() throws Exception {
//		logger.debug("view articleNo : {}", articleNo);

		
		return "";
	}
	
	/**
	 * 수정 페이지 요청이 오면, 수정 페이지로 이동합니다.
	 * @param articleNo
	 * @param map
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/modify")
	public String modify() throws Exception {

		return "";
	}
	
	/**
	 * 수정한 글 내용을 저장처리합니다.
	 * @param boardDto
	 * @param map
	 * @param redirectAttributes
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/modify")
//	public String modify() throws Exception {
////		logger.debug("modify boardDto : {}", boardDto);
////		boardService.modifyArticle(boardDto);
//		
//		return "";
//	}
	
	/**
	 * articleNo에 해당하는 글을 삭제 처리합니다.
	 * @param articleNo
	 * @param map
	 * @param redirectAttributes
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/delete")
	public String delete() throws Exception {

		
		return "";
	}
	
}