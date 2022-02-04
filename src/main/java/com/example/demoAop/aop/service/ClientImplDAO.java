package com.example.demoAop.aop.service;

import com.example.demoAop.aop.domain.Client;
import org.springframework.stereotype.Component;

@Component("clientDaoAop")
public class ClientImplDAO {
    public Client getClient(int id){
        return new Client(id, "Mr Testing AOP");
    }
}
