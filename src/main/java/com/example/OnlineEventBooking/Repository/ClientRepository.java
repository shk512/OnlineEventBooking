package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByPersonInfo_Contact(String contact);
}
