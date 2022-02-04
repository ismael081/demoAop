package com.example.demoAop.aop.infrastructure;

import com.example.demoAop.common.infrastructure.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Advice {
/*
    @Before(value = "execution(* com.example.demoAop.aop.*.*Impl*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logBefore(joinPoint.getSignature().toString(), joinPoint.getArgs());
    }

    @AfterThrowing(value = "execution(* com.example.demoAop.aop.*.*ImplCL.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        logException(joinPoint.getSignature().toString(), ex.getMessage());
    }

    @AfterReturning(value = "execution(* com.example.demoAop.aop.*.*Impl*.*(..))", returning = "returned")
    public void afterAdvice(JoinPoint joinPoint, Object returned) {
        logAfterReturn(joinPoint.getSignature().toString(), returned.toString());
    }
*/

    @Around("execution(* com.example.demoAop.aop.*.*Impl*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodSignature =  joinPoint.getSignature().toString();

        logBefore(methodSignature, joinPoint.getArgs());

        Object response = null;
        try{
            response = joinPoint.proceed();
        }catch (Exception ex){
            logException(methodSignature, ex.getMessage());
            // remove throw to avoid propagate
            throw ex;
        }

        logAfterReturn(methodSignature, (response !=null ? response.toString(): null));

        return response;
    }


    private void logBefore(String signature, Object[] args){
        Logger.info("Before method:" + signature);
        Logger.info("Parameters: ");
        Arrays.stream(args)
                .map(p-> p!=null ? p.toString() : "null")
                .forEach(Logger::info);
        Logger.info("----------------------------");
    }

    private void logException(String signature, String message){
        Logger.error("After throwing an exception by: " + signature + ", Exception: " + message);
    }

    private void logAfterReturn(String signature, String returned){
        Logger.info("After method:" + signature);
        Logger.info("Return: " + returned);
        Logger.info("----------------------------");
    }
}
