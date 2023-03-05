package com.example.OnlineEventBooking.Controller;
import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

}
