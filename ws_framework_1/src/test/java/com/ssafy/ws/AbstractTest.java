package com.ssafy.ws;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// 테스트 만들 때마다 들어가야 하는 부분이기 때문에 재활용하기 위해 만듬

// Spring과 연동하기 위해 SpringRunner 사용
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/application.xml")
public class AbstractTest {
	
}
