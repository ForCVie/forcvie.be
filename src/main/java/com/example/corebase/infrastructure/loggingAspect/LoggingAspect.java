package com.example.corebase.infrastructure.loggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.corebase.core..*(..))")
    public void applicationServiceMethods() {}

    @Before("applicationServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Start method: " + joinPoint.getSignature().getName());
        logger.info("Method arguments: " + joinPoint.getArgs());
    }

    @After("applicationServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("End method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "applicationServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method " + joinPoint.getSignature().getName() + " returned: " + result);
    }

    @AfterThrowing(pointcut = "applicationServiceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Method " + joinPoint.getSignature().getName() + " threw: " + error);
    }
}
