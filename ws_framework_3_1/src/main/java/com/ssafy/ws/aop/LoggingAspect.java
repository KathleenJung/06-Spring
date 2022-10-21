package com.ssafy.ws.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.ssafy.ws.model..*.*(..))")
	public void logging(JoinPoint jp) {
//		getSignature() : 메서드 선언 부 정보를 반환
//		.getArgs() : 메서드에 전달된 파라미터 정보를 배열로 반환하는 역할
		logger.debug("메서드선언부:{} 전달 파라미터:{}",jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
}
