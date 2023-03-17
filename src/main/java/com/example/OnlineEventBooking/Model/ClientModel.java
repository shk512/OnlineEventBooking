package com.example.OnlineEventBooking.Model;
import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Entity.PersonInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClientModel {
    private String clientId;
    private PersonInfoModel personInfoModel;

    public Client dissamble(){
        Client client=new Client();

        client.setClientId(clientId);
        client.setPersonInfo(personInfoModel.dissamble());

        return client;
    }
    public ClientModel assemble(Client client){
        ClientModel clientModel=new ClientModel();

        clientModel.setClientId(client.getClientId());
        clientModel.setPersonInfoModel(personInfoModel.assemble(client.getPersonInfo()));

        return clientModel;
    }
}
