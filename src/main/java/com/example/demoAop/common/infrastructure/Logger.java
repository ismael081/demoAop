package com.example.demoAop.common.infrastructure;

public class Logger {
    private static final String LEVEL_INFO = "INFO";
    private static final String LEVEL_ERROR = "ERROR";

    public static void info(String msg){
        trace(LEVEL_INFO, msg);
    }

    public static void error(String msg){
        trace(LEVEL_ERROR, msg);
    }

    public static void trace(String level, String msg){
        System.out.println("["+level+"] " + msg);
    }
}
