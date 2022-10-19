package com.ssafy.webmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.webmvc.model.HelloDto;
import com.ssafy.webmvc.model.ParameterDto;
import com.ssafy.webmvc.model.service.HelloService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}

//	페이지만 이동하기
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		HelloDto helloDto = new HelloDto();
		helloDto.setMessage("Hello Spring ?????");
		mav.addObject("hello", helloDto);
		mav.setViewName("step01/hello");
//		/WEB-INF/views/step01/hello.jsp
		return mav;
	}

//	service 이용하기
	@RequestMapping(value = "/hellomvc")
	public ModelAndView helloMvc() {
		ModelAndView mav = new ModelAndView();
		HelloDto helloDto = helloService.greeting();

		mav.addObject("hello", helloDto);
		mav.setViewName("step02/hello");

		return mav;
	}

//	setp03/form.jsp로 이동하기
	@RequestMapping("/parameter")
	public String parameter() {
		return "step03/form";
	}
	
	/**
	 * form 안의 name 속성과 동일하게 파라미터명을 설정해주면,
	 * 값이 자동으로 맞춰서 들어감(순서 상관없음)
	 * 그러나 권장하지 않음
	 * @param userid
	 * @param username
	 * @param area
	 * @return
	 */
	
//	@RequestMapping("/sendparam")
//	public String parameterTest(String userid, String username, String area) {
////		파라미터 소문자로 넣기
//		System.out.println("Parameter Test>> id = " + userid + " name = " + username + " area = " + area);
//		return "step03/form";
//	}
	
//	@RequestParam(파라미터명)의 형태로 앞에서 넘어오는 이름을 명시해주면 값 맞춰서 넣어줌
	@RequestMapping(value = "/sendparam", method = RequestMethod.GET)
	public String parameterTest(@RequestParam("userid")String userid, @RequestParam("username")String username, String area) {
		System.out.println("Parameter Test>> id = " + userid + " name = " + username + " area = " + area);
		return "step03/form";
	}
	
//	@RequestMapping(value = "/sendparam", method = RequestMethod.POST)
//	public String parameterTest(ParameterDto parameterDto) {
//		System.out.println("Parameter Test>> id = " + parameterDto.getUserid() + " name = " + parameterDto.getUsername() + " area = " + parameterDto.getFruit());
//		return "step03/form";
//	}
	
	@RequestMapping(value = "/sendparam", method = RequestMethod.POST)
	public String parameterTest(ParameterDto parameterDto, Model model) {
		System.out.println("Parameter Test>> id = " + parameterDto.getUserid() + " name = " + parameterDto.getUsername() + " area = " + parameterDto.getFruit());
		model.addAttribute("data", parameterDto);
//		forward
		return "step03/result";
	}

}
