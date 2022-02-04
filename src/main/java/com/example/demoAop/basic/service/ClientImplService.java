package com.example.demoAop.basic.service;

import com.example.demoAop.basic.domain.Client;
import com.example.demoAop.basic.infrastructure.LogHelper;
import org.springframework.stereotype.Service;

@Service
public class ClientImplService {
    private ClientImplDAO clientImplDAO;

    public ClientImplService(ClientImplDAO clientImplDAO) {
        this.clientImplDAO = clientImplDAO;
    }

    public void test(){
        System.out.println("Test service");
    }

    public Client getClient(int id){
        LogHelper.printLog(new Object(){}.getClass(), String.valueOf(id));

        Client client = clientImplDAO.getClient(id);

        LogHelper.logAfterReturn(new Object(){}.getClass(), (client!=null ? client.toString(): "null"));
        return client;
    }
}
