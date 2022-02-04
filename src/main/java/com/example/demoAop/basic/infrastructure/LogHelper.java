package com.example.demoAop.basic.infrastructure;

import com.example.demoAop.common.infrastructure.Logger;

import java.util.Arrays;

public class LogHelper {
    private static String getMethodInfo (Class<? extends Object> callerClass){
        return callerClass.getEnclosingMethod().toString();
    }

    public static void printLog(Class<?> callerClass, String...parameters){
        Logger.info("Before method: " + getMethodInfo(callerClass));
        Logger.info("Parameters: ");
        Arrays.stream(parameters).forEach(Logger::info);
        Logger.info("-----------------------------");
    }

    public static void printError(Class<? extends Object> callerClass, String error) {
        Logger.error("After throwing an exception by: " + getMethodInfo(callerClass) + ", Exception: " + error);
    }

    public static void logAfterReturn(Class<? extends Object> callerClass, String returned){
        Logger.info("After method:" + getMethodInfo(callerClass));
        Logger.info("Return: " + returned);
        Logger.info("----------------------------");
    }
}
