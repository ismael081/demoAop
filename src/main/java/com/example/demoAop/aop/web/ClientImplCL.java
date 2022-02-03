package com.example.demoAop.aop.web;

import com.example.demoAop.aop.service.ClientImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientImplCL {

    private ClientImplService clientImplService;

    public ClientImplCL(ClientImplService clientImplService) {
        this.clientImplService = clientImplService;
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("Test");
        clientImplService.test();
    }
}
