package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Model.ClientModel;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Transactional
    public ClientModel saveClient(ClientModel clientModel){
        ClientModel responseModel;
        Client client=searchClient(clientModel.getPersonInfoModel().getContact());
        if(client!=null){
            responseModel=new ClientModel(clientRepository.save(clientModel.dissamble()));
        }
        else {
            responseModel=new ClientModel(clientRepository.save(clientModel.dissamble()));
        }
        return responseModel;
    }
    @Transactional
    public List<ClientModel> getClient(Long clientId){
        List<ClientModel> clientModelList;
        if(clientId!=null){
            clientModelList=clientRepository.findById(clientId).stream().map(ClientModel::new).collect(Collectors.toList());
        }else {
            clientModelList=clientRepository.findAll().stream().map(ClientModel::new).collect(Collectors.toList());
        }
        return clientModelList;
    }
    @Transactional
    public Client searchClient(String contact){
        return clientRepository.findClientByPersonInfo_Contact(contact);
    }
    @Transactional
    public String deleteClient(Long clientId){
        String result;
        if(clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
            result="Deleted";
        }else{
            result="Don't exists";
        }
        return result;
    }

}
