package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Model.ClientModel;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientInterface;

    @Transactional
    public ClientModel saveClient(ClientModel clientModel){
        return  clientModel.assemble(clientInterface.save(clientModel.dissamble()));
    }

    @Transactional
    public String deleteClient(String clientId){
        clientInterface.deleteById(clientId);
        return "Deleted";
    }

}
