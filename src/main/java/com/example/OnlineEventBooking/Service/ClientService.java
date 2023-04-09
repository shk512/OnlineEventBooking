package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Model.ClientModel;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VenueService venueService;

    public List<VenueModel> getVenueList(Long venueId){
        return venueService.getVenue(venueId);
    }
    public ClientModel saveClient(ClientModel clientModel){
        ClientModel responseModel;
        Client client=searchClient(clientModel.getPersonInfoModel().getContact());
        if(client!=null){
            clientModel.setId(client.getId());
            responseModel=new ClientModel(clientRepository.save(clientModel.dissamble()));
        }
        else {
            responseModel=new ClientModel(clientRepository.save(clientModel.dissamble()));
        }
        return responseModel;
    }

    public List<ClientModel> getClient(Long clientId){
        List<ClientModel> clientModelList;
        if(clientId!=null){
            clientModelList=clientRepository.findById(clientId).stream().map(ClientModel::new).collect(Collectors.toList());
        }else {
            clientModelList=clientRepository.findAll().stream().map(ClientModel::new).collect(Collectors.toList());
        }
        return clientModelList;
    }

    public Client searchClient(String contact){
        return clientRepository.findClientByPersonInfo_Contact(contact);
    }


}
