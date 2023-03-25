package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.VenueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue,String> {
    Venue findVenueByIdAndPassword(String id,String pass);
    Venue findVenueById(String id);
}
