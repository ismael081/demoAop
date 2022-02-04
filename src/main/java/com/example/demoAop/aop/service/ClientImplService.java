package com.example.demoAop.aop.service;

import com.example.demoAop.aop.domain.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("clientServiceAOP")
public class ClientImplService {
    @Qualifier("clientDaoAop")
    private ClientImplDAO clientImplDAO;

    public ClientImplService(ClientImplDAO clientImplDAO) {
        this.clientImplDAO = clientImplDAO;
    }

    public void test(){
        System.out.println("Test service");
    }

    public Client getClient(int id){
        return clientImplDAO.getClient(id);
    }
}
