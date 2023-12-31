package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Method will execute");
        proceedingJoinPoint.proceed();
        logger.info("Method executed");
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
