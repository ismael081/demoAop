package com.example.demoAop.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ClientImplService {
    public void test(){
        System.out.println("Test service");
    }
}
