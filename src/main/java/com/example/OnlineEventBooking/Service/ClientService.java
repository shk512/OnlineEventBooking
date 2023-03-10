package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientInterface;
    
    public int saveClient(Client client){
        clientInterface.save(client);
        return  client.getClientId();
    }


}
