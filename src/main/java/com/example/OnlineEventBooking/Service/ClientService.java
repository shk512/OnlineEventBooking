package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientInterface;

    @Transactional
    public String saveClient(Client client){
        clientInterface.save(client);
        return  "Success";
    }

    @Transactional
    public String deleteClient(String clientId){
        clientInterface.deleteById(clientId);
        return "Deleted";
    }

}
