package com.example.demoAop.aop.infrastructure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Before(value = "execution(* com.example.demoAop.aop.*.*ImplService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());
    }

    @AfterThrowing(value = "execution(* com.example.demoAop.aop.*.*ImplCL.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) throws Throwable {
        System.out.println("After throwing an exception by: " + joinPoint.getSignature() + ", Exception: " + ex.getMessage());
    }
}
