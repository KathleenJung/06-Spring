package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.UserRepo;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;

public class WS_01_BeanCreationTest extends AbstractTest {
//	로깅 처리
	private static Logger logger = LoggerFactory.getLogger(WS_01_BeanCreationTest.class);
	
	@Autowired
	BookRepo brepo;
	@Autowired
	BookService bserv;
	@Autowired
	UserRepo urepo;
	@Autowired
	UserService userv;
	@Autowired
	DataSource ds;
	
//	1. ii. BookRepo, UserRepo, BookService, UserService가 잘 생성되었는가?
	@Test
	public void testBeanCreation() {
		assertNotNull(brepo);
		assertNotNull(bserv);
		assertNotNull(urepo);
		assertNotNull(userv);
	}
	
//	2. iii. 컨텍스트에서 직접 얻어온 BookRepo와 BookService가 가지는 repo가 동일한가?
	@Test
	public void testSingleton() {
		logger.debug("BookService:{}", bserv.getClass().getName());
		assertEquals(brepo, ((BookServiceImpl) bserv).getBookRepo());
	}
	
//	3. iv. DataSource객체가 잘 생성되었는지 테스트하고 출력한다.
	@Test
	public void testDataSource() {
		logger.debug("datasource? {}", ds);
		assertNotNull(ds);
	}
}
