package com.example.user.log;

import org.aspectj.lang.annotation.AfterReturning;
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

    // Pointcut cho tất cả các phương thức trong package service
    @Pointcut("execution(* com.example.user.service.impl..*(..))")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logBefore() {
        logger.info("One method is called");
    }

    @AfterReturning("serviceMethods()")
    public void logAfterReturning() {
        logger.info("One method executed");
    }
}
