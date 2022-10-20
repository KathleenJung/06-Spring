package com.ssafy.ws;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;

public class WS_02_AOPTest extends AbstractTest {
	private static Logger logger = LoggerFactory.getLogger(WS_02_AOPTest.class);
	
	@Autowired
	BookService bookservice;
	@Autowired
	BookRepo brepo;
	
//	bookService의 메소드를 호출하면 AOP가 적용되어 있을까?
	@Test
	public void testInsert() throws SQLException {
		//DEBUG: 메서드 선언부 : ~~~~ 파라미터 :~~~~
		bookservice.insert(null);
		bookservice.select("111111111");
		bookservice.search();
	}
	@Test
	public void testAspect() {
		logger.debug("BookService :{} ",bookservice.getClass().getName());
//		assertEquals(brepo, ((BookServiceImpl) bookservice).getBookRepo());
		logger.debug("BookService:{},{},{}", new Object[] {
				bookservice.getClass().getName(), 
				bookservice instanceof BookService,
				bookservice instanceof BookServiceImpl});
	
	}

}
