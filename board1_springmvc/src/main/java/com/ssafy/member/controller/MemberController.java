package com.ssafy.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	/**
	 * 로그인한 유저의 아이디를 url로 받아와서 파라미터 값으로 넘겨줍니다. 비동기로, id 값을 체크합니다.
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{userid}")
	@ResponseBody
	public String idCheck(@PathVariable("userid") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = memberService.idCheck(userId);
		return cnt + "";
	}

	/**
	 * 회원가입 처리를 합니다. 메소드명 중복으로 에러 발생하여 주석처리 되어 있으므로 주석 해제 후 구현해주세요.
	 * 
	 * @param memberDto
	 * @param model
	 * @return String
	 */
	@PostMapping("/join")
	public String join(MemberDto memberDto, Model model) {
		logger.debug("memberDto info : {}", memberDto);
		try {
			int cnt = memberService.joinMember(memberDto);
			
			return "index";
		} catch (Exception e) {
			e.printStackTrace();

			return "error/error";
		}
	}

	/**
	 * 로그인 페이지로 이동합니다.(완성형태 )
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	/**
	 * 로그인 처리합니다.
	 * session에 로그인한 유저 정보를 셋팅합니다. 
	 * response에 세션 정보를 추가합니다.
	 * 	 * 메소드명 중복으로 에러 발생하여 주석처리 되어 있으므로 주석 해제 후 구현해주세요.
	 * @param map
	 * @param model
	 * @param session
	 * @param response
	 * @return
	 */
	

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		
		logger.debug("map : {}", map.get("userid"));
		
		try {
			MemberDto memberDto = memberService.loginMember(map);
			
			if(memberDto != null) {
				session.setAttribute("userinfo", memberDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "error/error";
		}
		
		return "index";
	}

	/**
	 * 로그아웃하고, 초기 요청 페이지 index로(redirect) 이동합니다.
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		
		return "index";
	}
}