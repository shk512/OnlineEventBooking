package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,String> {
}
