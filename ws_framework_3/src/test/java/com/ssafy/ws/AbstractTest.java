package com.ssafy.ws;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


// 테스트 만들때마다 들어가야하는 부분이라서, 재활용하기 위해 만듦

// Spring과 연동하기 위해 SprintRunner를 사용한다.
@RunWith(SpringRunner.class)
// 설정 파일의 위치를 지정한다.
//@ContextConfiguration(locations = "/application.xml")
//@ContextConfiguration(classes = ApplicationConfig.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public abstract class AbstractTest {
}
