package com.example.demoAop.basic.web;

import com.example.demoAop.basic.domain.Client;
import com.example.demoAop.basic.infrastructure.LogHelper;
import com.example.demoAop.basic.service.ClientImplService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientImplCL {
    private ClientImplService clientImplService;

    public ClientImplCL(ClientImplService clientImplService) {
        this.clientImplService = clientImplService;
    }

    @GetMapping("/getClient")
    public Client getClient(Integer id) throws Exception {
        LogHelper.printLog(new Object(){}.getClass(), String.valueOf(id));

        if(id==null){
            LogHelper.printError(new Object(){}.getClass(), String.valueOf(id));
            throw new Exception("ID missing");
        }
        Client client = clientImplService.getClient(id);
        LogHelper.logAfterReturn(new Object(){}.getClass(), (client!=null ? client.toString(): "null"));
        return client;
    }
}
