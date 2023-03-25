package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Model.ClientModel;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Transactional
    public String saveClient(ClientModel clientModel){
        String result;
        if(searchClient(clientModel.dissamble().getId())){
            result="Username already exists. Please find another one";
        }else {
            upsert(clientModel);
            result="Save Successfully";
        }
        return  result;
    }
    @Transactional
    public String updateClient(ClientModel clientModel){
        String result;
        if(searchClient(clientModel.dissamble().getId())){
            upsert(clientModel);
            result="Updated";
        }else{
            result="Oops! User not found.";
        }
        return result;
    }
    @Transactional
    public boolean searchClient(String  clientId){
        return clientRepository.existsById(clientId);
    }
    @Transactional
    public ClientModel upsert(ClientModel clientModel){
        return clientModel.assemble(clientRepository.save(clientModel.dissamble()));
    }
    @Transactional
    public ClientModel getClient(String id){
        ClientModel clientModel=new ClientModel();
        return clientModel.assemble(clientRepository.findClientById(id));
    }
    @Transactional
    public String deleteClient(String clientId){
        String result;
        if(searchClient(clientId)) {
            clientRepository.deleteById(clientId);
            result="Deleted";
        }else{
            result="Don't exists";
        }
        return result;
    }

}
