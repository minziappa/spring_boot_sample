package io.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@AfterReturning("execution(* io..impl.*.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		logger.info("This is aspect");
	}

}
