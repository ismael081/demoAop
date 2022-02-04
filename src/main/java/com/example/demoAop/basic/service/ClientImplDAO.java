package com.example.demoAop.basic.service;

import com.example.demoAop.basic.domain.Client;
import com.example.demoAop.basic.infrastructure.LogHelper;
import org.springframework.stereotype.Component;

@Component
public class ClientImplDAO {
    public Client getClient(int id){
        LogHelper.printLog(new Object(){}.getClass(), String.valueOf(id));

        Client client = new Client(id, "Mr Testing Basic");

        LogHelper.logAfterReturn(new Object(){}.getClass(), client.toString());
        return client;
    }
}
