package com.example.OnlineEventBooking.Controller;
import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Model.ClientModel;
import com.example.OnlineEventBooking.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/save")
    private ClientModel saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }

    @DeleteMapping("/delete/{id}")
    private String deleteClient(@PathVariable("id") String clientId){
        return clientService.deleteClient(clientId);
    }

}
