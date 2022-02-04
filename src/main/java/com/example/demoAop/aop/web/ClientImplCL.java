package com.example.demoAop.aop.web;

import com.example.demoAop.aop.domain.Client;
import com.example.demoAop.aop.service.ClientImplService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("clientClAop")
public class ClientImplCL {
    @Qualifier("clientServiceAOP")
    private ClientImplService clientImplService;

    public ClientImplCL(ClientImplService clientImplService) {
        this.clientImplService = clientImplService;
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("Test");
        clientImplService.test();
    }

    @GetMapping("/boom")
    public void boom() throws Exception {
        System.out.println("exception");
        throw new Exception("Something crashed");
    }

    @GetMapping("/getClientAOP")
    public Client getClientAOP(Integer id) throws Exception {
        if(id==null){
            throw new Exception("ID missing");
        }

        return clientImplService.getClient(id);
    }
}
