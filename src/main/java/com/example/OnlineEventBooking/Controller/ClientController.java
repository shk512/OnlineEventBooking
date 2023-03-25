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

    @PostMapping("/signup")
    private String saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }
    @PutMapping("/update")
    private String updateClient(@RequestBody ClientModel clientModel){
        return clientService.updateClient(clientModel);
    }
    @DeleteMapping("/delete/{id}")
    private String deleteClient(@PathVariable(name = "id") String clientId){
        return clientService.deleteClient(clientId);
    }
    @GetMapping("/{id}")
    private ClientModel getClientById(@PathVariable(name = "id")String clientId){
        return clientService.getClient(clientId);
    }
}
