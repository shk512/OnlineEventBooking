package com.example.OnlineEventBooking.Model;
import com.example.OnlineEventBooking.Entity.Client;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClientModel {
    private String id;
    private PersonInfoModel personInfoModel;
    public Client dissamble(){
        Client client=new Client();
        client.setId(id);
        client.setPersonInfo(personInfoModel.dissamble());
        return client;
    }
    public ClientModel assemble(Client client){
        ClientModel clientModel=new ClientModel();
        PersonInfoModel personInfoModel1=new PersonInfoModel();
        clientModel.setId(client.getId());
        clientModel.setPersonInfoModel(personInfoModel1.assemble(client.getPersonInfo()));
        return clientModel;
    }
}
