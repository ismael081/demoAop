package com.example.demoAop.aop.infrastructure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Before(value = "execution(* com.example.demoAop.aop.service.ClientImplService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());

        //System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }
}
