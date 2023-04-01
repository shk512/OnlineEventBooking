package com.example.OnlineEventBooking.Model;
import com.example.OnlineEventBooking.Entity.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ClientModel {
    private Long id;
    private PersonInfoModel personInfoModel;
    public ClientModel(Client client){
        this.setId(client.getId());
        this.setPersonInfoModel(new PersonInfoModel(client.getPersonInfo()));
    }
    public Client dissamble() {
        Client client = new Client();
        client.setId(id);
        client.setPersonInfo(personInfoModel.dissamble());
        return client;
    }
}
